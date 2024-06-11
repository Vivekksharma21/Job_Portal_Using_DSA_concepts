package com.jobportal.services;

import com.jobportal.models.User;

import java.util.HashMap;
import java.util.Map;

public class UserService {
    private Map<String, User> users = new HashMap<>();

    public void saveUser(User user) {
        users.put(user.getUserId(), user);
    }

    public Map<String, User> getUsers() {
        return users;
    }
    
    public User getUserById(String userId) {
        return users.get(userId);
    }
}
