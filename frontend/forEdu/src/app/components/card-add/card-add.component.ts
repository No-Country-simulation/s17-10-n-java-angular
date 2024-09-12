import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-card-add',
  standalone: true,
  imports: [],
  templateUrl: './card-add.component.html',
  styleUrl: './card-add.component.css'
})
export class CardAddComponent {

   constructor(private router: Router){}

   navigateToCourse() {
      this.router.navigate(['/grade-add']);
    }

}
