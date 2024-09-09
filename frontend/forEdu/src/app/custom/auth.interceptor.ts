import { HttpInterceptorFn } from '@angular/common/http';

export const authInterceptor: HttpInterceptorFn = (req, next) => {

   console.log("object");
   if (req.url.includes('login') || req.url.includes('register')) return next(req);

   const token = localStorage.getItem('token');

   const cloneRequest = req.clone({
      setHeaders: {
         Authorization: `Bearer ${token}`
      }
   });
   return next(cloneRequest)
};
