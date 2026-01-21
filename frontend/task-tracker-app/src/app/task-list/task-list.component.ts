import { Component,OnInit} from '@angular/core';
import { CommonModule } from '@angular/common';
//Import the service
import { TaskService } from '../services/task.service';
//Import the Task model
import { Task } from '../models/taks';

@Component({
  selector: 'app-task-list',
  imports: [CommonModule],
  templateUrl: './task-list.component.html',
  styleUrl: './task-list.component.css'
})
export class TaskListComponent implements OnInit {

  tasks: Task[] = [];

  constructor(private taskService: TaskService) { }

  ngOnInit(): void {
    this.taskService.getTasks().subscribe({
      next: (data) => this.tasks = data,
      error: (error) => console.error('Error fetching tasks:', error)
    });
  }
}