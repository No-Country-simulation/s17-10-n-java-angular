import { Component } from '@angular/core';
import { TableDegreeComponent } from '../table-degree/table-degree.component';
import { DetailsNewslettersComponent } from '../details-newsletters/details-newsletters.component';

@Component({
  selector: 'app-navbar-grade-newsletter',
  standalone: true,
  imports: [TableDegreeComponent, DetailsNewslettersComponent],
  templateUrl: './navbar-grade-newsletter.component.html',
  styleUrl: './navbar-grade-newsletter.component.css'
})
export class NavbarGradeNewsletterComponent {
  gradoActual: string = 'primero';

  irAgrado(grado: string){
    this.gradoActual = grado;
  }
}
