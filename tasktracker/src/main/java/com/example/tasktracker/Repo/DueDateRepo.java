package com.example.tasktracker.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.tasktracker.Model.DueDate;

@Repository
public interface DueDateRepo extends JpaRepository<DueDate, Integer> {
 
} 
