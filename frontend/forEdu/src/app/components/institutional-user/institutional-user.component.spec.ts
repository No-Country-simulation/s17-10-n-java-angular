import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InstitutionalUserComponent } from './institutional-user.component';

describe('InstitutionalUserComponent', () => {
  let component: InstitutionalUserComponent;
  let fixture: ComponentFixture<InstitutionalUserComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [InstitutionalUserComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InstitutionalUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
