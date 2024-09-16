import { Component } from '@angular/core';
import { ModalUserInstitutionalService } from '../../../service/modal/modal-user-institutional.service';
import { Person } from '../../../models/person';


@Component({
  selector: 'app-institutional-user-teacher',
  standalone: true,
  imports: [],
  templateUrl: './institutional-user-teacher.component.html',
  styleUrl: './institutional-user-teacher.component.css'
})
export class InstitutionalUserTeacherComponent {
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
      nombre: "Jaime Luis",
      apellido: "Guerra",
      fechaNacimiento: "2005-04-12",
      documento: "cedula",
      n: "987654",
      sexo: "M",
      grado: "5to",
      seccion: "A",
      turno: "Tarde",

      tipo: "profesor",
      asignatura: "Fisica",
    },
    {

      id: 2,
      nombre: "Ana Mina",
      apellido: "Medranda",
      fechaNacimiento: "2005-04-12",
      documento: "cedula",
      n: "987654",
      sexo: "M",
      grado: "5to",
      seccion: "A",
      turno: "Tarde",

      tipo: "profesor",
      asignatura: "Ciencias",
    },
    {

      id:3,
      nombre: "Ruby Rulexy",
      apellido: "Quevedo",
      fechaNacimiento: "2005-04-12",
      documento: "cedula",
      n: "987654",
      sexo: "M",
      grado: "5to",
      seccion: "A",
      turno: "Tarde",

      tipo: "profesor",
      asignatura: "Computacion",
    },
    {

      id:3,
      nombre: "Bryan Byron",
      apellido: "Alcivar",
      fechaNacimiento: "2005-04-12",
      documento: "cedula",
      n: "987654",
      sexo: "M",
      grado: "5to",
      seccion: "A",
      turno: "Tarde",

      tipo: "profesor",
      asignatura: "Economia",
    }
  ];

}
