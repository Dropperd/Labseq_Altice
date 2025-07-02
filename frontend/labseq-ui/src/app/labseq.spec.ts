import { TestBed } from '@angular/core/testing';

import { LabseqService } from './labseq.service';
import { HttpClientTestingModule } from '@angular/common/http/testing';

describe('LabseqService', () => {
  let service: LabseqService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule], 
      providers: [LabseqService]
    });
    service = TestBed.inject(LabseqService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should have getLabseq method', () => {
    expect(service.getLabseq).toBeDefined();
  });
});