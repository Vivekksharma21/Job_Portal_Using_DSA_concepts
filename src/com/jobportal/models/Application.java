package com.jobportal.models;

public class Application {
    private String applicationId;
    private String userId;
    private String jobId;
    private String status;

    public Application(String applicationId, String userId, String jobId, String status) {
        this.applicationId = applicationId;
        this.userId = userId;
        this.jobId = jobId;
        this.status = status;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public String getUserId() {
        return userId;
    }

    public String getJobId() {
        return jobId;
    }

    public String getStatus() {
        return status;
    }
}
