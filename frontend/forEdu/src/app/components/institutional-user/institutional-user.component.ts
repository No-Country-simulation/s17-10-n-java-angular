import { Component } from '@angular/core';
import { NavbarInstitutionalComponent } from "../navbar-institutional/navbar-institutional.component";
import { UserQuantityComponent } from '../user-quantity/user-quantity.component';
import { NavbarComponent } from "../navbar/navbar.component";
import { SidebarComponent } from '../sidebar/sidebar.component';

@Component({
  selector: 'app-institutional-user',
  standalone: true,
  imports: [NavbarInstitutionalComponent, UserQuantityComponent, NavbarComponent, SidebarComponent],
  templateUrl: './institutional-user.component.html',
  styleUrl: './institutional-user.component.css'
})
export class InstitutionalUserComponent {
}