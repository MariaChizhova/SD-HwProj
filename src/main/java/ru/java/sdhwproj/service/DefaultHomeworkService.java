package ru.java.sdhwproj.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.java.sdhwproj.models.Homework;
import ru.java.sdhwproj.models.Submission;

import java.sql.Timestamp;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultHomeworkService implements HomeworkService {
    @Override
    public Homework getHomeworkById(Long id) {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        return new Homework(id, "Instasamka", "Pussy juicy", now, now);
    }

    @Override
    public Submission getSubmissionById(Long homeworkId, Long id) {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        return new Submission(id, homeworkId, now, "Lipsi ha", 10, "Lipsi gimme money ha");
    }

    @Override
    public List<Homework> getAllHomeworks() {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        Homework hw = new Homework(1L, "Instasamka", "Pussy juicy", now, now);
        return List.of(hw);
    }

    @Override
    public List<Submission> getAllSubmissions(Long id) {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        Submission submission = new Submission(1L, id, now, "Lipsi ha", 10, "Lipsi gimme money ha");
        return List.of(submission);
    }

    @Override
    public void addHomework(Homework homework) {

    }

    @Override
    public void addSubmission(Submission submission) {

    }
}
