import { TestBed } from '@angular/core/testing';

import { PartnerHardCodedAuthenticationService } from './partner-hard-coded-authentication.service';

describe('PartnerHardCodedAuthenticationService', () => {
  let service: PartnerHardCodedAuthenticationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PartnerHardCodedAuthenticationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
