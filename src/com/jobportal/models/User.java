package com.jobportal.models;

public class User {
    private String userId;
    private String username;
    private String password;
    private String email;
    private String location;

    public User(String userId, String username, String password, String email,String location) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
    public String getLocation()
    {
    	return location;
    }
}
