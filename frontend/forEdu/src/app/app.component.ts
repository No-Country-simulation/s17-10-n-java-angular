import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {AdmiDashboardComponent} from './Admin/admin-layout/admi-dashboard/admi-dashboard.component'

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet,AdmiDashboardComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'forEdu';
}
