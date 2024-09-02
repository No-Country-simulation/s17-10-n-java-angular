import { Routes } from '@angular/router';
import { ADMIN_ROUTES } from './Admin/admin.routes';
import { InstitutionalUserComponent } from './components/institutional-user/institutional-user.component';
import { InstitutionalUserTeacherComponent } from './components/institutional-user-teacher/institutional-user-teacher.component';
import { NavbarInstitutionalComponent } from './components/navbar-institutional/navbar-institutional.component';
import { InstitutionalUserStudentComponent } from './components/institutional-user-student/institutional-user-student.component';
import { DegreeTeacherComponent } from './components/degree-teacher/degree-teacher.component';
import { DegreeStudentComponent } from './components/degree-student/degree-student.component';
import { ModalUserInstitutionalService } from './service/modal/modal-user-institutional.service';
export const routes: Routes = [

    {
        path: '',
        children: ADMIN_ROUTES
      },
      {
        path: 'table', component: InstitutionalUserComponent
      },
      {
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
      }
      

];
