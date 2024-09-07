import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InstitutionalUserAdminComponent } from './institutional-user-admin.component';

describe('InstitutionalUserAdminComponent', () => {
  let component: InstitutionalUserAdminComponent;
  let fixture: ComponentFixture<InstitutionalUserAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [InstitutionalUserAdminComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InstitutionalUserAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
