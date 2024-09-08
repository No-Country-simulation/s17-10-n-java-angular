import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InstitutionalUserTeacherComponent } from './institutional-user-teacher.component';

describe('InstitutionalUserTeacherComponent', () => {
  let component: InstitutionalUserTeacherComponent;
  let fixture: ComponentFixture<InstitutionalUserTeacherComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [InstitutionalUserTeacherComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InstitutionalUserTeacherComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
