import { Component } from '@angular/core';

@Component({
  selector: 'app-degree-student',
  standalone: true,
  imports: [],
  templateUrl: './degree-student.component.html',
  styleUrl: './degree-student.component.css'
})
export class DegreeStudentComponent {

  persons = [
    {
      id: 1,
      nombre: "Juan Manuel",
      legajo: "71548",
      fecha: "08- 10-2006",
      promedio: "10",
      tutores: "Miguel Bosee",
    },
    {
      id: 2,
      nombre: "Juan Manuel",
      legajo: "71548",
      fecha: "08- 10-2006",
      promedio: "10",
      tutores: "Miguel Bosee"
    },
    {
      id: 3,
      nombre: "Juan Manuel",
      legajo: "71548",
      fecha: "08- 10-2006",
      promedio: "10",
      tutores: "Miguel Bosee"
    },
    {
      id: 4,
      nombre: "Juan Manuel",
      legajo: "71548",
      fecha: "08- 10-2006",
      promedio: "10",
      tutores: "Miguel Bosee"
    },
    {
      id: 5,
      nombre: "Juan Manuel",
      legajo: "71548",
      fecha: "08- 10-2006",
      promedio: "10",
      tutores: "Miguel Bosee"
    },
    {
      id: 6,
      nombre: "Juan Manuel",
      legajo: "71548",
      fecha: "08- 10-2006",
      promedio: "10",
      tutores: "Miguel Bosee"
    },
  ];
}
