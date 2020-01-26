package com.pinkstack.model;

import org.springframework.stereotype.Component;

@Component
public class SessionData {

    private String email;
    private Integer sessionId;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getSessionId() {
        return sessionId;
    }

    public void setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
    }
}
