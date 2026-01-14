package com.example.tasktracker.Model;
import jakarta.persistence.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/*
 * Model class for Project entity.
 * Each project can have multiple tasks associated with it.
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "projects")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String description;
    //One project can have many tasks
    @OneToMany(mappedBy = "project")
    @JsonIgnore
    private List<Task> tasks;
}
