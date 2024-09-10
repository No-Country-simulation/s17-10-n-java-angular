import { Component } from '@angular/core';
import { CardModule } from 'primeng/card';
import { ButtonModule } from 'primeng/button';
import { CardGradeComponent } from '../../../components/card-grade/card-grade.component';
import { CardAddComponent } from '../../../components/card-add/card-add.component';
import { NavbarComponent } from "../../../components/navbar/navbar.component";
import { SidebarComponent } from "../../../components/sidebar/sidebar.component";
import { Router } from '@angular/router';

@Component({
  selector: 'app-grade',
  standalone: true,
  imports: [
    CardModule,
    ButtonModule,
    CardGradeComponent,
    CardAddComponent,
    NavbarComponent,
    SidebarComponent
],
  templateUrl: './grade.component.html',
  styleUrl: './grade.component.css'
})
export class GradeComponent {
constructor(private router: Router){}

  irAdetail(){
    this.router.navigate(['/detailsgrade']);
  }
}
