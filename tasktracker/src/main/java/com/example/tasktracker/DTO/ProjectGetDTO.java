package com.example.tasktracker.DTO;
import lombok.Data;
//DTO class for Project Get requests
@Data
public class ProjectGetDTO {
    private String title;
    private String description;
}
