package com.jobportal.models;

public class Job {
    private String jobId;
    private String title;
    private String description;
    private String location;
    private String company;

    public Job(String jobId, String title, String description, String location, String company) {
        this.jobId = jobId;
        this.title = title;
        this.description = description;
        this.location = location;
        this.company = company;
    }

    public String getJobId() {
        return jobId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public String getCompany() {
        return company;
    }
}
