import { Component } from '@angular/core';
import { SidebarComponent } from "../../components/sidebar/sidebar.component";
import { RouterModule } from '@angular/router';
import { DividerModule } from 'primeng/divider';
import { NavbarComponent } from "../../components/navbar/navbar.component";

@Component({
  selector: 'app-layout-admin',
  standalone: true,
  imports: [SidebarComponent, RouterModule, DividerModule, NavbarComponent],
  templateUrl: './layout-admin.component.html',
  styleUrl: './layout-admin.component.css'
})
export class LayoutAdminComponent {

}
