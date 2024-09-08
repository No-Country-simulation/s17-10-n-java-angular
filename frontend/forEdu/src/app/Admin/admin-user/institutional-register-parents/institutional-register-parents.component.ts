import { Component } from '@angular/core';
import { SidebarComponent } from "../../../components/sidebar/sidebar.component";
import { NavbarComponent } from "../../../components/navbar/navbar.component";
import { Router } from '@angular/router';

@Component({
  selector: 'app-institutional-register-parents',
  standalone: true,
  imports: [SidebarComponent, NavbarComponent],
  templateUrl: './institutional-register-parents.component.html',
  styleUrl: './institutional-register-parents.component.css'
})
export class InstitutionalRegisterParentsComponent {
  
  constructor(private router: Router){}

  redirectRegisterStudent(){
    this.router.navigate(['/admin/registereStudents']);
  }
}
