import { Component } from '@angular/core';
import { UserQuantityComponent } from '../user-quantity/user-quantity.component';
import { NavbarComponent } from "../../../components/navbar/navbar.component";
import { SidebarComponent } from '../../../components/sidebar/sidebar.component';
import { NavegationInstitutionalService } from '../../../service/institutional/navegation-institutional.service';
import { NavbarInstitutionalComponent } from '../navbar-institutional/navbar-institutional.component';

@Component({
  selector: 'app-institutional-user',
  standalone: true,
  imports: [UserQuantityComponent, NavbarComponent, SidebarComponent, NavbarInstitutionalComponent ],
  templateUrl: './institutional-user.component.html',
  styleUrl: './institutional-user.component.css'
})
export class InstitutionalUserComponent {

  constructor(private navegationInstitutionalService : NavegationInstitutionalService) {}
  
  reDirigir(){
    this.navegationInstitutionalService.irAlFormulario();
  }
}