package com.example.tasktracker.Controller;

//import the model and the service for the task
import com.example.tasktracker.Model.Task;
import com.example.tasktracker.Service.TaskService;
import com.example.tasktracker.DTO.TaskGetDTO;
import com.example.tasktracker.Exceptions.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/*
 * Controller class for handling task-related HTTP requests.
 */

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class TaskController {

    @Autowired
    private TaskService taskService;

    //Get all tasks
    //1/8/2026 Get Mapping working to fetch all tasks with DTO
    @GetMapping("/tasks")
    public List<TaskGetDTO> getAllTasks() {
        return taskService.getAllTasks();
    }

    //Get task by ID
    //1/8/26 Get Mapping working to fetch task by ID with DTO 
    @GetMapping("/tasks/{id}")
    public ResponseEntity<TaskGetDTO> getTaskByID(@PathVariable Integer id) {
        TaskGetDTO dto = taskService.getTaskByID(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id " + id));
        return ResponseEntity.ok(dto);
    }
    

    //Add task to the database
    //1/8/2026 Post Mapping working to add a task
    @PostMapping("/tasks")
    public ResponseEntity<Task> addTask(@RequestBody Task task) {
        Task saved = taskService.addTask(task);
        return ResponseEntity.status(201).body(saved);
    }

    //Updates task in the database
    //To Do: Test Put Mapping
    @PutMapping("/tasks/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Integer id, @RequestBody Task taskDetails) {
        Task updatedTask = taskService.updateTask(id, taskDetails);
        return ResponseEntity.ok(updatedTask);
    }

    //Deletes task from the database
    //1/15/26 Delete Mapping working to delete a task
    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Integer id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

    //Get task by Priority 
    //1/8/2026 Get Mapping working to fetch task by Priority using DTO
    @GetMapping("/tasks/priority/{priority}")
    public List<TaskGetDTO> getTasksByPriority(@PathVariable Task.Priority priority) {
        return taskService.getTasksByPriority(priority);
    }

    //Get task by Due Date
    //1/15/26 Get Mapping working to fetch tasks by Due Date using DTO
    @GetMapping("/tasks/duedate/{date}")
    public List<TaskGetDTO> getTasksByDueDate(@PathVariable LocalDate date) {
        return taskService.getTasksByDueDate(date);
    }

    //Get all tasks for a specific project
    //1/15/26 Get Mapping working to fetch tasks by Project ID using DTO
    @GetMapping("/projects/{projectId}/tasks")
    public List<TaskGetDTO> getTasksByProject(@PathVariable Integer projectId) {
        return taskService.getTasksByProject(projectId);
    }
    
}
