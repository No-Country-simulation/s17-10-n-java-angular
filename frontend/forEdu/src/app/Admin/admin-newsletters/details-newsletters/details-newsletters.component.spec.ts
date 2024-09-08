import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailsNewslettersComponent } from './details-newsletters.component';

describe('DetailsNewslettersComponent', () => {
  let component: DetailsNewslettersComponent;
  let fixture: ComponentFixture<DetailsNewslettersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DetailsNewslettersComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DetailsNewslettersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
