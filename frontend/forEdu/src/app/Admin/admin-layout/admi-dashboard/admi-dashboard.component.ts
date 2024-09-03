
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MenuItem } from 'primeng/api';
import { ButtonModule } from 'primeng/button';
import { CalendarModule } from 'primeng/calendar';
import { SplitButtonModule } from 'primeng/splitbutton';
import { CommonModule } from '@angular/common';




@Component({
  selector: 'app-admi-dashboard',
  standalone: true,
  imports: [ CalendarModule, ButtonModule, FormsModule, SplitButtonModule,CommonModule],
  templateUrl: './admi-dashboard.component.html',
  styleUrl: './admi-dashboard.component.css'
})
export class AdmiDashboardComponent {


  items: MenuItem[] = [];


  constructor() {

  }
  ngOnInit() {
    this.items = [
      { label: 'Ver perfil', command: () => this.save('Option 1') },
      { label: 'Configuración', command: () => this.save('Option 2') },
      { label: 'Ayuda y Soporte', command: () => this.save('Option 3') },
      { label: 'Cerrar Sesión', command: () => this.save('Option 3') }
    ];
}
 save(info: string) {
    console.log(`You clicked on ${info}`);
  }

/*----------------------*/
  date: Date = new Date();

/*----------------------*/
  activities = [
    {
      id: 1,
      name: 'Mes de la lectura',
      detail: 'Esta es una de las actividades escolares que tendremos en la semana de la amistad en donde los niños participaran.',
    },
    {
      id: 2,
      name: 'Biblioteca Digital',
      detail: 'Esta es una de las actividades escolares que tendremos en la semana de la amistad entre estudiantes y docente.',
    },
    {
      id: 3,
      name: 'Dia de la bandera',
      detail: 'En esta fecha se celebra el dia de la bandera en la unidad educativa por lo cual deben venir formalmente.',
    },
    {
      id: 4,
      name: 'Dia de la madre',
      detail: 'En esta fecha se celebra el dia de la madre en la unidad educativa todos deben traer un regalo y material.',
    },
  ];
/*----------------------*/
  teachers = [
    {
    id:1,
    name: 'Antony R.',
    parallel: '4 C',
    asignature: 'Matematicas'
  },
  {
    id:2,
    name: 'Mariana C.',
    parallel: '1 C',
    asignature: 'Economia'
  },
  {
    id:3,
    name: 'Juanito Z.',
    parallel: '4 C',
    asignature: 'Ciencias'
  },
  {
    id:4,
    name: 'Rosalia T.',
    parallel: '6 C',
    asignature: 'Ciencias'
  },
  {
    id:5,
    name: 'Medranda',
    parallel: '2 C',
    asignature: 'Ciencias'
  },
  {
    id:6,
    name: 'Bolivar F.',
    parallel: '4 C',
    asignature: 'Ingles'
  },
  {
    id:7,
    name: 'Edgar Vivar',
    parallel: '7 C',
    asignature: 'Computacion'
  },
  {
    id:8,
    name: 'Alejandro',
    parallel: '4 C',
    asignature: 'Fisica'
  },

  ]
}
