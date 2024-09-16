import { Component, Input } from '@angular/core';
import { GradeRegister } from '../../interfaces/grade-register';
import { Router } from '@angular/router';
import { DropdownModule } from 'primeng/dropdown';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ButtonModule } from 'primeng/button';
import { MenuModule } from 'primeng/menu';
import { GradeRegisterService } from '../../service/grade-register.service';
import { MenuItem, MessageService } from 'primeng/api';
import { ToastModule } from 'primeng/toast';
import { MenubarService } from 'primeng/menubar';
import { DividerModule } from 'primeng/divider';
import { CardModule } from 'primeng/card';

@Component({
  selector: 'app-card-grade',
  standalone: true,
  imports: [DropdownModule, FormsModule, CommonModule, ButtonModule, MenuModule,
            ToastModule,DividerModule,CardModule],
  templateUrl: './card-grade.component.html',
  styleUrls: ['./card-grade.component.css'],
  providers:[MessageService]
})
export class CardGradeComponent {

  @Input() grade!: GradeRegister;

  items: MenuItem[] = [
    { label: 'Editar', icon: 'pi pi-pencil', command: () => this.editGrade() },
    { label: 'Borrar', icon: 'pi pi-trash', command: () => this.deleteGrade() }
  ];

  constructor(
    private router: Router,
    private gradeService: GradeRegisterService,
    private messageService: MessageService
  ) {}

  navigateAsistencia() {
    return this.router.navigate(['/dashboard/detailsgrade']);
  }

  editGrade() {
    console.log('Editar', this.grade);
  }
  deleteGrade() {
   if (this.grade && this.grade.id) {
      if (confirm('¿Estás seguro de que deseas eliminar este registro?')) {

        this.gradeService.delete(this.grade.id).subscribe(
          response => {
            console.log('Registro eliminado con éxito', response);
            this.messageService.add({severity: 'success', summary: 'Éxito', detail: 'Registro eliminado con éxito'});
          },
          error => {
            console.error('Error al eliminar el registro', error);
            this.messageService.add({severity: 'error', summary: 'Error', detail: 'Error al eliminar el registro'});
          }
        );
      }
   } else {
     console.error('Registro no definido o sin identificador');
   }
 }

}
