import { TestBed } from '@angular/core/testing';

import { DecodeService } from './decode.service';

describe('DecodeService', () => {
  let service: DecodeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DecodeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
