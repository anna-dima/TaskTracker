package com.example.tasktracker.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.tasktracker.Model.DueDate;
import com.example.tasktracker.Service.DueDateService;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
/*
 * Controller class for handling due date-related HTTP requests.
 */
@RestController
@RequestMapping("/api")
public class DueDateController {
    @Autowired
    private DueDateService dueDateService;
    //Get all due dates
    @GetMapping("/duedates")
    public java.util.List<DueDate> getAllDueDates() {
        return dueDateService.getAllDueDates();
    }
    //Get due date by ID
    @GetMapping("/duedates/{id}")
    public ResponseEntity<DueDate> getDueDateByID(@PathVariable Integer id) {
        DueDate dueDate = dueDateService.getDueDateByID(id);
        return ResponseEntity.ok(dueDate);
    }
    //Add due date to the database
    @PostMapping("/duedates")
    public ResponseEntity<DueDate> addDueDate(@RequestBody DueDate dueDate) {
        DueDate saved = dueDateService.addDueDate(dueDate);
        return ResponseEntity.status(201).body(saved);
    }
    //Updates due date in the database
    @PutMapping("/duedates/{id}")
    public ResponseEntity<DueDate> updateDueDate(@PathVariable Integer id, @RequestBody DueDate dueDateDetails) {
        DueDate updatedDueDate = dueDateService.updateDueDate(id, dueDateDetails);
        return ResponseEntity.ok(updatedDueDate);
    }
    //Deletes due date from the database
    @DeleteMapping("/duedates/{id}")
    public ResponseEntity<Void> deleteDueDate(@PathVariable Integer id) {
        dueDateService.deleteDueDate(id);
        return ResponseEntity.noContent().build();
    }
    
}
