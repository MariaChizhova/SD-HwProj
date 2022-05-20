package ru.java.sdhwproj.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @GetMapping("/homework")
    public String getHomeworks() {
        return "Hello";
    }

    @GetMapping("/submission")
    public String getSubmissions() {
        return "Hello";
    }

    @GetMapping("/homework/{id}")
    public String getHomework(@PathVariable Long id) {
        return id.toString();
    }

    @GetMapping("/submission/{id}")
    public String getSubmission(@PathVariable Long id) {
        return id.toString();
    }

    @PostMapping("/submission")
    public void addSubmission() {
        return;
    }
}
