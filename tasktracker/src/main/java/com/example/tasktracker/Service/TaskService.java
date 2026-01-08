package com.example.tasktracker.Service;

import com.example.tasktracker.DTO.TaskGetDTO;
import com.example.tasktracker.Exceptions.ResourceNotFoundException;
import com.example.tasktracker.Model.Task;
import com.example.tasktracker.Repo.TaskRepo;
import com.example.tasktracker.Mapper.TaskMapper;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.time.LocalDate;

/*
 * Service class for managing tasks.
 */

@Service
public class TaskService {
    private final TaskRepo taskRepo;

    @Autowired
    public TaskService(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }


    //Method to get all tasks
    public List<TaskGetDTO> getAllTasks() {
        return taskRepo.findAll().stream()
                .map(TaskMapper::toTaskGetDTO)
                .toList();
    }

    //Method to add a new task
    public Task addTask(Task task) {
        return taskRepo.save(task);
    }

    //Method to find a task by ID
    public Optional<TaskGetDTO> getTaskByID(Integer id) {
        return taskRepo.findById(id).map(TaskMapper::toTaskGetDTO);
    }

    //Method to update a task
    public Task updateTask(Integer id, Task taskDetails) {
        Task task = taskRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id " + id));

        task.setTitle(taskDetails.getTitle());
        task.setDescription(taskDetails.getDescription());
        task.setCompleted(taskDetails.isCompleted());

        return taskRepo.save(task);
    }

    //Method to delete a task
    public void deleteTask(Integer id) {
        Task task = taskRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id " + id));
        taskRepo.delete(task);
    }

    //Method to get task by Priority 
    public List<TaskGetDTO> getTasksByPriority(Task.Priority priority) {
        List<TaskGetDTO> tasks = taskRepo.findByPriority(priority).stream()
                .map(TaskMapper::toTaskGetDTO)
                .toList();
        if (tasks.isEmpty()) {
            throw new ResourceNotFoundException("No tasks found with priority " + priority);
        }
        return tasks;
    }

    //Method to get task by due date
    //public List<TaskGetDTO> getTasksByDueDate(LocalDate dueDate) {
      //  return taskRepo.findByDueDate_Date(dueDate);
    //}

    

    //Method to get tasks for a specific project
    public List<Task> getTasksByProject(Integer projectId) {
        return taskRepo.findByProjectId(projectId);
    }
}
