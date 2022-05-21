package ru.java.sdhwproj.service;

import ru.java.sdhwproj.models.Homework;
import ru.java.sdhwproj.models.Submission;

import java.util.List;

public interface HomeworkService {
    Homework getHomeworkById(Long id);
    Submission getSubmissionById(Long homeworkId, Long id);
    List<Homework> getAllHomeworksForStudent();

    List<Homework> getAllHomeworksForTeacher();
    List<Submission> getAllSubmissions(Long homeworkId);
    void addHomework(Homework homework);
    void addSubmission(Submission submission);
}
