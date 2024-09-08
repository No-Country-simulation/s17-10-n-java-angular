import { Component } from '@angular/core';
import { NavbarComponent } from '../../../components/navbar/navbar.component';
import { NavbarGradeNewsletterComponent } from '../navbar-grade-newsletter/navbar-grade-newsletter.component';

@Component({
  selector: 'app-newsletter',
  standalone: true,
  imports: [NavbarGradeNewsletterComponent, NavbarComponent],
  templateUrl: './newsletter.component.html',
  styleUrl: './newsletter.component.css'
})
export class NewsletterComponent {

}
