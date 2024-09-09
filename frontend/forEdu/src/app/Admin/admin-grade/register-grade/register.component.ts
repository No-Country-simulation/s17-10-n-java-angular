import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [],
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class GradeRegisterComponent {
  gradeForm: FormGroup;

  grados = [1, 2, 3, 4, 5, 6, 7];
  secciones = ['A', 'B', 'C', 'D', 'E', 'F'];
  turnos = ['Mañana', 'Tarde', 'Noche'];
  asignaturas = ['Matemáticas', 'Español', 'Ciencias', 'Historia', 'Arte'];
  profesores = ['Juan Pérez', 'María García', 'Luis Hernández', 'Ana López', 'Carlos Rodríguez'];

  constructor(private fb: FormBuilder) {
    // Inicialización del formulario con formBuilder
    this.gradeForm = this.fb.group({
      grado: [null, Validators.required],
      seccion: [null, Validators.required],
      turno: [null, Validators.required],
      asignatura: [null, Validators.required],
      profesor: [null, Validators.required]
    });
  }

  onSubmit() {
    // Verifica si el formulario es válido
    if (this.gradeForm.valid) {
      // Obtiene los valores del formulario
      const grado = this.gradeForm.get('grado')?.value;
      const seccion = this.gradeForm.get('seccion')?.value;
      const turno = this.gradeForm.get('turno')?.value;
      const asignatura = this.gradeForm.get('asignatura')?.value;
      const profesor = this.gradeForm.get('profesor')?.value;

      // Muestra los valores en la consola
      console.log('Grado:', grado);
      console.log('Sección:', seccion);
      console.log('Turno:', turno);
      console.log('Asignatura:', asignatura);
      console.log('Profesor:', profesor);

      // Muestra un mensaje de éxito
      alert(`Grado ${grado} - Sección ${seccion} creado con éxito para el turno ${turno} en la asignatura ${asignatura} con el profesor ${profesor}.`);
    } else {
      // Si el formulario no es válido, muestra un mensaje de error
      alert('Por favor, complete todos los campos del formulario.');
    }
  }
}
