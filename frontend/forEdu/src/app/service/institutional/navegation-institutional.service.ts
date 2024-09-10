import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class NavegationInstitutionalService {

  private tablaActual: string = "alumnos";
  constructor(private router: Router) { }

  // Establecer la tabla actual
  setTablaActual(tabla: string) {
    this.tablaActual = tabla;
  }

  // Obtener la tabla actual
  getTablaActual(): string {
    return this.tablaActual;
  }


  irAlFormulario() {
    if (this.tablaActual === 'alumnos') {
      // Redirigir al formulario de estudiantes
      this.router.navigate(['/registereParents']);
    } else if(this.tablaActual === 'profesores'){
      this.router.navigate(['/registereTeachers']);
    } else if (this.tablaActual === 'administradores') {
      // Redirigir al formulario de administradores
      this.router.navigate(['/formulario-administradores']);
    }
  }

}
