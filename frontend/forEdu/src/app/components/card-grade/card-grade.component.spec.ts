import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardGradeComponent } from './card-grade.component';

describe('CardGradeComponent', () => {
  let component: CardGradeComponent;
  let fixture: ComponentFixture<CardGradeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CardGradeComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CardGradeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
