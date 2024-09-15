import { Component } from '@angular/core';
import { ModalUserInstitutionalService } from '../../../service/modal/modal-user-institutional.service';
import { FormsModule } from '@angular/forms';
import { MenubarModule } from 'primeng/menubar';
import { SplitButtonModule } from 'primeng/splitbutton';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-asistencia',
  standalone: true,
  imports: [
    FormsModule,
    MenubarModule,
    SplitButtonModule,
    CommonModule
  ],
  templateUrl: './asistencia.component.html',
  styleUrl: './asistencia.component.css'
})
export class AsistenciaComponent {
  items!: any[];


  ngOnInit() {

    this.items = [
      {
        label: 'Lunes',
        icon: 'pi pi-calendar',
        command: () => {
          this.mostrarFechas('Lunes');
        }
      },
      {
        label: 'Martes',
        icon: 'pi pi-calendar',
        command: () => {
          this.mostrarFechas('Martes');
        }
      },
      {
        label: 'Miércoles',
        icon: 'pi pi-calendar',
        command: () => {
          this.mostrarFechas('Miercoles');
        }
      },
      {
        label: 'Jueves',
        icon: 'pi pi-calendar',
        command: () => {
          this.mostrarFechas('Jueves');
        }
      },
      {
        label: 'Viernes',
        icon: 'pi pi-calendar',
        command: () => {
          this.mostrarFechas('Viernes');
        }
      }
    ];
  }
  mostrarFechas(dia: string) {
    // Lógica para mostrar las fechas o hacer alguna acción cuando se selecciona un día
    console.log('Fecha seleccionada: ', dia);
  }

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
  tablaActual: string = "administradores";

  mostrarTabla(tabla: string) {
    this.tablaActual = tabla;
  }

  persons = [
    {
      id: 1,
      nombre: "Juan Pérez",
      Asistencia: "70%",
      Justificativo: "Cargado",
      Lunes: false,
      Martes: false,
      Miercoles: true,
      Jueves: true,
      Viernes: true
    },
    {
      id: 2,
      nombre: "Ana García",
      Asistencia: "80%",
      Justificativo: "Cargado",
      Lunes: true,
      Martes: false,
      Miercoles: true,
      Jueves: false,
      Viernes: true
    },
    {
      id: 3,
      nombre: "Carlos López",
      Asistencia: "65%",
      Justificativo: "Cargado",
      Lunes: false,
      Martes: true,
      Miercoles: true,
      Jueves: false,
      Viernes: true
    },
    {
      id: 4,
      nombre: "María Fernández",
      Asistencia: "90%",
      Justificativo: "Cargado",
      Lunes: true,
      Martes: true,
      Miercoles: true,
      Jueves: true,
      Viernes: true
    },
    {
      id: 5,
      nombre: "Pedro Sánchez",
      Asistencia: "75%",
      Justificativo: "No Cargado",
      Lunes: true,
      Martes: false,
      Miercoles: false,
      Jueves: true,
      Viernes: true
    },
    {
      id: 6,
      nombre: "Lucía González",
      Asistencia: "85%",
      Justificativo: "Cargado",
      Lunes: true,
      Martes: true,
      Miercoles: true,
      Jueves: false,
      Viernes: true
    },
    {
      id: 7,
      nombre: "Miguel Torres",
      Asistencia: "60%",
      Justificativo: "No Cargado",
      Lunes: false,
      Martes: false,
      Miercoles: true,
      Jueves: true,
      Viernes: false
    },
    {
      id: 8,
      nombre: "Elena Ruiz",
      Asistencia: "95%",
      Justificativo: "Cargado",
      Lunes: true,
      Martes: true,
      Miercoles: true,
      Jueves: true,
      Viernes: true
    },
    {
      id: 9,
      nombre: "Fernando Ramírez",
      Asistencia: "50%",
      Justificativo: "No Cargado",
      Lunes: false,
      Martes: true,
      Miercoles: false,
      Jueves: false,
      Viernes: true
    },
    {
      id: 10,
      nombre: "Laura Morales",
      Asistencia: "85%",
      Justificativo: "Cargado",
      Lunes: true,
      Martes: true,
      Miercoles: true,
      Jueves: true,
      Viernes: false
    },
    {
      id: 11,
      nombre: "Javier Ortega",
      Asistencia: "70%",
      Justificativo: "No Cargado",
      Lunes: false,
      Martes: true,
      Miercoles: true,
      Jueves: false,
      Viernes: false
    },
    {
      id: 12,
      nombre: "Sofía Castillo",
      Asistencia: "90%",
      Justificativo: "Cargado",
      Lunes: true,
      Martes: true,
      Miercoles: true,
      Jueves: true,
      Viernes: true
    }


];
}
