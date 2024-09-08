import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InstitutionalRegisterTeacherComponent } from './institutional-register-teacher.component';

describe('InstitutionalRegisterTeacherComponent', () => {
  let component: InstitutionalRegisterTeacherComponent;
  let fixture: ComponentFixture<InstitutionalRegisterTeacherComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [InstitutionalRegisterTeacherComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InstitutionalRegisterTeacherComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
