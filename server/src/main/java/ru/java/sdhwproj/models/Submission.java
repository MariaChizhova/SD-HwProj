package ru.java.sdhwproj.models;

import lombok.Value;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Model of submission
 */
@Value
public class Submission implements Serializable {

    /**
     * Id of submission in homework
     */
    Long id;

    /**
     * Id of homework to which submission is sent
     */
    Long homeworkId;

    /**
     * Time of creating submission
     */
    Timestamp time;

    /**
     * Solution of homework
     */
    String solution;

    /**
     * Result of the homework (in points)
     */
    Integer result;

    /**
     * Comments after submission check
     */
    String programOutput;
}
