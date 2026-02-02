import { TestBed } from "@angular/core/testing";
import { ProjectService } from "./project.service";

//Service tests for ProjectService
describe('ProjectService', () => {
    let service: ProjectService;
    beforeEach(() => {
        TestBed.configureTestingModule({});
        service = TestBed.inject(ProjectService);
    });

    it('should be created', () => { 
        expect(service).toBeTruthy();
    });
});