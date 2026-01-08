package com.example.tasktracker.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.tasktracker.Model.Task;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface TaskRepo extends JpaRepository<Task, Integer> {

	// Find tasks by associated project id
	List<Task> findByProjectId(Integer projectId);

	// Find tasks by due date (search by the DueDate.date field)
	List<Task> findByDueDate_Date(LocalDate dueDate);

}
