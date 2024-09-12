import { HttpInterceptorFn } from '@angular/common/http';
import { inject } from '@angular/core';

import { AuthService } from '../service/auth.service';

export const authInterceptor: HttpInterceptorFn = (req, next) => {
   debugger
  const authService = inject(AuthService);
  const token = authService.getToken();

  if (req.url.includes('login')) {
   console.log('Solicitud de login, excluida del interceptor');
   return next(req);
 }
 if (req.url.includes('/user/add')  ) {
   console.log('Solicitud de register, excluida del interceptor');
   return next(req);
 }

  if (token) {
    const clonedRequest = req.clone({
      setHeaders: {
        Authorization: `Bearer ${token}`
      }
    });

    console.log('Cloned Request:', clonedRequest);
    return next(clonedRequest);
  } else {
    console.error('Token no encontrado en localStorage');
    return next(req);
  }
};
