import { Component } from '@angular/core';
import { CardEventComponent } from '../../../components/card-event/card-event.component';
import { CardEventBodyComponent } from '../../../components/card-event-body/card-event-body.component';

@Component({
  selector: 'app-detail',
  standalone: true,
  imports: [
    CardEventComponent,
    CardEventBodyComponent
  ],
  templateUrl: './detail.component.html',
  styleUrl: './detail.component.css'
})
export class DetailComponent {

}
