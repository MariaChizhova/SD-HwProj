package ru.java.sdhwproj.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.java.sdhwproj.dao.HomeworkDao;
import ru.java.sdhwproj.dao.SubmissionDao;
import ru.java.sdhwproj.models.Homework;
import ru.java.sdhwproj.models.Submission;

import java.sql.Timestamp;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultHomeworkService implements HomeworkService {

    private final HomeworkDao homeworkDao;
    private final SubmissionDao submissionDao;

    @Override
    public Homework getHomeworkById(Long id) {
        return homeworkDao.read(id);
    }

    @Override
    public Submission getSubmissionById(Long homeworkId, Long id) {
        return submissionDao.read(homeworkId, id);
    }

    @Override
    public List<Homework> getAllHomeworksForStudent() {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        return homeworkDao.readAll().stream()
                .filter(homework -> homework.getPublication().before(now))
                .sorted(Comparator.comparing(Homework::getDeadline))
                .toList();
    }

    @Override
    public List<Homework> getAllHomeworksForTeacher() {
        return homeworkDao.readAll();
    }

    @Override
    public List<Submission> getAllSubmissions(Long homeworkId) {
        return submissionDao.readAll(homeworkId);
    }

    @Override
    public void addHomework(Homework homework) {
        homeworkDao.create(homework);
    }

    @Override
    public void addSubmission(Submission submission) {
        submissionDao.create(submission);
    }
}
