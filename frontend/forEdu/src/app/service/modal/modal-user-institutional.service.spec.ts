import { TestBed } from '@angular/core/testing';

import { ModalUserInstitutionalService } from './modal-user-institutional.service';

describe('ModalUserInstitutionalService', () => {
  let service: ModalUserInstitutionalService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ModalUserInstitutionalService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
