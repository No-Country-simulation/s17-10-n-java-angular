import { Component} from '@angular/core';
import { ModalUserInstitutionalService } from '../../service/modal/modal-user-institutional.service';
import { Person } from '../../models/person';
import { Router } from '@angular/router';

@Component({
  selector: 'app-institutional-user-student',
  standalone: true,
  imports: [],
  templateUrl: './institutional-user-student.component.html',
  styleUrl: './institutional-user-student.component.css'
})
export class InstitutionalUserStudentComponent {
  selectedUser: Person | null = null;

  constructor(private modalUserInstitutionalService: ModalUserInstitutionalService) {}

  openModal(user: Person) {
    this.modalUserInstitutionalService.showModal(user);
    this.modalUserInstitutionalService.selectedUser$.subscribe(user => this.selectedUser = user);
  }


  persons: Person[] = [
    // Datos de prueba
    {
      id: 1,
      nombre: "Juan Luis",
      apellido: "Diomedezez",
      fechaNacimiento: "2005-04-12",
      documento: "cedula",
      n: "987654",
      sexo: "M",
      grado: "5to",
      seccion: "A",
      turno: "Tarde",
      
      tipo: "estudiante",
      codigoalumno: "12345",
      legajo:12345
    },
    {
      id: 2,
      nombre: "Maria Isabel",
      apellido: "Diomedezez",
      fechaNacimiento: "2005-04-12",
      documento: "cedula",
      n: "987654",
      sexo: "M",
      grado: "5to",
      seccion: "A",
      turno: "Tarde",
      
      tipo: "estudiante",
      codigoalumno: "12345",
      legajo:23456
    },
    {
      id: 3,
      nombre: "Valinda Shaki",
      apellido: "Diomedezez",
      fechaNacimiento: "2005-04-12",
      documento: "cedula",
      n: "987654",
      sexo: "M",
      grado: "5to",
      seccion: "A",
      turno: "Tarde",
      
      tipo: "estudiante",
      codigoalumno: "12345",
      legajo:34567
    },
    {
      id: 4,
      nombre: "Carlos Fernando",
      apellido: "Diomedezez",
      fechaNacimiento: "2005-04-12",
      documento: "cedula",
      n: "987654",
      sexo: "M",
      grado: "5to",
      seccion: "A",
      turno: "Tarde",
      
      tipo: "estudiante",
      codigoalumno: "12345",
      legajo:891011  
     }
  ];
}
