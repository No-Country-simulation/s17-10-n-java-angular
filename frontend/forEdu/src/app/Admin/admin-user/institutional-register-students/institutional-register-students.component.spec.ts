import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InstitutionalRegisterStudentsComponent } from './institutional-register-students.component';

describe('InstitutionalRegisterStudentsComponent', () => {
  let component: InstitutionalRegisterStudentsComponent;
  let fixture: ComponentFixture<InstitutionalRegisterStudentsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [InstitutionalRegisterStudentsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InstitutionalRegisterStudentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
