import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DegreeStudentComponent } from './degree-student.component';

describe('DegreeStudentComponent', () => {
  let component: DegreeStudentComponent;
  let fixture: ComponentFixture<DegreeStudentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DegreeStudentComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DegreeStudentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
