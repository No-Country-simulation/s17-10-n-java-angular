import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModalUserIntitutionalComponent } from './modal-user-intitutional.component';

describe('ModalUserIntitutionalComponent', () => {
  let component: ModalUserIntitutionalComponent;
  let fixture: ComponentFixture<ModalUserIntitutionalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ModalUserIntitutionalComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ModalUserIntitutionalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
