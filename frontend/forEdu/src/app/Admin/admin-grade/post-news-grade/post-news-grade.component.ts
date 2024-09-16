import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-post-news-grade',
  standalone: true,
  imports: [],
  templateUrl: './post-news-grade.component.html',
  styleUrl: './post-news-grade.component.css'
})
export class PostNewsGradeComponent {
  @Input() userImage: string = '';
  @Input() userName: string = '';
  @Input() postText: string = '';
  @Input() likes: number = 0;
  @Input() comments: number = 0;
  likePost() {
    this.likes++; // Incrementa el contador de likes
  }
}
