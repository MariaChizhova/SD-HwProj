package ru.java.sdhwproj.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.java.sdhwproj.models.Homework;
import ru.java.sdhwproj.models.Submission;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultHomeworkService implements HomeworkService {
    @Override
    public Homework getHomeworkById(Long id) {
        return null;
    }

    @Override
    public Submission getSubmissionById(Long homeworkId, Long id) {
        return null;
    }

    @Override
    public List<Homework> getAllHomeworks() {
        return null;
    }

    @Override
    public List<Submission> getAllSubmissions(Long id) {
        return null;
    }

    @Override
    public void addHomework(Homework homework) {

    }

    @Override
    public void addSubmission(Submission submission) {

    }
}
