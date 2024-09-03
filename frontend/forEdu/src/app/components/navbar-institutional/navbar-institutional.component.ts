import { Component } from '@angular/core';
import { InstitutionalUserTeacherComponent } from '../institutional-user-teacher/institutional-user-teacher.component';
import { InstitutionalUserStudentComponent } from "../institutional-user-student/institutional-user-student.component";
import { InstitutionalUserAdminComponent } from "../institutional-user-admin/institutional-user-admin.component";

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
  
  }
