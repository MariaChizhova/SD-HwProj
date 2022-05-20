package ru.java.sdhwproj.models;

import lombok.Value;

import java.sql.Timestamp;

@Value
public class Homework {
    Long id;
    String name;
    String description;
    Timestamp publication;
    Timestamp deadline;
}
