package com.example.tasktracker.Service;

import com.example.tasktracker.Exceptions.ResourceNotFoundException;
import com.example.tasktracker.Model.DueDate;
import com.example.tasktracker.Repo.DueDateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DueDateService {
    private final DueDateRepo dueDateRepo;
    @Autowired
    public DueDateService(DueDateRepo dueDateRepo) {
        this.dueDateRepo = dueDateRepo;
    }
    //Method to get all due dates
    public java.util.List<DueDate> getAllDueDates() {
        return dueDateRepo.findAll();
    }
    //Method to add a new due date
    public DueDate addDueDate(DueDate dueDate) {
        return dueDateRepo.save(dueDate);
    }
    //Method to find a due date by ID
    public DueDate getDueDateByID(Integer id) {
        return dueDateRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DueDate not found with id " + id));
    }
    //Method to delete a due date
    public void deleteDueDate(Integer id) {
        DueDate dueDate = dueDateRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DueDate not found with id " + id));
        dueDateRepo.delete(dueDate);
    }
    //Method to update a due date
    public DueDate updateDueDate(Integer id, DueDate dueDateDetails) {
        DueDate dueDate = dueDateRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DueDate not found with id " + id));

        dueDate.setDate(dueDateDetails.getDate());
        
        return dueDateRepo.save(dueDate);
    }
    
}
