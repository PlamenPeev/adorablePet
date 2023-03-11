package com.example.adorablepet.config;

import com.example.adorablepet.models.enums.RoleEnumName;
import com.example.adorablepet.repository.UserRepository;
import com.example.adorablepet.service.ApplicationUserDetailsService;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.context.DelegatingSecurityContextRepository;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.RequestAttributeSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;

import java.security.Principal;


@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http,
                                           SecurityContextRepository securityContextRepository) throws Exception {
        http.
                // defines which pages will be authorized
                        authorizeHttpRequests().
                // allow access to all static files (images, CSS, js)
                        requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll().
                        requestMatchers("/", "/users/login", "/users/register", "/users/login-error",
                        "/pages/departments","/pages/departments-more-info","/pages/our-team",
                        "/pages/information","/pages/clinic-services", "/pages/good-heart", "/pages/projects").permitAll().
                // only for moderators
                        requestMatchers("/pages/moderators").hasRole(RoleEnumName.MODERATOR.name()).
                // only for admins
                        requestMatchers("/pages/admins").hasRole(RoleEnumName.ADMIN.name()).
                anyRequest().authenticated().
                and().
                // configure login with HTML form
                        formLogin().
                loginPage("/users/login").
                // the names of the username, password input fields in the custom login form
                        usernameParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY).
                passwordParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_PASSWORD_KEY).
                // where do we go after login
                        defaultSuccessUrl("/").//use true argument if you always want to go there, otherwise go to previous page
                failureForwardUrl("/users/login-error").
                and().logout().//configure logout
                logoutUrl("/users/logout").
                logoutSuccessUrl("/").//go to homepage after logout
                invalidateHttpSession(true).
                and().
                securityContext().
                securityContextRepository(securityContextRepository);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        return new ApplicationUserDetailsService(userRepository);
    }

    @Bean
    public SecurityContextRepository securityContextRepository() {
        return new DelegatingSecurityContextRepository(
                new RequestAttributeSecurityContextRepository(),
                new HttpSessionSecurityContextRepository()
        );
    }

}
