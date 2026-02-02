//Model for the Project entity
import { Task } from './task';

export interface Project {
  id: number;
  title: string;
  description: string;
  tasks?: Task[];
}
