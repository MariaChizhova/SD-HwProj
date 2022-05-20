package ru.java.sdhwproj.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.java.sdhwproj.models.Homework;
import ru.java.sdhwproj.models.HomeworkToDtoMapper;
import ru.java.sdhwproj.requests.HomeworkRequest;
import ru.java.sdhwproj.models.Submission;
import ru.java.sdhwproj.service.HomeworkService;

import java.util.List;

@RestController
@RequestMapping("/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final HomeworkService homeworkService;
    private final HomeworkToDtoMapper mapper;

    @GetMapping("/homework")
    public List<Homework> getHomeworks() {
        return homeworkService.getAllHomeworks();
    }

    @GetMapping("/submission")
    public List<Submission> getSubmissions() {
        return homeworkService.getAllSubmissions();
    }

    @GetMapping("/homework/{id}")
    public Homework getHomework(@PathVariable Long id) {
        return homeworkService.getHomeworkById(id);
    }

    @GetMapping("/submission/{id}")
    public Submission getSubmission(@PathVariable Long id) {
        return homeworkService.getSubmissionById(id);
    }

    @PostMapping("/homework")
    public void addHomework(@RequestBody HomeworkRequest request) {
        homeworkService.addHomework(mapper.AddHomeworkRequestToHomework(request));
    }
}
