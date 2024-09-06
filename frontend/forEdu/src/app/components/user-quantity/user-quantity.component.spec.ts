import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserQuantityComponent } from './user-quantity.component';

describe('UserQuantityComponent', () => {
  let component: UserQuantityComponent;
  let fixture: ComponentFixture<UserQuantityComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UserQuantityComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UserQuantityComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
