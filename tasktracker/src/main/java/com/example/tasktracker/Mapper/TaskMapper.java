package com.example.tasktracker.Mapper;

import com.example.tasktracker.DTO.TaskGetDTO;
import com.example.tasktracker.Model.Task;

public class TaskMapper {
    public static TaskGetDTO toTaskGetDTO(Task task) {
        TaskGetDTO dto = new TaskGetDTO();
        dto.setTitle(task.getTitle());
        dto.setDescription(task.getDescription());
        dto.setPriority(task.getPriority().toString());
        dto.setCompleted(task.isCompleted());
        return dto;
    }
}
