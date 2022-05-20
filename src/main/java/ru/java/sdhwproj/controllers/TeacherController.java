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

    @PostMapping("/homework")
    public void addHomework(@RequestBody HomeworkRequest request) {
        homeworkService.addHomework(mapper.AddHomeworkRequestToHomework(request));
    }
}
