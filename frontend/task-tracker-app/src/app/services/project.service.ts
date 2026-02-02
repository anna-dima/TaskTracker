import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import {Project} from '../models/project';
import { Injectable } from "@angular/core";

//Service for managing Project entities
@Injectable({
  providedIn: 'root'
})
export class ProjectService {
  private readonly apiUrl = 'http://localhost:8080/api/projects';
    constructor(private http: HttpClient) { }

    // Fetch all projects
    getProjects(): Observable<Project[]> {
        return this.http.get<Project[]>(this.apiUrl);
    }
    // Create a new project
    createProject(project: Partial<Project>): Observable<Project> {
        return this.http.post<Project>(this.apiUrl, project);
    }
    // Update an existing project
    updateProject(projectId: number, updates: Partial<Project>): Observable<Project> {
        return this.http.put<Project>(`${this.apiUrl}/${projectId}`, updates);
    }
    // Delete a project
    deleteProject(projectId: number): Observable<void> {
        return this.http.delete<void>(`${this.apiUrl}/${projectId}`);
    }
    

}
