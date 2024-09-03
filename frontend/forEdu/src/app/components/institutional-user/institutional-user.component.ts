import { Component } from '@angular/core';
import { NavbarInstitutionalComponent } from "../navbar-institutional/navbar-institutional.component";
import { UserQuantityComponent } from '../user-quantity/user-quantity.component';

@Component({
  selector: 'app-institutional-user',
  standalone: true,
  imports: [NavbarInstitutionalComponent, UserQuantityComponent],
  templateUrl: './institutional-user.component.html',
  styleUrl: './institutional-user.component.css'
})
export class InstitutionalUserComponent {
}