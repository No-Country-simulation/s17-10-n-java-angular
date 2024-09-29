
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ButtonModule } from 'primeng/button';
import { CommonModule } from '@angular/common';
import { NavbarComponent } from "../../../components/navbar/navbar.component";
import { SidebarComponent } from "../../../components/sidebar/sidebar.component";
import { Router } from '@angular/router';
import { DecodeService } from '../../../service/decode/decode.service';




@Component({
  selector: 'app-admi-dashboard',
  standalone: true,
  imports: [ButtonModule, FormsModule, CommonModule, NavbarComponent, SidebarComponent],
  templateUrl: './admi-dashboard.component.html',
  styleUrl: './admi-dashboard.component.css'
})
export class AdmiDashboardComponent {

  username:string = "Invitado"

   constructor(private router : Router,usernameDecode: DecodeService){
    this.username = usernameDecode.getUsername
   }

   navigateGrade(){
      return this.router.navigate(['/dashboard/grade'])
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
      name: 'Celebracion de hallowen',
      detail: 'En esta fecha se celebra el dia de la madre en la unidad educativa todos deben traer un regalo y material.',
    },
    {
      id: 5,
      name: 'Dia de la madre',
      detail: 'En esta fecha se celebra el dia de la madre en la unidad educativa todos deben traer un regalo y material.',
    },
    {
      id: 6,
      name: 'Dia de la bandera',
      detail: 'En esta fecha se celebra el dia de la bandera en la unidad educativa por lo cual deben venir formalmente.',
    },
    {
      id: 7,
      name: 'Celebracion de hallowen',
      detail: 'En esta fecha se celebra el dia de la madre en la unidad educativa todos deben traer un regalo y material.',
    },
    {
      id: 8,
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
  {
    id:9,
    name: 'Medranda',
    parallel: '2 C',
    asignature: 'Ciencias'
  },
  {
    id:10,
    name: 'Bolivar F.',
    parallel: '4 C',
    asignature: 'Ingles'
  },
  {
    id:11,
    name: 'Edgar Vivar',
    parallel: '7 C',
    asignature: 'Computacion'
  },
  {
    id:12,
    name: 'Alejandro',
    parallel: '4 C',
    asignature: 'Fisica'
  },

  ]
}
