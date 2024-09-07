import { Component } from '@angular/core';
import { MenuItem } from 'primeng/api';
import { SplitButtonModule } from 'primeng/splitbutton';

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [SplitButtonModule],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})
export class NavbarComponent {

  
  items: MenuItem[] = [];


  constructor() {

  }
  ngOnInit() {
    this.items = [
      { label: 'Ver perfil', command: () => this.save('Option 1') },
      { label: 'Configuración', command: () => this.save('Option 2') },
      { label: 'Ayuda y Soporte', command: () => this.save('Option 3') },
      { label: 'Cerrar Sesión', command: () => this.save('Option 3') }
    ];
}
 save(info: string) {
    console.log(`You clicked on ${info}`);
  }
}
