import { Component, inject } from '@angular/core';
import { SidebarComponent } from "../../../components/sidebar/sidebar.component";
import { NavbarComponent } from "../../../components/navbar/navbar.component";
import { Router } from '@angular/router';
import { FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-institutional-register-parents',
  standalone: true,
  imports: [SidebarComponent, NavbarComponent],
  templateUrl: './institutional-register-parents.component.html',
  styleUrl: './institutional-register-parents.component.css'
})
export class InstitutionalRegisterParentsComponent {

   private formBuilder = inject(FormBuilder);


  constructor(private router: Router){}

  redirectRegisterStudent(){
    this.router.navigate(['/registereStudents']);
  }
}
