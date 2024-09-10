import { Component } from '@angular/core';

@Component({
  selector: 'app-table-degree',
  standalone: true,
  imports: [],
  templateUrl: './table-degree.component.html',
  styleUrl: './table-degree.component.css'
})
export class TableDegreeComponent {
  degrees = [
    {
      id:1,
      nombre: "Carlos H.",
      fecha: "2012-04-2",
      cargado: "Vsito",
      promedio: "9.0"
    },
    {
      id:2,
      nombre: "Luis H.",
      fecha: "2012-04-2",
      cargado: "Vsito",
      promedio: "9.0"
    },
    {
      id:3,
      nombre: "Ruby H.",
      fecha: "2012-04-2",
      cargado: "Vsito",
      promedio: "9.0"
    },
    {
      id:4,
      nombre: "Merlin H.",
      fecha: "2012-04-2",
      cargado: "Vsito",
      promedio: "9.0"
    },
    {
      id:5,
      nombre: "Katty H.",
      fecha: "2012-04-2",
      cargado: "Vsito",
      promedio: "9.0"
    }
  ]
}
