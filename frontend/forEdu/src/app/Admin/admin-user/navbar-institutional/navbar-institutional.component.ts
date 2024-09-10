import { Component } from '@angular/core';
import { Router, RouterModule } from '@angular/router';
import { InstitutionalUserStudentComponent } from '../institutional-user-student/institutional-user-student.component';
import { InstitutionalUserAdminComponent } from '../institutional-user-admin/institutional-user-admin.component';
import { NavegationInstitutionalService } from '../../../service/institutional/navegation-institutional.service';
import { InstitutionalUserTeacherComponent } from '../institutional-user-teacher/institutional-user-teacher.component';
import { AppComponent } from "../../../app.component";

@Component({
  selector: 'app-navbar-institutional',
  standalone: true,
  imports: [InstitutionalUserTeacherComponent, InstitutionalUserStudentComponent, InstitutionalUserAdminComponent, RouterModule],
  templateUrl: './navbar-institutional.component.html',
  styleUrl: './navbar-institutional.component.css'
})
export class NavbarInstitutionalComponent {

  tablaActual: string = '';
  constructor(
    private navegationInstitutionalService : NavegationInstitutionalService,
    private router: Router
  ) {}
  
  ngOnInit() {
    this.tablaActual = this.navegationInstitutionalService.getTablaActual();
  }

  mostrarTabla(tabla: string) {
    this.navegationInstitutionalService.setTablaActual(tabla);
    this.tablaActual = tabla;
  }

  reDirigir() {
    this.navegationInstitutionalService.irAlFormulario();
  }
  
    
  }
