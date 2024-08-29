import { Component } from '@angular/core';
import { CardModule } from 'primeng/card';
import { ButtonModule } from 'primeng/button';
import { CardGradeComponent } from '../../../components/card-grade/card-grade.component';
import { CardAddComponent } from '../../../components/card-add/card-add.component';

@Component({
  selector: 'app-grade',
  standalone: true,
  imports: [
    CardModule,
    ButtonModule,
    CardGradeComponent,
    CardAddComponent
  ],
  templateUrl: './grade.component.html',
  styleUrl: './grade.component.css'
})
export class GradeComponent {

}
