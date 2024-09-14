import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { apiSetting } from '../../settings/apisetting';
import { map, Observable } from 'rxjs';
import { Tutor } from '../interfaces/tutor';
import { TutorSuccess } from '../interfaces/tutor-success';

@Injectable({
  providedIn: 'root'
})
export class ParentRegisterService {

  constructor() { }

  private http = inject(HttpClient);
  private url = apiSetting.apiUrl;



   register ( data:Tutor ):Observable<TutorSuccess>{

      return this.http.post<TutorSuccess>(`${this.url}/tutorlegal/add`,data)

   }

   getAll ( ):Observable<TutorSuccess[]>{
      return this.http.get<TutorSuccess>(`${this.url}/tutor/getAll`).pipe(
         map(response =>{
            return [response] })
      )
   }

}
