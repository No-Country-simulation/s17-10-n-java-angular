import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InstitutionalRegisterParentsComponent } from './institutional-register-parents.component';

describe('InstitutionalRegisterParentsComponent', () => {
  let component: InstitutionalRegisterParentsComponent;
  let fixture: ComponentFixture<InstitutionalRegisterParentsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [InstitutionalRegisterParentsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InstitutionalRegisterParentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
