package ru.java.sdhwproj.service;

import ru.java.sdhwproj.models.Homework;
import ru.java.sdhwproj.models.Submission;

import java.util.List;

public interface HomeworkService {
    /**
     * Return homework by his id
     * @param id
     * @return homework
     */
    Homework getHomeworkById(Long id);

    /**
     * Return submission by given homeworkId and id of submission of this homework
     * @param homeworkId
     * @param id
     * @return submission
     */
    Submission getSubmissionById(Long homeworkId, Long id);

    /**
     * Return all homeworks that are published for student.
     * Also, they are sorted by deadline.
     * @return list of published homeworks
     */
    List<Homework> getAllHomeworksForStudent();

    /**
     * Return all of existing homeworks
     * @return list of all homeworks
     */
    List<Homework> getAllHomeworksForTeacher();

    /**
     * Return all of existing submissions for homework
     * with homeworkId.
     * @param homeworkId is the id of homework
     * @return list of all homeworks
     */
    List<Submission> getAllSubmissions(Long homeworkId);

    /**
     * Add new homework.
     * @param homework
     */
    void addHomework(Homework homework);

    /**
     * Add new submission
     * @param submission
     */
    void addSubmission(Submission submission);
}
