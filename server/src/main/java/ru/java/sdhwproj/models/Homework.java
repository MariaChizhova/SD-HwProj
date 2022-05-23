package ru.java.sdhwproj.models;

import lombok.Value;

import java.sql.Timestamp;

/**
 * Model of homework
 */
@Value
public class Homework {
    /**
     * Id of homework
     */
    Long id;

    /**
     * Name of the homework
     */
    String name;

    /**
     * Description for the homework
     */
    String description;

    /**
     * Time of homework publication for student.
     * After this time homework will appear for student.
     */
    Timestamp publication;

    /**
     * Time of homework deadline.
     * If student send homework after this time, it
     * will receive  0 points.
     */
    Timestamp deadline;
}
