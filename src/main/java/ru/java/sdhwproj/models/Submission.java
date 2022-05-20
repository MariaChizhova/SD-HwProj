package ru.java.sdhwproj.models;

import lombok.Value;

import java.sql.Timestamp;

@Value
public class Submission {
    Long id;
    Long homeworkId;
    Timestamp time;
    String solution;
    Integer result;
    String programOutput;
}
