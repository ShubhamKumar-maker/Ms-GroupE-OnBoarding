import { TestBed } from '@angular/core/testing';

import { OnboardeeServiceService } from './onboardee-service.service';

describe('OnboardeeServiceService', () => {
  let service: OnboardeeServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(OnboardeeServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
