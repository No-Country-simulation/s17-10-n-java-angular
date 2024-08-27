import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdmiDashboardComponent } from './admi-dashboard.component';

describe('AdmiDashboardComponent', () => {
  let component: AdmiDashboardComponent;
  let fixture: ComponentFixture<AdmiDashboardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AdmiDashboardComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdmiDashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
