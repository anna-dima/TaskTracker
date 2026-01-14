package com.example.tasktracker.Service;

/*
 * Service class for managing projects.
 */
import com.example.tasktracker.Repo.ProjectRepo;
import com.example.tasktracker.Model.Project;
import com.example.tasktracker.Exceptions.ResourceNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepo projectRepo;

    @Autowired
    public ProjectService(ProjectRepo projectRepo) {
        this.projectRepo = projectRepo;
    }

    //Method to get all Projects
    public List<Project> getAllProjects() {
        return projectRepo.findAll();
    }
    //Method to add a new Project
    public Project addProject(Project project) {
        return projectRepo.save(project);
    }
    //Method to find a Project by ID
    public java.util.Optional<Project> getProjectByID(Integer id) {
        return projectRepo.findById(id);
    }

    //Method to delete a Project
    public void deleteProject(Integer id) {
        Project project = projectRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found with id " + id));
        projectRepo.delete(project);
    }

    //Method to update a Project
    public Project updateProject(Integer id, Project projectDetails) {
        Project project = projectRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found with id " + id));

        if (projectDetails.getTitle() != null) {
            project.setTitle(projectDetails.getTitle());
        }
        if (projectDetails.getDescription() != null) {
            project.setDescription(projectDetails.getDescription());
        }

        return projectRepo.save(project);
    }
    

}
