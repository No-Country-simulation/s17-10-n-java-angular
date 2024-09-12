import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { apiSetting } from '../../settings/apisetting';
import { GradeRegister } from '../interfaces/grade-register';
import { Observable } from 'rxjs';
import { GradeSuccess } from '../interfaces/grade-success';

@Injectable({
  providedIn: 'root'
})
export class GradeRegisterService {

  constructor() { }
  private http = inject(HttpClient);
 private url :string = apiSetting.apiUrl;


 gradeRegister (objeto:GradeRegister): Observable <GradeSuccess>{

   return this.http.post<GradeSuccess>(`${this.url}/grado/register`, objeto);


  }


}
