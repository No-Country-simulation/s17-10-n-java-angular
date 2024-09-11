import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { Component, inject } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { MessageService } from 'primeng/api';
import { MessageModule } from 'primeng/message';
import { ToastModule } from 'primeng/toast';


@Component({
  selector: 'app-institutional-register-teacher',
  standalone: true,
  imports: [ToastModule,MessageModule,ReactiveFormsModule,HttpClientModule,CommonModule ],
  templateUrl: './institutional-register-teacher.component.html',
  styleUrl: './institutional-register-teacher.component.css',
  providers: [MessageService]
})
export class InstitutionalRegisterTeacherComponent {



   private formBuild = inject(FormBuilder);
   private messageService = inject(MessageService)

   formTeacher:FormGroup = this.formBuild.group({
      nombre: ["", Validators.required],
      apellido: ["", Validators.required],
      tipoDocumento: ["", Validators.required],
      dni: ["", Validators.required],
      email: ["", Validators.required],
      telefono: ["", Validators.required],
      contrasena: ["", Validators.required],
      institucion: ["", Validators.required],
      materia: ["", Validators.required]
   });

   teacherSubmit() {
      if (this.formTeacher.valid) {

        console.log('Datos del formulario:', this.formTeacher.value);

        this.messageService.add({ severity: 'success', summary: 'Éxito', detail: 'Profesor registrado exitosamente' });
      } else {

        this.messageService.add({ severity: 'error', summary: 'Error', detail: 'Por favor completa todos los campos' });
      }
    }
}
