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

import javax.security.auth.x500.X500Principal;
import java.security.Principal;


@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http,
                                           SecurityContextRepository securityContextRepository) throws Exception {
        http.
                        authorizeHttpRequests().
                        requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll().
                        requestMatchers("/","/users/login","/users/register", "/users/login-error",
                        "/pages/departments","/pages/departments-more-info","/pages/our-team",
                        "/pages/information","/pages/clinic-services", "/pages/good-heart",
                        "/pages/projects","/pages/price-list", "/api/**").permitAll().
                        requestMatchers("/pages/moderators").hasRole(RoleEnumName.MODERATOR.name()).
                        requestMatchers("/pages/admins").hasRole(RoleEnumName.ADMIN.name()).
                        requestMatchers("/pages/my-pets").hasRole(RoleEnumName.USER.name()).
                anyRequest().authenticated().
                and().
                formLogin().
                loginPage("/users/login").
                usernameParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY).
                passwordParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_PASSWORD_KEY).
                defaultSuccessUrl("/").
                failureForwardUrl("/users/login-error").
                and().logout().
                logoutUrl("/users/logout").
                logoutSuccessUrl("/").
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
