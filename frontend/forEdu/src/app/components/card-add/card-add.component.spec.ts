import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardAddComponent } from './card-add.component';

describe('CardAddComponent', () => {
  let component: CardAddComponent;
  let fixture: ComponentFixture<CardAddComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CardAddComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CardAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
