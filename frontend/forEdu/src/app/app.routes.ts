import { Routes } from '@angular/router';
import { ADMIN_ROUTES } from './Admin/admin.routes';
import { InstitutionalUserComponent } from './components/institutional-user/institutional-user.component';
import { SidebarComponent } from './components/sidebar/sidebar.component';
import { GradeComponent } from './Admin/admin-grade/grade/grade.component';

export const routes: Routes = [
  {
    path: '',
    children: [
      ...ADMIN_ROUTES, // Aquí expandes las rutas que tienes en ADMIN_ROUTES
      {
        path: 'grade',
        component: GradeComponent,
      },
      {
        path: 'calendar',
        component: GradeComponent,
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
];
