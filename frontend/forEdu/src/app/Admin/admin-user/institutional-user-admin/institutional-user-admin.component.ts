import { Component } from '@angular/core';
import { ModalUserInstitutionalService } from '../../../service/modal/modal-user-institutional.service';

@Component({
  selector: 'app-institutional-user-admin',
  standalone: true,
  imports: [],
  templateUrl: './institutional-user-admin.component.html',
  styleUrl: './institutional-user-admin.component.css'
})
export class InstitutionalUserAdminComponent {
  
  constructor(private modalUserInstitutionalService: ModalUserInstitutionalService) {}

  openModal(user: any) {
    this.modalUserInstitutionalService.showModal(user);
  }
  
  persons = [
    {
      id: 1,
      nombre: "Mario Calderon",
    },
    {
      id: 2,
      nombre: "Ana Gómez",
    },
    {
      id: 3,
      nombre: "Luis Fernández",
    },
    {
      id: 4,
      nombre: "Marta Díaz",
    },
    {
      id: 5,
      nombre: "Pedro Martínez",
    },
    {
      id: 6,
      nombre: "Sofía Castillo",
    },
    {
      id: 7,
      nombre: "Diego Ruiz",
    },
    {
      id: 8,
      nombre: "Claudia Moreno",
    },
    {
      id: 9,
      nombre: "Ricardo Martínez",
    },
    {
      id: 10,
      nombre: "Isabel Romero",
    },
    {
      id: 11,
      nombre: "David López",

    },
    {
      id: 12,
      nombre: "Laura Vargas",
    }
  ];

}
