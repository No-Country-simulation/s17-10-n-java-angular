import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { apiSetting } from '../../settings/apisetting';
import { Profesor } from '../interfaces/profesor';
import { ProfesorSuccess } from '../interfaces/profesor-success';
import { Observable } from 'rxjs';
import { GetAll } from '../interfaces/profesor/get-all';

@Injectable({
  providedIn: 'root'
})
export class ProfesorService {

  constructor() { }


  private http = inject(HttpClient);
  private url :string = apiSetting.apiUrl;



 register (objeto:Profesor): Observable <ProfesorSuccess>{

  return  this.http.post<ProfesorSuccess>(`${this.url}/profesor/add`,objeto

   )

 }
 getAllProfesor(): Observable<GetAll>{

  return this.http.get<GetAll>(`${this.url}/profesor/getAll`)
  

 }

}
