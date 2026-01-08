package com.example.tasktracker.DTO;

import lombok.Data;
@Data
public class TaskGetDTO {
    private String title;
    private String description;
    private String priority;
    private boolean completed;
}
