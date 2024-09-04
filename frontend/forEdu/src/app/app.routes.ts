import { Routes } from '@angular/router';
import { ADMIN_ROUTES } from './Admin/admin.routes';
import { InstitutionalUserComponent } from './components/institutional-user/institutional-user.component';
import { SidebarComponent } from './components/sidebar/sidebar.component';
import { GradeComponent } from './Admin/admin-grade/grade/grade.component';
import { AsistenciaComponent } from './Admin/admin-grade/asistencia/asistencia.component';
import { AdmiDashboardComponent } from './Admin/admin-layout/admi-dashboard/admi-dashboard.component';

export const routes: Routes = [

  {
    path: '',
    component:AdmiDashboardComponent

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
        path: 'calendar',
        component: GradeComponent,
      },
      {
        path: 'asistencia',
        component: AsistenciaComponent,
      },
    ],
  },
  {
    path: 'table',
    component: InstitutionalUserComponent,
  },
  {
    path: 'sidemenu',
    component: SidebarComponent,
  },
 /*  {
    path: 'tablestudent', component: InstitutionalUserStudentComponent
  },

  {
    path: 'tableteacher', component: InstitutionalUserTeacherComponent
  },
  {
    path: 'navbarinsti', component: NavbarInstitutionalComponent
  },
  {
    path: 'degreeteacher', component: DegreeStudentComponent
  } */
];
