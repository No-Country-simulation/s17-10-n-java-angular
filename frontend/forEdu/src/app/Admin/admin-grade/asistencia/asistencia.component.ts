import { Component } from '@angular/core';
import { ModalUserInstitutionalService } from '../../../service/modal/modal-user-institutional.service';

@Component({
  selector: 'app-asistencia',
  standalone: true,
  imports: [],
  templateUrl: './asistencia.component.html',
  styleUrl: './asistencia.component.css'
})
export class AsistenciaComponent {

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
  tablaActual: string = "alumnos";

  mostrarTabla(tabla: string) {
    this.tablaActual = tabla;
  }

  persons = [
    {
        id: 1,
        nombre: "Juan Pérez",
        legajo: "12345",
        turno: "Mañana",
        fecha: "2024-09-04",
        cargado: "✔",
        tutores: "María López",
        accion: ""
    },
    {
        id: 2,
        nombre: "Ana Martínez",
        legajo: "67890",
        turno: "Tarde",
        fecha: "2024-09-04",
        cargado: "✔",
        tutores: "Carlos Martínez",
        accion: ""
    },
    {
        id: 3,
        nombre: "Luis Gómez",
        legajo: "11223",
        turno: "Mañana",
        fecha: "2024-09-04",
        cargado: "✔",
        tutores: "Laura Gómez",
        accion: ""
    },
    {
        id: 4,
        nombre: "Sofía Herrera",
        legajo: "44556",
        turno: "Tarde",
        fecha: "2024-09-04",
        cargado: "✔",
        tutores: "Pedro Herrera",
        accion: ""
    },
    {
        id: 5,
        nombre: "Carlos Díaz",
        legajo: "77889",
        turno: "Mañana",
        fecha: "2024-09-04",
        cargado: "✔",
        tutores: "Mónica Díaz",
        accion: ""
    },
    {
        id: 6,
        nombre: "Lucía Fernández",
        legajo: "99112",
        turno: "Tarde",
        fecha: "2024-09-04",
        cargado: "✔",
        tutores: "Miguel Fernández",
        accion: ""
    },
    {
        id: 7,
        nombre: "Miguel Torres",
        legajo: "33445",
        turno: "Mañana",
        fecha: "2024-09-04",
        cargado: "✔",
        tutores: "Sandra Torres",
        accion: ""
    },
    {
        id: 8,
        nombre: "Valentina Sánchez",
        legajo: "55667",
        turno: "Tarde",
        fecha: "2024-09-04",
        cargado: "✔",
        tutores: "Jorge Sánchez",
        accion: ""
    },
    {
        id: 9,
        nombre: "Andrés Castillo",
        legajo: "88990",
        turno: "Mañana",
        fecha: "2024-09-04",
        cargado: "✔",
        tutores: "Carmen Castillo",
        accion: ""
    },
    {
        id: 10,
        nombre: "Camila Romero",
        legajo: "22334",
        turno: "Tarde",
        fecha: "2024-09-04",
        cargado: "✔",
        tutores: "Alberto Romero",
        accion: ""
    },
    {
        id: 11,
        nombre: "Javier López",
        legajo: "66778",
        turno: "Mañana",
        fecha: "2024-09-04",
        cargado: "✔",
        tutores: "Paula López",
        accion: ""
    },
    {
        id: 12,
        nombre: "Martina Ruiz",
        legajo: "99001",
        turno: "Tarde",
        fecha: "2024-09-04",
        cargado: "✔",
        tutores: "Enrique Ruiz",
        accion: ""
    }
];
}
