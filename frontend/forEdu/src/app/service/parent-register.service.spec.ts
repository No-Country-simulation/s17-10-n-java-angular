import { TestBed } from '@angular/core/testing';

import { ParentRegisterService } from './parent-register.service';

describe('ParentRegisterService', () => {
  let service: ParentRegisterService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ParentRegisterService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
