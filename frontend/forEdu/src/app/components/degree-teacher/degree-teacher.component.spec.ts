import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DegreeTeacherComponent } from './degree-teacher.component';

describe('DegreeTeacherComponent', () => {
  let component: DegreeTeacherComponent;
  let fixture: ComponentFixture<DegreeTeacherComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DegreeTeacherComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DegreeTeacherComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
