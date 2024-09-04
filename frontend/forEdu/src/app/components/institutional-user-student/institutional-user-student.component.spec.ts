import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InstitutionalUserStudentComponent } from './institutional-user-student.component';

describe('InstitutionalUserStudentComponent', () => {
  let component: InstitutionalUserStudentComponent;
  let fixture: ComponentFixture<InstitutionalUserStudentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [InstitutionalUserStudentComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InstitutionalUserStudentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
