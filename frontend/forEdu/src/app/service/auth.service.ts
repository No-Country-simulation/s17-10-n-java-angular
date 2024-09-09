import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { apiSetting } from '../../settings/apisetting';
import { Register } from '../interfaces/register';
import { Observable } from 'rxjs';
import { RegisterSuccess } from '../interfaces/register-success';
import { Login } from '../interfaces/login';
import { LoginSuccess } from '../interfaces/login-success';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
   private http = inject(HttpClient);
   private url :string = apiSetting.apiUrl;
  constructor() { }

   register (objeto:Register): Observable <RegisterSuccess>{

    return  this.http.post<RegisterSuccess>(`${this.url}/user/add`,objeto
     )

   }
   login (objeto:Login): Observable <LoginSuccess>{

      return this.http.post<LoginSuccess>(`${this.url}/login`, objeto);


     }
}
