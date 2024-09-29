import { HttpClient, HttpHeaders } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { apiSetting } from '../../settings/apisetting';
import { GradeRegister } from '../interfaces/grade-register';
import { Observable } from 'rxjs';
import { GradeSuccess } from '../interfaces/grade-success';
import { Getgrade } from '../interfaces/getgrade';
import { map } from 'rxjs/operators';

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

  getAllGrade (): Observable <GradeRegister[]>{
   return this.http.get<Getgrade>(`${this.url}/grado/getAll`).pipe(
      map(response => {
        return [response.dataIterable];
      })
    );

  }

  delete (id:number):Observable<any>{
   return this.http.delete(`${this.url}/grado/${id}`);
  }

  gradeByID(id:number):Observable<any>{
    return this.http.get(`${this.url}/grado/${id}`)
  }

}
