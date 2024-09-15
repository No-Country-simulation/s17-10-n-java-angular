import { Component, Input, OnInit } from '@angular/core';
import { GradeRegister } from '../../interfaces/grade-register';

@Component({
  selector: 'app-card-grade',
  standalone: true,
  imports: [],
  templateUrl: './card-grade.component.html',
  styleUrls: ['./card-grade.component.css']
})
export class CardGradeComponent implements OnInit {

   @Input() grade!: GradeRegister;

   ngOnInit() {
     console.log('Valor recibido en grade:', this.grade);
   }

}
