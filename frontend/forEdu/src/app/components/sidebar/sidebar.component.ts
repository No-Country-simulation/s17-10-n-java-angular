import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MenuItem } from 'primeng/api';
import { PanelMenuModule } from 'primeng/panelmenu';
import { StyleClassModule } from 'primeng/styleclass';

@Component({
  selector: 'app-sidebar',
  standalone: true,
  imports: [PanelMenuModule],
  templateUrl: './sidebar.component.html',
  styleUrl: './sidebar.component.css'
})


export class SidebarComponent implements OnInit {
  items: MenuItem[] = [];
  constructor(private router: Router) {}

  ngOnInit() {
    this.items = [
      {
        label: 'Inicio',
        icon: 'pi pi-fw pi-home',
        command: () => this.router.navigate(['/dashboard/']) // Navega al componente DASHBOARD
      },
      {
        label: 'Grados',
        icon: 'pi pi-fw pi-book',
        command: () => this.router.navigate(['/dashboard/grade']) // Navega al componente GRADO
      },
      {
        label: 'Calendarios',
        icon: 'pi pi-fw pi-calendar',
        command: () => this.router.navigate(['/dashboard/calendar']) // Navega al componente GRADO
      },
      {
        label: 'Mensajes',
        icon: 'pi pi-fw pi-inbox',
      }
      ,
      {
        label: 'Usuarios',
        icon: 'pi pi-fw pi-users',
        command: () => this.router.navigate(['/dashboard/users']) // Navega al componente USUARIOS
      }
      ,
      {
        label: 'Boletines',
        icon: 'pi pi-fw pi-graduation-cap',
        command: () => this.router.navigate(['/dashboard/newsletter']) // Navega al componente BOLETINES
      },
      {
        label: 'Herramientas',
        icon: 'pi pi-fw pi-cog',
        items: [
          {
            label: 'Setting',
            icon: 'pi pi-fw pi-cog',
          },
          {
            label: 'Soporte',
            icon: 'pi pi-fw pi-info-circle',
          }
        ]
      }
    ]
  }
}
