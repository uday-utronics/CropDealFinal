import { TestBed } from '@angular/core/testing';

import { DealerServiceService } from './dealer-service.service';

describe('DealerServiceService', () => {
  let service: DealerServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DealerServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
