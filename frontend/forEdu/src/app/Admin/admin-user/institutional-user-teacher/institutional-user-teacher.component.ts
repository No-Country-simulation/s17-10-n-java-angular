import { Component, OnInit } from '@angular/core';
import { ModalUserInstitutionalService } from '../../../service/modal/modal-user-institutional.service';
import { Person } from '../../../models/person';
import { ProfesorService } from '../../../service/profesor.service';
import { DataIterable, GetAll } from '../../../interfaces/profesor/get-all';
import { GradeRegisterService } from '../../../service/grade-register.service';
import { GradeRegister } from '../../../interfaces/grade-register';
import { CommonModule } from '@angular/common';
import { Getgrade } from '../../../interfaces/getgrade';

@Component({
  selector: 'app-institutional-user-teacher',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './institutional-user-teacher.component.html',
  styleUrls: ['./institutional-user-teacher.component.css']  // Corrige el nombre de la propiedad
})
export class InstitutionalUserTeacherComponent implements OnInit {
  selectedUser: Person | null = null;
  profesores: DataIterable[] = [];
  grados: GradeRegister[] = [];

  constructor(
    private modalUserInstitutionalService: ModalUserInstitutionalService,
    private profesorService: ProfesorService,
    private gradoService: GradeRegisterService
  ) {}

  ngOnInit(): void {
    this.getGrados(); 
    this.getProfesores();
  }

  getGrados(): void {
    this.gradoService.getAllGrade().subscribe(
      (response: GradeRegister[]) => {
      
        if (Array.isArray(response) && Array.isArray(response[0])) {
          this.grados = response[0];
        } else {
          this.grados = response; 
        }
      },
      (error) => {
        console.error('Error al obtener los grados:', error);
      }
    );
  }

  getProfesores(): void {
    this.profesorService.getAllProfesor().subscribe(
      (response: GetAll) => {
        this.profesores = response.dataIterable;
        
        
        this.profesores.forEach(profesor => {
        
          if (profesor.gradoIds) {
            profesor.grados = profesor.gradoIds.map(gradoId => this.getGradoById(gradoId));
          }
        });
      },
      (error) => {
        console.error('Error al obtener los profesores:', error); 
      }
    );
  }

  getGradoById(id: number): string {
    const grado = this.grados.find(g => g.id === id);
    return grado ? `${grado.curso} ${grado.aula}` : 'Grado no encontrado';
  }

  openModal(user: any) {
    this.modalUserInstitutionalService.showModal(user);
    this.modalUserInstitutionalService.selectedUser$.subscribe(user => this.selectedUser = user);
  }
}
