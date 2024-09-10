import { Component } from '@angular/core';
import { NavbarComponent } from '../../../components/navbar/navbar.component';
import { SidebarComponent } from '../../../components/sidebar/sidebar.component';

@Component({
  selector: 'app-institutional-register-students',
  standalone: true,
  imports: [SidebarComponent, NavbarComponent],
  templateUrl: './institutional-register-students.component.html',
  styleUrl: './institutional-register-students.component.css'
})
export class InstitutionalRegisterStudentsComponent {

}
