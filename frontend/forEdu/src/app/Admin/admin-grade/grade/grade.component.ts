import { Component } from '@angular/core';
import { CardModule } from 'primeng/card';
import { ButtonModule } from 'primeng/button';
import { CardGradeComponent } from '../../../components/card-grade/card-grade.component';
import { CardAddComponent } from '../../../components/card-add/card-add.component';
import { NavbarComponent } from "../../../components/navbar/navbar.component";
import { SidebarComponent } from "../../../components/sidebar/sidebar.component";
import { GradeRegister } from '../../../interfaces/grade-register';
import { GradeRegisterService } from '../../../service/grade-register.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-grade',
  standalone: true,
  imports: [
    CardModule,
    ButtonModule,
    CardGradeComponent,
    CardAddComponent,
    NavbarComponent,
    SidebarComponent,
    CommonModule
  ],
  templateUrl: './grade.component.html',
  styleUrls: ['./grade.component.css']
})
export class GradeComponent {

  grades: GradeRegister[] = [];
  filteredGrades: GradeRegister[] = [];
  selectedTurno: string = 'TODOS';

  constructor(private gradeService: GradeRegisterService) {}

  ngOnInit(): void {
    this.gradeService.getAllGrade().subscribe({
      next: (response) => {
        if (Array.isArray(response) && Array.isArray(response[0])) {
          this.grades = response[0];
        } else {
          this.grades = response;
        }
        this.filteredGrades = this.grades; // Inicialmente, muestra todas las calificaciones
      },
      error: (err) => {
        console.error('Error al obtener la lista de grados:', err);
      }
    });
  }

  filterTurno(turno: string): void {
    this.selectedTurno = turno;
    if (turno === 'TODOS') {
      this.filteredGrades = this.grades;
    } else {
      this.filteredGrades = this.grades.filter(grade => grade.turno === turno);
    }
  }
}
