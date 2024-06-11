package com.jobportal.services;

import com.jobportal.models.Application;
import com.jobportal.utils.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Queue;

public class ApplicationService {
    public void saveApplication(Application application) {
        String sql = "INSERT INTO Applications (applicationId, userId, jobId, status) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, application.getApplicationId());
            pstmt.setString(2, application.getUserId());
            pstmt.setString(3, application.getJobId());
            pstmt.setString(4, application.getStatus());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Queue<Application> getApplications() {
        Queue<Application> applications = new LinkedList<>();
        String sql = "SELECT * FROM Applications";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                applications.add(new Application(
                        rs.getString("applicationId"),
                        rs.getString("userId"),
                        rs.getString("jobId"),
                        rs.getString("status")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return applications;
    }
}
