import { Routes } from '@angular/router';
import { ADMIN_ROUTES } from './Admin/admin.routes';
import { InstitutionalUserComponent } from './components/institutional-user/institutional-user.component';
import { InstitutionalUserTeacherComponent } from './components/institutional-user-teacher/institutional-user-teacher.component';
import { NavbarInstitutionalComponent } from './components/navbar-institutional/navbar-institutional.component';
import { InstitutionalUserStudentComponent } from './components/institutional-user-student/institutional-user-student.component';
import { DegreeTeacherComponent } from './components/degree-teacher/degree-teacher.component';
import { DegreeStudentComponent } from './components/degree-student/degree-student.component';
import { SidebarComponent } from './components/sidebar/sidebar.component';
import { GradeComponent } from './Admin/admin-grade/grade/grade.component';
import { AsistenciaComponent } from './Admin/admin-grade/asistencia/asistencia.component';
import { AdmiDashboardComponent } from './Admin/admin-layout/admi-dashboard/admi-dashboard.component';

export const routes: Routes = [
  {
    path: '',
    component: AdmiDashboardComponent,
  },
  {
    path: 'admin',
    children: [
      ...ADMIN_ROUTES,
      {
        path: 'grade',
        component: GradeComponent,
      },
      {
        path: 'table',
        component: InstitutionalUserComponent,
      },
      {
        path: 'tablestudent',
        component: InstitutionalUserStudentComponent,
      },
      {
        path: 'tableteacher',
        component: InstitutionalUserTeacherComponent,
      },
      {
        path: 'navbarinsti',
        component: NavbarInstitutionalComponent,
      },
      {
        path: 'degreeteacher',
        component: DegreeTeacherComponent,
      },
      {
        path: 'degreestudent',
        component: DegreeStudentComponent,
      },
      {
        path: 'asistencia',
        component: AsistenciaComponent,
      },
      {
        path: 'sidebar',
        component: SidebarComponent,
      },

      /*RUTAS DE USUARIO*/
      {path: 'users',
        component: InstitutionalUserComponent
      }
    ],
  },
];
