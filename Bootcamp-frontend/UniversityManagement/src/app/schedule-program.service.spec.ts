import { TestBed } from '@angular/core/testing';

import { ScheduleProgramService } from './schedule-program.service';

describe('ScheduleProgramService', () => {
  let service: ScheduleProgramService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ScheduleProgramService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
