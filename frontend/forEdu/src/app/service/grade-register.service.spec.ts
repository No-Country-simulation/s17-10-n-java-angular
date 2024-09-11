import { TestBed } from '@angular/core/testing';

import { GradeRegisterService } from './grade-register.service';

describe('GradeRegisterService', () => {
  let service: GradeRegisterService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GradeRegisterService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
