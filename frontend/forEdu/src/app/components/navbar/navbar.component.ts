import { Component, ViewChild } from '@angular/core';
import { MenuItem } from 'primeng/api';
import { SplitButtonModule } from 'primeng/splitbutton';
import { OverlayPanel, OverlayPanelModule } from 'primeng/overlaypanel'; // Importa OverlayPanel
import { jwtDecode } from "jwt-decode";
import { JwtPayload } from '../../interfaces/jwt-payload';
import { ActivatedRoute, NavigationEnd, Router } from '@angular/router';
import { filter } from 'rxjs/operators';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [SplitButtonModule,OverlayPanelModule,CommonModule],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})

export class NavbarComponent {

  token: string = localStorage.getItem('token') || "";
  decoded: JwtPayload | null = null;
  username: string = "Invitado";
  items: MenuItem[] = [];
  title: string = "";
  notificationCount: number = 3;  // Número de notificaciones
  notifications: string[] = [" Nuevo Ingreso", "Evento Danza Mañana", "ENtrega de boletines"]; // Lista de notificaciones

  @ViewChild('op') overlayPanel: OverlayPanel | undefined; // Referencia al OverlayPanel

  constructor(
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit() {

    if (this.token && this.token.split('.').length === 3) {
      try {
        this.decoded = jwtDecode(this.token);
        this.username = this.decoded?.nombre || "Invitado";
      } catch (error) {
        console.error("Error decoding token:", error);
      }
    } else {
      console.warn("Invalid or missing token");
    }

    this.items = [
      { label: 'Ver perfil', command: () => this.save('Option 1') },
      { label: 'Configuración', command: () => this.save('Option 2') },
      { label: 'Ayuda y Soporte', command: () => this.save('Option 3') },
      { label: 'Cerrar Sesión', command: () => this.save('Option 4') }
    ];

    this.router.events.pipe(
      filter(event => event instanceof NavigationEnd)
    ).subscribe(() => {
      this.updateTitle();
    });

    this.updateTitle();
  }

  showNotifications(event: Event) {
    this.overlayPanel?.toggle(event); // Muestra/oculta el OverlayPanel
  }

  save(info: string) {
    console.log(`You clicked on ${info}`);
  }

  private updateTitle() {
    let routeSnapshot = this.activatedRoute.snapshot;
    let routeTitle = '';

    while (routeSnapshot.firstChild) {
      routeSnapshot = routeSnapshot.firstChild;
    }

    if (routeSnapshot.data && routeSnapshot.data['title']) {
      routeTitle = routeSnapshot.data['title'];
    }

    this.title = routeTitle || 'Título predeterminado';
  }
}
