import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NavbarGradeNewsletterComponent } from './navbar-grade-newsletter.component';

describe('NavbarGradeNewsletterComponent', () => {
  let component: NavbarGradeNewsletterComponent;
  let fixture: ComponentFixture<NavbarGradeNewsletterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [NavbarGradeNewsletterComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NavbarGradeNewsletterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
