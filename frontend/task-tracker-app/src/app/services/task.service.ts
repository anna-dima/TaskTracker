import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Task} from '../models/taks';

@Injectable({
  providedIn: 'root'
})
export class TaskService {
  private readonly apiUrl = 'http://localhost:8080/api/tasks';
  constructor(private http: HttpClient) { }

  // Fetch all tasks
  getTasks(): Observable<Task[]> {
    // Implementation to fetch tasks from the backend API
    return this.http.get<Task[]>(this.apiUrl);
  }

  // Update a task
  updateTask(taskId: number, updates: Partial<Task>): Observable<Task> {
    // Implementation to update a task in the backend API
    return this.http.put<Task>(`${this.apiUrl}/${taskId}`, updates);
  }
}
