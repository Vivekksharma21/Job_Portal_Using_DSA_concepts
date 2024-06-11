package com.jobportal.controllers;

import com.jobportal.models.User;
import com.jobportal.services.UserService;

import java.util.Scanner;
import java.util.UUID;

public class UserController {
    private UserService userService;
    private Scanner scanner;

    public UserController(UserService userService, Scanner scanner) {
        this.userService = userService;
        this.scanner = scanner;
    }

    public void registerUser() {
        System.out.println("Enter username:");
        String username = scanner.nextLine();
        System.out.println("Enter password:");
        String password = scanner.nextLine();
        System.out.println("Enter email:");
        String email = scanner.nextLine();
        System.out.println("Enter location :");
        String location = scanner.nextLine();

        String userId = UUID.randomUUID().toString();
        User user = new User(userId, username, password, email,location);
        userService.saveUser(user);
        System.out.println("User registered successfully!");
    }

    public void loginUser() {
        System.out.println("Enter username:");
        String username = scanner.nextLine();
        System.out.println("Enter password:");
        String password = scanner.nextLine();

        for (User user : userService.getUsers().values()) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                System.out.println("User logged in successfully!");
                return;
            }
        }
        System.out.println("Invalid username or password.");
    }
}
