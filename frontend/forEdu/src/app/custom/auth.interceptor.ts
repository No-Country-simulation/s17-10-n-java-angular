import { HttpInterceptorFn } from '@angular/common/http';

export const authInterceptor: HttpInterceptorFn = (req, next) => {
   debugger;
   console.log("object");
   if (req.url.indexOf('login')!== -1) return next(req);

   const token = localStorage.getItem('token');

   const cloneRequest = req.clone({
      setHeaders: {
         Authorization: `Bearer ${token}`
      }
   });
   return next(cloneRequest)
};
