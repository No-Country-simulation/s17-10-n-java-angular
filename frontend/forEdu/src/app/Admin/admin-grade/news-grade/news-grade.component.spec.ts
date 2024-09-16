import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewsGradeComponent } from './news-grade.component';

describe('NewsGradeComponent', () => {
  let component: NewsGradeComponent;
  let fixture: ComponentFixture<NewsGradeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [NewsGradeComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NewsGradeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
