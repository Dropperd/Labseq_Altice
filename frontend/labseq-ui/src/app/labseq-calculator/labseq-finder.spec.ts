import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LabseqFinder } from './labseq-finder';

describe('LabseqFinder', () => {
  let component: LabseqFinder;
  let fixture: ComponentFixture<LabseqFinder>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [LabseqFinder]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LabseqFinder);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
