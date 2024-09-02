import { Component} from '@angular/core';
import { ModalUserInstitutionalService } from '../../service/modal/modal-user-institutional.service';

@Component({
  selector: 'app-institutional-user-student',
  standalone: true,
  imports: [],
  templateUrl: './institutional-user-student.component.html',
  styleUrl: './institutional-user-student.component.css'
})
export class InstitutionalUserStudentComponent {

  constructor(private modalUserInstitutionalService: ModalUserInstitutionalService) {}

  openModal(user: any) {
    this.modalUserInstitutionalService.showModal(user);
  }

  isModalVisible = false;

  opeenModal() {
    this.isModalVisible = true;
  }

  closeModal() {
    this.isModalVisible = false;
  }
  
  persons = [
    {
      id: 1,
      nombre: "Juan Pérez",
      legajo: "12345",
      fechaNacimiento: "2005-04-12",
      grado: "5to",
      turno: "Mañana",
      tutores: "María López",
      accion: "Editar"
    },
    {
      id: 2,
      nombre: "Ana Gómez",
      legajo: "67890",
      fechaNacimiento: "2006-07-25",
      grado: "6to",
      turno: "Tarde",
      tutores: "Carlos Gómez",
      accion: "Editar"
    },
    {
      id: 3,
      nombre: "Luis Fernández",
      legajo: "11223",
      fechaNacimiento: "2007-09-14",
      grado: "4to",
      turno: "Mañana",
      tutores: "Lucía Fernández",
      accion: "Editar"
    },
    {
      id: 4,
      nombre: "Marta Díaz",
      legajo: "33445",
      fechaNacimiento: "2005-11-02",
      grado: "5to",
      turno: "Tarde",
      tutores: "Ricardo Díaz",
      accion: "Editar"
    },
    {
      id: 5,
      nombre: "Pedro Martínez",
      legajo: "55667",
      fechaNacimiento: "2006-02-18",
      grado: "6to",
      turno: "Mañana",
      tutores: "Elena Martínez",
      accion: "Editar"
    },
    {
      id: 6,
      nombre: "Sofía Castillo",
      legajo: "77889",
      fechaNacimiento: "2007-03-30",
      grado: "4to",
      turno: "Tarde",
      tutores: "Alberto Castillo",
      accion: "Editar"
    },
    {
      id: 7,
      nombre: "Diego Ruiz",
      legajo: "99001",
      fechaNacimiento: "2005-06-05",
      grado: "5to",
      turno: "Mañana",
      tutores: "Beatriz Ruiz",
      accion: "Editar"
    },
    {
      id: 8,
      nombre: "Claudia Moreno",
      legajo: "11234",
      fechaNacimiento: "2008-01-22",
      grado: "3ro",
      turno: "Mañana",
      tutores: "Jorge Moreno",
      accion: "Editar"
    },
    {
      id: 9,
      nombre: "Ricardo Martínez",
      legajo: "22345",
      fechaNacimiento: "2007-05-11",
      grado: "5to",
      turno: "Tarde",
      tutores: "Ana Martínez",
      accion: "Editar"
    },
    {
      id: 10,
      nombre: "Isabel Romero",
      legajo: "33456",
      fechaNacimiento: "2006-09-20",
      grado: "6to",
      turno: "Mañana",
      tutores: "Luis Romero",
      accion: "Editar"
    },
    {
      id: 11,
      nombre: "David López",
      legajo: "44567",
      fechaNacimiento: "2008-03-15",
      grado: "4to",
      turno: "Tarde",
      tutores: "Carmen López",
      accion: "Editar"
    },
    {
      id: 12,
      nombre: "Laura Vargas",
      legajo: "55678",
      fechaNacimiento: "2007-12-01",
      grado: "5to",
      turno: "Mañana",
      tutores: "Miguel Vargas",
      accion: "Editar"
    }
  ];
}
