import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
//Import the Project model
import { Project } from '../models/project';
//Import the Project service
import { ProjectService } from '../services/project.service';
//Import the Task filter service
import { TaskFilterService } from '../services/task-filter.service';

@Component({
  selector: 'app-project-list',
  imports: [CommonModule],
  templateUrl: './project-list.component.html',
  styleUrl: './project-list.component.css'
})
export class ProjectListComponent implements OnInit {
  projects: Project[] = [];
  selectedFilter: 'all' | 'today' | number = 'all';

  constructor(
    private projectService: ProjectService,
    private taskFilterService: TaskFilterService
  ) {}

  ngOnInit(): void {
    this.loadProjects();
  }

  loadProjects(): void {
    this.projectService.getProjects().subscribe((projects) => {
      this.projects = projects;
    });
  }

  onProjectAction(project: Project): void {
    if (project.id !== undefined) {
      this.selectedFilter = project.id;
      this.taskFilterService.showProjectTasks(project.id, project.title);
    }
  }

  onAllTasksAction(): void {
    this.selectedFilter = 'all';
    this.taskFilterService.showAllTasks();
  }

  onMyDayAction(): void {
    this.selectedFilter = 'today';
    this.taskFilterService.showTodayTasks();
  }

  isSelected(id: 'all' | 'today' | number): boolean {
    return this.selectedFilter === id;
  }
}