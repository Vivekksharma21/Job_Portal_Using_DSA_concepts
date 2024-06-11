package com.jobportal.controllers;

import com.jobportal.models.Job;
import com.jobportal.services.JobService;

import java.util.Scanner;
import java.util.UUID;

public class JobController {
    private JobService jobService;
    private Scanner scanner;

    public JobController(JobService jobService, Scanner scanner) {
        this.jobService = jobService;
        this.scanner = scanner;
    }

    public void createJob() {
        System.out.println("Enter job title:");
        String title = scanner.nextLine();
        System.out.println("Enter job description:");
        String description = scanner.nextLine();
        System.out.println("Enter job location:");
        String location = scanner.nextLine();
        System.out.println("Enter company name:");
        String company = scanner.nextLine();

        String jobId = UUID.randomUUID().toString();
        Job job = new Job(jobId, title, description, location, company);
        jobService.saveJob(job);
        System.out.println("Job created successfully!");
    }

    public void listJobs() {
        for (Job job : jobService.getJobs().values()) {
            System.out.println("Job ID: " + job.getJobId());
            System.out.println("Title: " + job.getTitle());
            System.out.println("Description: " + job.getDescription());
            System.out.println("Location: " + job.getLocation());
            System.out.println("Company: " + job.getCompany());
            System.out.println("-----");
        }
    }
}
