package com.jobportal.controllers;

import com.jobportal.services.JobService;

import java.util.Scanner;

public class AdminController {
    private JobService jobService;
    private Scanner scanner;

    public AdminController(JobService jobService, Scanner scanner) {
        this.jobService = jobService;
        this.scanner = scanner;
    }

    public void deleteJob() {
        System.out.println("Enter job ID to delete:");
        String jobId = scanner.nextLine();
        jobService.deleteJob(jobId);
        System.out.println("Job deleted successfully!");
    }
}
