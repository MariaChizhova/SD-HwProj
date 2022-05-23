package ru.java.sdhwproj.requests;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class SubmissionRequest {
    private Long homeworkId;
    private Timestamp time;
    private String solution;
}
