import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { Component, inject } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { MessageService } from 'primeng/api';
import { MessageModule } from 'primeng/message';
import { ToastModule } from 'primeng/toast';
import { ProfesorService } from '../../../service/profesor.service';
import { Profesor } from '../../../interfaces/profesor';



@Component({
  selector: 'app-institutional-register-teacher',
  standalone: true,
  imports: [ToastModule, MessageModule, ReactiveFormsModule, HttpClientModule, CommonModule],
  templateUrl: './institutional-register-teacher.component.html',
  styleUrls: ['./institutional-register-teacher.component.css'],
  providers: [MessageService]
})
export class InstitutionalRegisterTeacherComponent {
  private formBuild = inject(FormBuilder);
  private messageService = inject(MessageService);
  private profesorService = inject(ProfesorService);

  formTeacher: FormGroup = this.formBuild.group({
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
      const profesorData: Profesor = this.formTeacher.value;


      this.profesorService.register(profesorData).subscribe({
        next: (response) => {
          console.log('Respuesta del servidor:', response);
          this.messageService.add({ severity: 'success', summary: 'Éxito', detail: 'Profesor registrado exitosamente' });
        },
        error: (err) => {
          console.error('Error al registrar el profesor:', err);
          this.messageService.add({ severity: 'error', summary: 'Error', detail: 'Error al registrar el profesor' });
        }
      });
    } else {
      this.messageService.add({ severity: 'error', summary: 'Error', detail: 'Por favor completa todos los campos' });
    }
  }
}
