package ru.java.sdhwproj.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.java.sdhwproj.models.Homework;
import ru.java.sdhwproj.models.HomeworkToDtoMapper;
import ru.java.sdhwproj.models.Submission;
import ru.java.sdhwproj.models.SubmissionToDtoMapper;
import ru.java.sdhwproj.requests.HomeworkRequest;
import ru.java.sdhwproj.requests.SubmissionRequest;
import ru.java.sdhwproj.service.HomeworkService;

import java.util.List;

@RestController
@RequestMapping("/hwproj")
@RequiredArgsConstructor
public class HwProjController {

    private final HomeworkService homeworkService;
    private final SubmissionToDtoMapper submissionMapper;
    private final HomeworkToDtoMapper homeworkMapper;

    /**
     * handler "/hwproj/homework/student" GET
     *
     * @return a list of all homeworks that are published for student.
     */
    @GetMapping("/homework/student")
    public List<Homework> getHomeworksForStudent() {
        return homeworkService.getAllHomeworksForStudent();
    }

    /**
     * handler "/hwproj/homework/teacher" GET
     *
     * @return a list of all homeworks.
     */
    @GetMapping("/homework/teacher")
    public List<Homework> getHomeworksForTeacher() {
        return homeworkService.getAllHomeworksForTeacher();
    }

    /**
     * handler "/hwproj/submission/{homeworkId}" GET
     *
     * @param homeworkId
     * @return all submission of homework with homeworkId
     */

    @GetMapping("/submission/{homeworkId}")
    public List<Submission> getSubmissions(@PathVariable Long homeworkId) {
        return homeworkService.getAllSubmissions(homeworkId);
    }

    /**
     * handler "/hwproj/homework/{id}" GET
     *
     * @param id
     * @return homework with given id
     */

    @GetMapping("/homework/{id}")
    public Homework getHomework(@PathVariable Long id) {
        return homeworkService.getHomeworkById(id);
    }

    /**
     * handler "/hwproj/submission/{homeworkId}/{id}" GET
     *
     * @param homeworkId
     * @param id
     * @return submission with given homeworkId and id
     */

    @GetMapping("/submission/{homeworkId}/{id}")
    public Submission getSubmission(@PathVariable Long homeworkId, @PathVariable Long id) {
        return homeworkService.getSubmissionById(homeworkId, id);
    }

    /**
     * handler "/hwproj/submission/add" POST
     *
     * Add new submission for homework in database
     * @param request request with new homework submission
     */
    @PostMapping("/submission/add")
    public void addSubmission(@RequestBody SubmissionRequest request) {
        homeworkService.addSubmission(submissionMapper.AddSubmissionRequestToSubmission(request));
    }

    /**
     * handler "/hwproj/homework/add" POST
     *
     * Add new homework in database
     * @param request request with new homework
     */
    @PostMapping("/homework/add")
    public void addHomework(@RequestBody HomeworkRequest request) {
        homeworkService.addHomework(homeworkMapper.AddHomeworkRequestToHomework(request));
    }
}
