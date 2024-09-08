import { TestBed } from '@angular/core/testing';

import { NavegationInstitutionalService } from './navegation-institutional.service';

describe('NavegationInstitutionalService', () => {
  let service: NavegationInstitutionalService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(NavegationInstitutionalService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
