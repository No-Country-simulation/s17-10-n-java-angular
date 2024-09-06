import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {AdmiDashboardComponent} from './Admin/admin-layout/admi-dashboard/admi-dashboard.component'
import { ModalUserIntitutionalComponent } from './components/modal-user-institutional/modal-user-institutional.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, AdmiDashboardComponent, ModalUserIntitutionalComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'forEdu';
}
