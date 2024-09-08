import { Component } from '@angular/core';
import { Person } from '../../models/person';
import { ModalUserInstitutionalService } from '../../service/modal/modal-user-institutional.service';

@Component({
  selector: 'app-institutional-user-parents',
  standalone: true,
  imports: [],
  templateUrl: './institutional-user-parents.component.html',
  styleUrl: './institutional-user-parents.component.css'
})
export class InstitutionalUserParentsComponent {

  selectedUser: Person | null = null;
  selectedParent: Person | null = null;

  // Datos de prueba
  persons: Person[] = [
    {
      id: 1,
      nombre: "Pepito Luis",
      apellido: "Diomedezez",
      fechaNacimiento: "2005-04-12",
      documento: "cedula",
      n: "987654",
      sexo: "M",
      grado: "5to",
      seccion: "A",
      turno: "Tarde",
      
      tipo: "padres",
      codigoalumno: "12345",
      legajo:12345
    },
    {
      id: 2,
      nombre: "Pepito Isabel",
      apellido: "Diomedezez",
      fechaNacimiento: "2005-04-12",
      documento: "cedula",
      n: "987654",
      sexo: "M",
      grado: "5to",
      seccion: "A",
      turno: "Tarde",
      
      tipo: "padres",
      codigoalumno: "12345",
      legajo:23456
    },
    {
      id: 3,
      nombre: "Pepito Shaki",
      apellido: "Diomedezez",
      fechaNacimiento: "2005-04-12",
      documento: "cedula",
      n: "987654",
      sexo: "M",
      grado: "5to",
      seccion: "A",
      turno: "Tarde",
      
      tipo: "padres",
      codigoalumno: "12345",
      legajo:34567
    },
    {
      id: 4,
      nombre: "Pepito Fernando",
      apellido: "Diomedezez",
      fechaNacimiento: "2005-04-12",
      documento: "cedula",
      n: "987654",
      sexo: "M",
      grado: "5to",
      seccion: "A",
      turno: "Tarde",
      
      tipo: "padres",
      codigoalumno: "12345",
      legajo:891011  
     }
  ];
  

  constructor(private modalUserInstitutionalService: ModalUserInstitutionalService) {}

  ngOnInit() {
    this.modalUserInstitutionalService.selectedUser$.subscribe(user => {
      this.selectedUser = user;
      if (user) {
        this.loadParentData(user);
      }
    });
  }

  openModal(user: Person) {
    this.modalUserInstitutionalService.showModal(user);
  }

  loadParentData(user: Person) {
    // Solo buscamos padres
    if (user.tipo === 'padres' && user.codigoalumno) {
      this.selectedParent = this.persons.find(p => p.codigoalumno === user.codigoalumno) || null;
    }
  }


    
}
