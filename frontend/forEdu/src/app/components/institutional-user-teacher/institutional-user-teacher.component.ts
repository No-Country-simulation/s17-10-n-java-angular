import { Component } from '@angular/core';
import { ModalUserInstitutionalService } from '../../service/modal/modal-user-institutional.service';

@Component({
  selector: 'app-institutional-user-teacher',
  standalone: true,
  imports: [],
  templateUrl: './institutional-user-teacher.component.html',
  styleUrl: './institutional-user-teacher.component.css'
})
export class InstitutionalUserTeacherComponent {

  constructor(private modalUserInstitutionalService: ModalUserInstitutionalService) {}

  openModal(user: any) {
    this.modalUserInstitutionalService.showModal(user);
  }

  
  persons = [
    {
      id: 1,
      nombre: "Juan Pérez",
      grado: "12345",
      seccion: "2005-04-12",
      deparatamento: "5to",
      categoria: "principal"
    },
    {
      id: 2,
      nombre: "Juan Pérez",
      grado: "12345",
      seccion: "2005-04-12",
      deparatamento: "5to",
      categoria: "secundario"
    },
    {
      id: 3,
      nombre: "Juan Pérez",
      grado: "12345",
      seccion: "2005-04-12",
      deparatamento: "5to",
      categoria: "principal"
    },
    {
      id: 4,
      nombre: "Juan Pérez",
      grado: "12345",
      seccion: "2005-04-12",
      deparatamento: "5to",
      categoria: "secundario"
    },
    {
      id: 5,
      nombre: "Juan Pérez",
      grado: "12345",
      seccion: "2005-04-12",
      deparatamento: "5to",
      categoria: "secundario"
    },
    {
      id: 6,
      nombre: "Juan Pérez",
      grado: "12345",
      seccion: "2005-04-12",
      deparatamento: "5to",
      categoria: "secundario"
    },
    {
      id: 7,
      nombre: "Juan Pérez",
      grado: "12345",
      seccion: "2005-04-12",
      deparatamento: "5to",
      categoria: "secundario"
    },
  ];
}
