package ru.java.sdhwproj.models;

import lombok.Value;

import java.io.Serializable;
import java.sql.Timestamp;

@Value
public class Submission implements Serializable {
    Long id;
    Long homeworkId;
    Timestamp time;
    String solution;
    Integer result;
    String programOutput;
}
