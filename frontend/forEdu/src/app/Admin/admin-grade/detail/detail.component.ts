import { Component } from '@angular/core';
import { CardEventComponent } from '../../../components/card-event/card-event.component';
import { CardEventBodyComponent } from '../../../components/card-event-body/card-event-body.component';
import { NewsGradeComponent } from '../news-grade/news-grade.component';
import { AsistenciaComponent } from "../asistencia/asistencia.component";
import { CalendarComponent } from "../../admin-calendar/calendar/calendar.component";

@Component({
  selector: 'app-detail',
  standalone: true,
  imports: [
    CardEventComponent,
    CardEventBodyComponent,
    NewsGradeComponent,
    AsistenciaComponent,
    CalendarComponent
],
  templateUrl: './detail.component.html',
  styleUrl: './detail.component.css'
})
export class DetailComponent {
  tablaActual: string = "comunicaciones";

  mostrarTabla(tabla: string) {
    this.tablaActual = tabla;
  }

}
