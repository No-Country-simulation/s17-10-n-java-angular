import { Component, Input } from '@angular/core';
import { GradeRegister } from '../../interfaces/grade-register';

@Component({
  selector: 'app-card-grade',
  standalone: true,
  imports: [],
  templateUrl: './card-grade.component.html',
  styleUrl: './card-grade.component.css'
})
export class CardGradeComponent {

   @Input() grade!: GradeRegister;

}
