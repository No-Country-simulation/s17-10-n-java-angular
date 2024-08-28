import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { GradeComponent } from './Admin/admin-grade/grade/grade.component';
import { CardGradeComponent } from './components/card-grade/card-grade.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet,
    GradeComponent,
    CardGradeComponent



  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'forEdu';
}
