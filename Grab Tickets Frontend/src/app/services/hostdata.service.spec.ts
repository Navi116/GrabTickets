import { TestBed } from '@angular/core/testing';

import { HostDataService } from './hostdata.service';

describe('HostDataService', () => {
  let service: HostDataService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HostDataService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
