package com.example.tasktracker.Service;

import com.example.tasktracker.DTO.TaskGetDTO;
import com.example.tasktracker.Exceptions.ResourceNotFoundException;
import com.example.tasktracker.Model.Task;
import com.example.tasktracker.Repo.TaskRepo;
import com.example.tasktracker.Mapper.TaskMapper;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


import java.util.List;
import java.util.Optional;
import java.time.LocalDate;

/*
 * Service class for managing tasks.
 */

@Service
public class TaskService {
    private final TaskRepo taskRepo;

    @PersistenceContext
    private EntityManager em;

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
        Task saved = taskRepo.save(task);
        em.clear();
        return taskRepo.findById(saved.getId()).get();
    }

    //Method to find a task by ID
    public Optional<TaskGetDTO> getTaskByID(Integer id) {
        return taskRepo.findById(id).map(TaskMapper::toTaskGetDTO);
    }

    //Method to update a task
    public Task updateTask(Integer id, Task taskDetails) {
        Task task = taskRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id " + id));

        if (taskDetails.getTitle() != null) {
            task.setTitle(taskDetails.getTitle());
        }
        if (taskDetails.getDescription() != null) {
            task.setDescription(taskDetails.getDescription());
        }
        if (taskDetails.getPriority() != null) {
            task.setPriority(taskDetails.getPriority());
        }
        if (taskDetails.getCompleted() != null) {
            task.setCompleted(taskDetails.getCompleted());
        }
        if (taskDetails.getDueDate() != null) {
            task.setDueDate(taskDetails.getDueDate());
        }
        if (taskDetails.getProject() != null) {
            task.setProject(taskDetails.getProject());
        }

        return taskRepo.save(task);
    }

    //Method to delete a task
    public void deleteTask(Integer id) {
        Task task = taskRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id " + id));
        taskRepo.delete(task);
    }

    //Method to get task by Priority 
    //1/8/2026 Service method working to fetch task by Priority using DTO
    //Updated to throw ResourceNotFoundException if no tasks found
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
    public List<TaskGetDTO> getTasksByProject(Integer projectId) {
        List<TaskGetDTO> tasks = taskRepo.findByProjectId(projectId).stream()
                .map(TaskMapper::toTaskGetDTO)
                .toList();
        if (tasks.isEmpty()) {
            throw new ResourceNotFoundException("No tasks found for project " + projectId);
        }
        return tasks;
    }
}
