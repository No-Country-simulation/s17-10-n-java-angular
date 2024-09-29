import { Injectable } from '@angular/core';
import { JwtPayload } from '../../interfaces/jwt-payload';
import { jwtDecode } from 'jwt-decode';

@Injectable({
  providedIn: 'root'
})
export class DecodeService {

 private token: string = localStorage.getItem('token') || "";
  decoded: JwtPayload | null = null;
 private username: string = "Invitado";

  constructor() { 
    if (this.token && this.token.split('.').length === 3) {
      try {
        this.decoded = jwtDecode(this.token);
        this.username = this.decoded?.nombre || "Invitado";
      } catch (error) {
        console.error("Error decoding token:", error);
      }
    } else {
      console.warn("Invalid or missing token");
    }
  }

  get getUsername(){
    return this.username;
  }
}
