import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {SidebarComponent} from "./components/sidebar/sidebar.component";
import {AdmiDashboardComponent} from "./Admin/admin-layout/admi-dashboard/admi-dashboard.component";
import {PanelMenuModule} from "primeng/panelmenu";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, SidebarComponent, AdmiDashboardComponent, PanelMenuModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'forEdu';
}
