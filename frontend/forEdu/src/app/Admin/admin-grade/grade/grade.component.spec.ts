import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GradeComponent } from './grade.component';

describe('GradeComponent', () => {
  let component: GradeComponent;
  let fixture: ComponentFixture<GradeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GradeComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GradeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
