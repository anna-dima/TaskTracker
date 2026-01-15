package com.example.tasktracker.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import com.example.tasktracker.Model.Project;
import com.example.tasktracker.Service.ProjectService;
import com.example.tasktracker.Exceptions.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
/*
 * Controller class for handling project-related HTTP requests.
 */
@RestController
@RequestMapping("/api")
public class ProjectController {
    @Autowired
    private ProjectService projectService;
    //Get all projects
    //1/14/26 Get all projects working correctly
    @GetMapping("/projects")
    public java.util.List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }
    //Get project by ID
    //1/14/26 Get project by ID working correctly
    @GetMapping("/projects/{id}")
    public ResponseEntity<Project> getProjectByID(@PathVariable Integer id) {
        Project project = projectService.getProjectByID(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found with id " + id));
        return ResponseEntity.ok(project);
    }
    //Add project to the database
    //1/14/26 Create projects working correctly 
    @PostMapping("/projects")
    public ResponseEntity<Project> addProject(@RequestBody Project project) {
        Project saved = projectService.addProject(project);
        return ResponseEntity.status(201).body(saved);
    }
    //Updates project in the database
    //1/14/26 Update project working correctly
    @PutMapping("/projects/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable Integer id, @RequestBody Project projectDetails) {
        Project updatedProject = projectService.updateProject(id, projectDetails);
        return ResponseEntity.ok(updatedProject);
    }
    //Deletes project from the database
    //1/14/26 Delete project working correctly
    @DeleteMapping("/projects/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Integer id) {
        projectService.deleteProject(id);
        return ResponseEntity.noContent().build();
    }
    
}
