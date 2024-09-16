import { Component } from '@angular/core';
import { PostNewsGradeComponent } from '../post-news-grade/post-news-grade.component';
import { FormsModule } from '@angular/forms';
import { MessageService } from 'primeng/api';
import { ToastModule } from 'primeng/toast';

@Component({
  selector: 'app-news-grade',
  standalone: true,
  imports: [PostNewsGradeComponent, FormsModule,ToastModule],
  templateUrl: './news-grade.component.html',
  styleUrl: './news-grade.component.css',
  providers:[MessageService]
})
export class NewsGradeComponent {

  newPostText: string = '';
  posts: any[] = [
   {
      userImage: 'novedades1.png',
      userName: 'Ana López',
      postText: '¡Emocionada por comenzar un nuevo proyecto en la oficina! 🖥️✨',
      likes: 24,
      comments: 5
    },
    {
      userImage: 'user3.png',
      userName: 'Carlos García',
      postText: 'Hoy aprendí mucho sobre Angular y cómo manejar rutas hijas. 🚀 ¿Alguien más está trabajando en esto?',
      likes: 30,
      comments: 8
    },
    {
      userImage: 'novedades2.png',
      userName: 'Lucía Fernández',
      postText: '¡Un día increíble para salir a correr! 🏃‍♀️🌞 ¿Alguien se une?',
      likes: 15,
      comments: 2
    },
    {
      userImage: 'user4.png',
      userName: 'Roberto Pérez',
      postText: 'Hoy descubrí un café excelente en la esquina, perfecto para trabajar tranquilo. ☕ ¿Tienen algún lugar favorito?',
      likes: 18,
      comments: 3
    },
  ];  // Usamos `any[]` para evitar definir una interface

  constructor(private messageService:MessageService){}


  addPost() {
    if (this.newPostText.trim()) {
      this.messageService.add({severity:"success",summary:"Exito",detail:"Creado un post con exito"})
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
