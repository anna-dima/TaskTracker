package com.example.tasktracker.Controller;

//import the model and the service for the task
import com.example.tasktracker.Model.Task;
import com.example.tasktracker.Service.TaskService;
import com.example.tasktracker.DTO.TaskGetDTO;
import com.example.tasktracker.Exceptions.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * Controller class for handling task-related HTTP requests.
 */

@RestController
@RequestMapping("/api")
public class TaskController {

    @Autowired
    private TaskService taskService;

    //Get all tasks
    @GetMapping("/tasks")
    public List<TaskGetDTO> getAllTasks() {
        return taskService.getAllTasks();
    }

    //Get task by ID
    @GetMapping("/tasks/{id}")
    public ResponseEntity<Task> getTaskByID(@PathVariable Integer id) {
        Task task = taskService.getTaskByID(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id " + id));
        return ResponseEntity.ok(task);
    }
    

    //Add task to the database
    @PostMapping("/tasks")
    public ResponseEntity<Task> addTask(@RequestBody Task task) {
        Task saved = taskService.addTask(task);
        return ResponseEntity.status(201).body(saved);
    }

    //Updates task in the database
    @PutMapping("/tasks/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Integer id, @RequestBody Task taskDetails) {
        Task updatedTask = taskService.updateTask(id, taskDetails);
        return ResponseEntity.ok(updatedTask);
    }

    //Deletes task from the database
    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Integer id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

    //Get task by Priority 
    @GetMapping("/tasks/priority/{priority}")
    public List<Task> getTasksByPriority(@PathVariable Task.Priority priority) {
        return taskService.getTasksByPriority(priority);
    }


    //Get all tasks for a specific project
    @GetMapping("/projects/{projectId}/tasks")
    public List<Task> getTasksByProject(@PathVariable Integer projectId) {
        return taskService.getTasksByProject(projectId);
    }
    
}
