import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PostNewsGradeComponent } from './post-news-grade.component';

describe('PostNewsGradeComponent', () => {
  let component: PostNewsGradeComponent;
  let fixture: ComponentFixture<PostNewsGradeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PostNewsGradeComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PostNewsGradeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
