import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { Component, inject } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { MessageService } from 'primeng/api';
import { MessageModule } from 'primeng/message';
import { ToastModule } from 'primeng/toast';
import { GradeRegisterService } from '../../../service/grade-register.service';
import { GradeRegister } from '../../../interfaces/grade-register';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [ToastModule, MessageModule, ReactiveFormsModule, HttpClientModule, CommonModule],
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
  providers: [MessageService]
})
export class GradeRegisterComponent {

  private formBuild = inject(FormBuilder);
  private messageService = inject(MessageService);
  private gradeService = inject(GradeRegisterService);
  private router = inject(Router);  // Inyecta correctamente el Router

  formGrade: FormGroup = this.formBuild.group({
    curso: ["", Validators.required],
    aula: ["", Validators.required],
    turno: ["", Validators.required],
    materia: ["", Validators.required],
    profesor: ["", Validators.required]
  });

  gradeSubmit() {
    if (this.formGrade.valid) {
      const gradeData: GradeRegister = this.formGrade.value;

      console.log('Datos del formulario:', gradeData);

      this.gradeService.gradeRegister(gradeData).subscribe({
        next: (response) => {
          console.log('Respuesta del servidor:', response);
          this.messageService.add({ severity: 'success', summary: 'Éxito', detail: 'Grado registrado exitosamente' });

          // Aquí usamos el router después de 3 segundos
          setTimeout(() => {
            this.router.navigate(['/ruta-deseada']);  // Redirige a la ruta deseada
          }, 2000);
        },
        error: (err) => {
          console.error('Error al registrar el grado:', err);
          this.messageService.add({ severity: 'error', summary: 'Error', detail: 'Error al registrar el grado' });
        }
      });
    } else {
      this.messageService.add({ severity: 'error', summary: 'Error', detail: 'Por favor completa todos los campos' });
    }
  }
}
