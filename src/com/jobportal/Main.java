package com.jobportal;

import com.jobportal.controllers.AdminController;
import com.jobportal.controllers.JobController;
import com.jobportal.controllers.UserController;
import com.jobportal.services.*;
import com.jobportal.utils.DatabaseUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Attempt to establish database connection
        Connection connection = null;
        try {
            connection = DatabaseUtil.getConnection();
        } catch (SQLException e) {
            System.err.println("Failed to connect to the database. Exiting program.");
            System.exit(1);
        }

        // If database connection is successful, proceed with program execution
        UserService userService = new UserService();
        JobService jobService = new JobService();
        ApplicationService applicationService = new ApplicationService();
        RecommendationService recommendationService = new RecommendationService(userService, jobService);

        Scanner scanner = new Scanner(System.in);

        UserController userController = new UserController(userService, scanner);
        JobController jobController = new JobController(jobService, scanner);
        AdminController adminController = new AdminController(jobService, scanner);

        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Create Job");
            System.out.println("4. List Jobs");
            System.out.println("5. Delete Job");
            System.out.println("6. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    userController.registerUser();
                    break;
                case 2:
                    userController.loginUser();
                    break;
                case 3:
                    jobController.createJob();
                    break;
                case 4:
                    jobController.listJobs();
                    break;
                case 5:
                    adminController.deleteJob();
                    break;
                case 6:
                    // Close database connection before exiting
                    try {
                        if (connection != null && !connection.isClosed()) {
                            connection.close();
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
