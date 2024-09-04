import { Component } from '@angular/core';

@Component({
  selector: 'app-asistencia',
  standalone: true,
  imports: [],
  templateUrl: './asistencia.component.html',
  styleUrl: './asistencia.component.css'
})
export class AsistenciaComponent {

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
    }]
}
