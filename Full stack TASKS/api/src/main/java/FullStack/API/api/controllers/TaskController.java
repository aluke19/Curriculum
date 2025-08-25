package FullStack.API.api.controllers;

import FullStack.API.api.models.Task;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@RestController
public class TaskController {
    @GetMapping("/tasks")
    public List<Task> getTasks() {
        return List.of(
            new Task(1L, "Learn Java", true),
            new Task(2L, "Learn Spring Boot", false),
            new Task(3L, "Build a REST API", false)
        );
    }
}
