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

    @GetMapping("/homework/student")
    public List<Homework> getHomeworksForStudent() {
        return homeworkService.getAllHomeworksForStudent();
    }

    @GetMapping("/homework/teacher")
    public List<Homework> getHomeworksForTeacher() {
        return homeworkService.getAllHomeworksForTeacher();
    }

    @GetMapping("/submission/{homeworkId}")
    public List<Submission> getSubmissions(@PathVariable Long homeworkId) {
        return homeworkService.getAllSubmissions(homeworkId);
    }

    @GetMapping("/homework/{id}")
    public Homework getHomework(@PathVariable Long id) {
        return homeworkService.getHomeworkById(id);
    }

    @GetMapping("/submission/{homeworkId}/{id}")
    public Submission getSubmission(@PathVariable Long homeworkId, @PathVariable Long id) {
        return homeworkService.getSubmissionById(homeworkId, id);
    }

    @PostMapping("/submission/add")
    public void addSubmission(@RequestBody SubmissionRequest request) {
        homeworkService.addSubmission(submissionMapper.AddSubmissionRequestToSubmission(request));
    }

    @PostMapping("/homework/add")
    public void addHomework(@RequestBody HomeworkRequest request) {
        homeworkService.addHomework(homeworkMapper.AddHomeworkRequestToHomework(request));
    }
}
