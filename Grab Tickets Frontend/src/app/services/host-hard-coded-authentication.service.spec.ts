import { TestBed } from '@angular/core/testing';

import { HostHardCodedAuthenticationService } from './host-hard-coded-authentication.service';

describe('HostHardCodedAuthenticationService', () => {
  let service: HostHardCodedAuthenticationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HostHardCodedAuthenticationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
