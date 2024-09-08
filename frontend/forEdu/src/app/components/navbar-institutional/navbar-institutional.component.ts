import { Component } from '@angular/core';
import { InstitutionalUserTeacherComponent } from '../institutional-user-teacher/institutional-user-teacher.component';
import { InstitutionalUserStudentComponent } from "../institutional-user-student/institutional-user-student.component";
import { InstitutionalUserAdminComponent } from "../institutional-user-admin/institutional-user-admin.component";
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar-institutional',
  standalone: true,
  imports: [InstitutionalUserTeacherComponent, InstitutionalUserStudentComponent, InstitutionalUserAdminComponent],
  templateUrl: './navbar-institutional.component.html',
  styleUrl: './navbar-institutional.component.css'
})
export class NavbarInstitutionalComponent {

  tablaActual: string = "alumnos";

  mostrarTabla(tabla: string) {
    this.tablaActual = tabla;
  }


  constructor(private router: Router) {}

  irAlFormulario() {
    if (this.tablaActual === 'alumnos') {
      // Redirigir al formulario de estudiantes
      this.router.navigate(['/admin/registereParents']);
    } else if(this.tablaActual === 'profesores'){
      this.router.navigate(['/admin/registereTeachers']);
    } else if (this.tablaActual === 'administradores') {
      // Redirigir al formulario de administradores
      this.router.navigate(['/formulario-administradores']);
    }
  }
  
 
  }
