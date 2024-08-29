import { Routes } from '@angular/router';
import { ADMIN_ROUTES } from './Admin/admin.routes';

export const routes: Routes = [

    {
        path: '',
        children: ADMIN_ROUTES
      } 

];
