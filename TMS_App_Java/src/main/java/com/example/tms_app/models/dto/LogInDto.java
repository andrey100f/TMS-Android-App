package com.example.tms_app.models.dto;

public class LogInDto {
    private String username;
    private String password;

    public LogInDto() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}