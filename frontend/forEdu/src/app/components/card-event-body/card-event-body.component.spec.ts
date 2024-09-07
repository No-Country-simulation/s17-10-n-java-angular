import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardEventBodyComponent } from './card-event-body.component';

describe('CardEventBodyComponent', () => {
  let component: CardEventBodyComponent;
  let fixture: ComponentFixture<CardEventBodyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CardEventBodyComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CardEventBodyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
