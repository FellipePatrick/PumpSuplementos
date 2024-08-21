import { TestBed } from '@angular/core/testing';

import { SuplementosServiceService } from './suplementos-service.service';

describe('SuplementosServiceService', () => {
  let service: SuplementosServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SuplementosServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
