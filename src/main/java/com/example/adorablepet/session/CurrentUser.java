package com.example.adorablepet.session;

import com.example.adorablepet.models.entities.UserEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class CurrentUser {
    private Long id;
    private String email;

    public CurrentUser() {
    }

    public void login(UserEntity user){
        this.id = user.getId();
        this.email = user.getEmail();
    }
    public Long getId() {
        return id;
    }

    public CurrentUser setId(Long id) {
        this.id = id;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public CurrentUser setEmail(String email) {
        this.email = email;
        return this;
    }
}
