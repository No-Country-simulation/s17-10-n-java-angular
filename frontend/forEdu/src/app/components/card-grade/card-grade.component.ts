import { Component, Input, OnInit } from '@angular/core';
import { GradeRegister } from '../../interfaces/grade-register';
import { Router } from '@angular/router';

@Component({
  selector: 'app-card-grade',
  standalone: true,
  imports: [],
  templateUrl: './card-grade.component.html',
  styleUrls: ['./card-grade.component.css']
})
export class CardGradeComponent  {

   @Input() grade!: GradeRegister;

   constructor (private router:Router ){}


   navigateAsistencia(){
      return this.router.navigate(['/asistencia'])
   }
}
