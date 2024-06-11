package com.jobportal.services;

import com.jobportal.models.Job;
import com.jobportal.models.User;

import java.util.ArrayList;
import java.util.List;

public class RecommendationService {
    private UserService userService;
    private JobService jobService;

    public RecommendationService(UserService userService, JobService jobService) {
        this.userService = userService;
        this.jobService = jobService;
    }

    public List<Job> recommendJobs(String userId) {
        User user = userService.getUserById(userId);
        List<Job> recommendedJobs = new ArrayList<>();
        if (user != null) {
            // Implement a simple recommendation logic based on location for demonstration purposes
            for (Job job : jobService.getJobs().values()) {
                if (job.getLocation().equalsIgnoreCase(user.getLocation())) {
                    recommendedJobs.add(job);
                }
            }
        }
        return recommendedJobs;
    }
}
