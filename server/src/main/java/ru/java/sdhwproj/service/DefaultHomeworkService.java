package ru.java.sdhwproj.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.java.sdhwproj.dao.HomeworkDao;
import ru.java.sdhwproj.models.Homework;
import ru.java.sdhwproj.models.Submission;

import java.sql.Timestamp;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultHomeworkService implements HomeworkService {

    private final HomeworkDao homeworkDao;

    @Override
    public Homework getHomeworkById(Long id) {
        return homeworkDao.read(id);
    }

    @Override
    public Submission getSubmissionById(Long homeworkId, Long id) {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        return new Submission(id, homeworkId, now, "Lipsi ha", 10, "Lipsi gimme money ha");
    }

    @Override
    public List<Homework> getAllHomeworksForStudent() {
        //todo: filter by date
        return homeworkDao.readAll();
    }

    @Override
    public List<Homework> getAllHomeworksForTeacher() {
        return homeworkDao.readAll();
    }

    @Override
    public List<Submission> getAllSubmissions(Long id) {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        Submission submission = new Submission(1L, id, now, "Lipsi ha", 10, "Lipsi gimme money ha");
        return List.of(submission);
    }

    @Override
    public void addHomework(Homework homework) {
        homeworkDao.create(homework);
    }

    @Override
    public void addSubmission(Submission submission) {

    }
}
