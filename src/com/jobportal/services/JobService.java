package com.jobportal.services;

import com.jobportal.models.Job;

import java.util.HashMap;
import java.util.Map;

public class JobService {
    private Map<String, Job> jobs = new HashMap<>();

    public void saveJob(Job job) {
        jobs.put(job.getJobId(), job);
    }

    public Map<String, Job> getJobs() {
        return jobs;
    }

    public void deleteJob(String jobId) {
        jobs.remove(jobId);
    }

    public Job getJobById(String jobId) {
        return jobs.get(jobId);
    }
}
