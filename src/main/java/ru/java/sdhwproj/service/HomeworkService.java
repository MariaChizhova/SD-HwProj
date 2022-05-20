package ru.java.sdhwproj.service;

import ru.java.sdhwproj.models.Homework;
import ru.java.sdhwproj.models.Submission;

import java.util.List;

public interface HomeworkService {
    Homework getHomeworkById(Long id);
    Submission getSubmissionById(Long id);
    List<Homework> getAllHomeworks();
    List<Submission> getAllSubmissions();
    void addHomework(Homework homework);
    void addSubmission(Submission submission);
}
