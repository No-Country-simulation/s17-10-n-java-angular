import { Component } from '@angular/core';
import { SidebarComponent } from '../sidebar/sidebar.component';
import { NavbarComponent } from '../navbar/navbar.component';

@Component({
  selector: 'app-institutional-register-teacher',
  standalone: true,
  imports: [SidebarComponent, NavbarComponent],
  templateUrl: './institutional-register-teacher.component.html',
  styleUrl: './institutional-register-teacher.component.css'
})
export class InstitutionalRegisterTeacherComponent {

}
