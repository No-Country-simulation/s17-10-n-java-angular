import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NavbarInstitutionalComponent } from './navbar-institutional.component';

describe('NavbarInstitutionalComponent', () => {
  let component: NavbarInstitutionalComponent;
  let fixture: ComponentFixture<NavbarInstitutionalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [NavbarInstitutionalComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NavbarInstitutionalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
