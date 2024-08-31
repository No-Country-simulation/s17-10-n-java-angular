import { Component } from '@angular/core';
import { PanelMenuModule } from 'primeng/panelmenu';
import {MenuItem} from "primeng/api";

@Component({
  selector: 'app-sidebar',
  standalone: true,
  imports: [PanelMenuModule],
  templateUrl: './sidebar.component.html',
  styleUrl: './sidebar.component.css'
})


export class SidebarComponent {
  items: MenuItem[];

  constructor() {
    this.items = [
      {
        label: 'Inicio',
        icon: 'pi pi-fw pi-home',
      },
      {
        label: 'Grados',
        icon: 'pi pi-fw pi-book',
      },
      {
        label: 'Calendarios',
        icon: 'pi pi-fw pi-calendar',
      },
      {
        label: 'Mensajes',
        icon: 'pi pi-fw pi-inbox',
      }
      ,
      {
        label: 'Usuarios',
        icon: 'pi pi-fw pi-users',
      }
      ,
      {
        label: 'Boletines',
        icon: 'pi pi-fw pi-graduation-cap',
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
    ];
  }
}
