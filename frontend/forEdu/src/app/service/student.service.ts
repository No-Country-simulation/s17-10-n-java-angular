import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { apiSetting } from '../../settings/apisetting';
import { map, Observable } from 'rxjs';
import { StudentRegister } from '../interfaces/student-register';
import { StudentSuccess } from '../interfaces/student-success';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

   private http = inject(HttpClient);
   private url = apiSetting.apiUrl;


  constructor() { }


  getAll ():Observable <StudentSuccess[]>{
      return this.http.get<StudentSuccess>(`${this.url}/estudiante/getAll`)
      .pipe(
         map(response=>{
            return [response];
         })
      )
  }

  register (data:StudentRegister): Observable<StudentSuccess>{
   return this.http.post<StudentSuccess>(`${this.url}/estudiante/add`,data)
  }


}

