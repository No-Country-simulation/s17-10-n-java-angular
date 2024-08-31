import { Routes } from '@angular/router';
import { ADMIN_ROUTES } from './Admin/admin.routes';
import { InstitutionalUserComponent } from './components/institutional-user/institutional-user.component';

export const routes: Routes = [

    {
        path: '',
        children: ADMIN_ROUTES
      },
      {path: 'table', component: InstitutionalUserComponent}

];
