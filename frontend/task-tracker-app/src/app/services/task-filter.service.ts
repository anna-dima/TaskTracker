import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

export interface TaskFilter {
  type: 'all' | 'project' | 'today';
  projectId?: number;
  name: string;
}

@Injectable({
  providedIn: 'root'
})
export class TaskFilterService {
  private filterSubject = new BehaviorSubject<TaskFilter>({ type: 'all', name: 'All Tasks' });
  public filter$ = this.filterSubject.asObservable();

  setFilter(filter: TaskFilter): void {
    this.filterSubject.next(filter);
  }

  showAllTasks(): void {
    this.setFilter({ type: 'all', name: 'All Tasks' });
  }

  showProjectTasks(projectId: number, projectName: string): void {
    this.setFilter({ type: 'project', projectId, name: projectName });
  }

  showTodayTasks(): void {
    this.setFilter({ type: 'today', name: 'My Day' });
  }
}
