import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InstitutionalUserParentsComponent } from './institutional-user-parents.component';

describe('InstitutionalUserParentsComponent', () => {
  let component: InstitutionalUserParentsComponent;
  let fixture: ComponentFixture<InstitutionalUserParentsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [InstitutionalUserParentsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InstitutionalUserParentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
