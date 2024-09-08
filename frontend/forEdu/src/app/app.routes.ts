import { Routes } from '@angular/router';
import { ADMIN_ROUTES } from './Admin/admin.routes';
import { InstitutionalUserComponent } from './Admin/admin-user/institutional-user/institutional-user.component';
import { InstitutionalUserTeacherComponent } from './Admin/admin-user/institutional-user-teacher/institutional-user-teacher.component';
import { InstitutionalUserStudentComponent } from './Admin/admin-user/institutional-user-student/institutional-user-student.component';
import { DegreeTeacherComponent } from './components/degree-teacher/degree-teacher.component';
import { DegreeStudentComponent } from './components/degree-student/degree-student.component';
import { SidebarComponent } from './components/sidebar/sidebar.component';
import { GradeComponent } from './Admin/admin-grade/grade/grade.component';
import { AsistenciaComponent } from './Admin/admin-grade/asistencia/asistencia.component';
import { AdmiDashboardComponent } from './Admin/admin-layout/admi-dashboard/admi-dashboard.component';
import { InstitutionalRegisterParentsComponent } from './Admin/admin-user/institutional-register-parents/institutional-register-parents.component';
import { InstitutionalRegisterTeacherComponent } from './Admin/admin-user/institutional-register-teacher/institutional-register-teacher.component';
import { InstitutionalRegisterStudentsComponent } from './Admin/admin-user/institutional-register-students/institutional-register-students.component';
import { LayoutAdminComponent } from './layouts/layout-admin/layout-admin.component';
import { InstitutionalUserAdminComponent } from './Admin/admin-user/institutional-user-admin/institutional-user-admin.component';
import { N } from '@angular/cdk/keycodes';
import { NewsletterComponent } from './Admin/admin-newsletters/newsletter/newsletter.component';

export const routes: Routes = [
  {
    path: '',
    component: LayoutAdminComponent,
    children: [
      {
        path: '',
        component: AdmiDashboardComponent,
      },
      {
        path: 'asistencia',
        component: AsistenciaComponent,
      },
      {
        path: 'grade',
        component: GradeComponent,
      },
      {path: 'users',
        component: InstitutionalUserComponent
      },
      {
        path: 'newsletter',
        component: NewsletterComponent
      }
      
    ]
  },
  {
    path: 'users',
    component: LayoutAdminComponent,
    children: [
      ...ADMIN_ROUTES,
      {path: 'registereParents',
        component: InstitutionalRegisterParentsComponent
      },
      {path: 'registereTeachers',
        component: InstitutionalRegisterTeacherComponent
      },
      {path: 'registereStudents',
        component: InstitutionalRegisterStudentsComponent
      }
    ],
  },
  {
    path: 'newsletter',
    component: LayoutAdminComponent,
    children:[
     
    ]
  }
];
