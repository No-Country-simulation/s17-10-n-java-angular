import { Component, inject } from '@angular/core';
import { AuthService } from '../../service/auth.service';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Login } from '../../interfaces/login';
import { ToastModule } from 'primeng/toast';
import { MessageService } from 'primeng/api';
import { MessageModule } from 'primeng/message';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [ToastModule,MessageModule,ReactiveFormsModule,HttpClientModule,CommonModule ],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css',
  providers: [MessageService]
})
export class LoginComponent {

   private user:string = "Zail Vegas"
   private loginService = inject(AuthService);
   private router = inject(Router);
   private formBuild = inject(FormBuilder)
   private messageService = inject(MessageService);

    formLogin:FormGroup = this.formBuild.group({
      email:["",Validators.required],
      contrasena: ["",Validators.required]
   });

   sesionStart () {
      if (this.formLogin.invalid)return;

         const objeto:Login = {
            email : this.formLogin.value.email,
            contrasena : this.formLogin.value.contrasena
         }
         this.loginService.login(objeto).subscribe({
            next:(data)=>{
               console.log(data);
               if (data.jwtToken) {
                  localStorage.setItem("token",data.jwtToken);
                  localStorage.setItem("user", this.user);

                  this.router.navigate([""])
               } else {
                  this.messageService.add({ severity: 'error', summary: 'Error', detail: 'Credenciales incorrectas' });
               }

            },
            error: (err) => {
               this.messageService.add({ severity: 'error', summary: 'Error', detail: 'Error en el servidor' });
             }
         })



   }



}
