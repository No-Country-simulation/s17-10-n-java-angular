import { Component } from '@angular/core';
import { PostNewsGradeComponent } from '../post-news-grade/post-news-grade.component';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-news-grade',
  standalone: true,
  imports: [PostNewsGradeComponent, FormsModule],
  templateUrl: './news-grade.component.html',
  styleUrl: './news-grade.component.css'
})
export class NewsGradeComponent {
  
  newPostText: string = '';
  posts: any[] = [];  // Usamos `any[]` para evitar definir una interface

  addPost() {
    if (this.newPostText.trim()) {
      const newPost = {
        userImage: 'ruta_de_la_imagen.jpg', // Cambia esto por la imagen del usuario
        userName: 'Nombre del Usuario',     // Cambia por el nombre del usuario
        postText: this.newPostText,
        likes: 0,
        comments: 0
      };

      this.posts.unshift(newPost); // Agrega el nuevo post al principio de la lista
      this.newPostText = ''; // Limpia el textarea
    }
  }
}
