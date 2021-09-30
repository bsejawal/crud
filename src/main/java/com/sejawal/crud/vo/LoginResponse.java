package com.sejawal.crud.vo;

public class LoginResponse {
    private boolean isLoggedIn = false;
    private String username;

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "isLoggedIn=" + isLoggedIn +
                ", username='" + username + '\'' +
                '}';
    }
}
