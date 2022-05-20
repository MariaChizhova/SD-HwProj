package ru.java.sdhwproj.requests;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class HomeworkRequest {
    private String name;
    private String description;
    private Timestamp publication;
    private Timestamp deadline;
}
