import { Routes } from '@angular/router';
import { ADMIN_ROUTES } from './Admin/admin.routes';
import { InstitutionalUserComponent } from './Admin/admin-user/institutional-user/institutional-user.component';
import { InstitutionalUserTeacherComponent } from './Admin/admin-user/institutional-user-teacher/institutional-user-teacher.component';
import { InstitutionalUserStudentComponent } from './Admin/admin-user/institutional-user-student/institutional-user-student.component';
import { DegreeTeacherComponent } from './components/degree-teacher/degree-teacher.component';

import { GradeComponent } from './Admin/admin-grade/grade/grade.component';
import { AsistenciaComponent } from './Admin/admin-grade/asistencia/asistencia.component';
import { AdmiDashboardComponent } from './Admin/admin-layout/admi-dashboard/admi-dashboard.component';
import { InstitutionalRegisterParentsComponent } from './Admin/admin-user/institutional-register-parents/institutional-register-parents.component';
import { InstitutionalRegisterTeacherComponent } from './Admin/admin-user/institutional-register-teacher/institutional-register-teacher.component';
import { InstitutionalRegisterStudentsComponent } from './Admin/admin-user/institutional-register-students/institutional-register-students.component';
import { LayoutAdminComponent } from './layouts/layout-admin/layout-admin.component';

import { GradeRegisterComponent } from './Admin/admin-grade/register-grade/register.component';
import { authGuard } from './guard/auth.guard';
import { LoginComponent } from './components/login/login.component';
import { NewsGradeComponent } from './Admin/admin-grade/news-grade/news-grade.component';
import { DetailComponent } from './Admin/admin-grade/detail/detail.component';

export const routes: Routes = [
  {
    path: '',
    component: LayoutAdminComponent,

    children: [
      {
        path: '',
        component: AdmiDashboardComponent,
        canActivate: [authGuard],
        data: { title: 'Inicio' }
      },
      {
        path: 'asistencia',
        component: AsistenciaComponent,
        
        data: { title: '1-C' }
      },
      {
        path: 'grade',
        component: GradeComponent,
        data: { title: 'Grados' }
      },
      {
        path: 'grade-register',
        component: GradeRegisterComponent,
       
        data: { title: 'Crear Grados' },
      },
      {
        path: 'detailsgrade',
        component: DetailComponent,
        data: { title: 'Detalles' },
      },
      
      {
        path: 'news',
        component: NewsGradeComponent,
       
        data: { title: 'Comunicaciones' },
      },
      {
        path: 'users',
        component: InstitutionalUserComponent,
        canActivate: [authGuard],
        data: { title: 'Usuarios institucionales' },
      },
      {
        path: 'login',
        component: LoginComponent,
      },
      {path: 'registereParents',
         component: InstitutionalRegisterParentsComponent,
         canActivate: [authGuard],
         data: { title: 'Registar Tutor legal' },
       },
       {path: 'registereTeachers',
         component: InstitutionalRegisterTeacherComponent,
         canActivate: [authGuard],
         data: { title: 'Registar Profesor' },
       },
       {path: 'registereStudents',
         component: InstitutionalRegisterStudentsComponent
       }
    ]
  },
  {
    path: 'users',
    component: LayoutAdminComponent,
    children: [
      ...ADMIN_ROUTES,

      {path: 'users',
        component: InstitutionalUserComponent
      },

    ],
  },
  {
    path: 'newsletter',
    component: LayoutAdminComponent,
    children:[

    ]
  }
];
