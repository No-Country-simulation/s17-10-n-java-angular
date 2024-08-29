import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { GradeComponent } from './Admin/admin-grade/grade/grade.component';
import { DetailComponent } from './Admin/admin-grade/detail/detail.component';


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet,
    GradeComponent,
    DetailComponent





  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'forEdu';
}
