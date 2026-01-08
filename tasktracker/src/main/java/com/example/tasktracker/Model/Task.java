package com.example.tasktracker.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
/*
 * Model class for Task entity.
 * Each task is associated with a due date and a project.
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tasks")
public class Task {
    //Create an enum for priority levels
    public enum Priority {
        LOW,
        MEDIUM,
        HIGH
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String title;
    private String description;
    @Enumerated(EnumType.STRING)
    private Priority priority;
    //default the completed as false
    private boolean completed = false;

    //Many tasks can belong to one due date
    //but not must have a due date
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "due_date_id")
    private DueDate dueDate;

    //Many tasks can belong to one project
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;
    

}


