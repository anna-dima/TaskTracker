package com.example.tasktracker.Repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.tasktracker.Model.Project;

@Repository
public interface ProjectRepo extends JpaRepository<Project, Integer> {

}
