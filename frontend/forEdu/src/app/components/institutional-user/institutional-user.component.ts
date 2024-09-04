import { Component } from '@angular/core';
import { NavbarInstitutionalComponent } from "../navbar-institutional/navbar-institutional.component";

@Component({
  selector: 'app-institutional-user',
  standalone: true,
  imports: [NavbarInstitutionalComponent],
  templateUrl: './institutional-user.component.html',
  styleUrl: './institutional-user.component.css'
})
export class InstitutionalUserComponent {
}