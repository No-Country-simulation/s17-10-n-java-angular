import { Component } from '@angular/core';

@Component({
  selector: 'app-degree-teacher',
  standalone: true,
  imports: [],
  templateUrl: './degree-teacher.component.html',
  styleUrl: './degree-teacher.component.css'
})
export class DegreeTeacherComponent {
  
  persons = [
    {
      id: 1,
      nombre: "Juan Pérez",
      deparatamento: "Esmeraldas",
      contacto: "+5930982626445",
    },
    {
      id: 2,
      nombre: "Juan Pérez",
      deparatamento: "Guayaquil",
      contacto: "5930982626445",
    },
    {
      id: 3,
      nombre: "Juan Pérez",
      deparatamento: "Quito",
      contacto: "5930982626445",
    },
    {
      id: 4,
      nombre: "Juan Pérez",
      deparatamento: "Esmeraldas",
      contacto: "+5930982626445",
    },
    {
      id: 5,
      nombre: "Juan Pérez",
      deparatamento: "Guayaquil",
      contacto: "5930982626445",
    },
    {
      id: 6,
      nombre: "Juan Pérez",
      deparatamento: "Quito",
      contacto: "5930982626445",
    },
  ];
}
