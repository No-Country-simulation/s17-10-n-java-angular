import { Component, OnInit } from '@angular/core';
import { FullCalendarModule } from '@fullcalendar/angular';
import { CalendarOptions } from '@fullcalendar/core/index.js';
import dayGridPlugin from '@fullcalendar/daygrid';
import esLocale from '@fullcalendar/core/locales/es';


@Component({
  selector: 'app-calendar',
  standalone: true,
  imports: [FullCalendarModule,CalendarComponent ],
  templateUrl: './calendar.component.html',
  styleUrl: './calendar.component.css'
})
export class CalendarComponent implements OnInit{

   calendarOptions: CalendarOptions = {
   plugins: [dayGridPlugin],
   initialView: 'dayGridMonth',
   locale: "es",
   locales: [esLocale],
   headerToolbar: {
     left: 'prev,next',
     center: 'title',
     right: 'dayGridMonth,dayGridWeek,dayGridDay'
   },
   events: [
     { title: 'Viaje Escolar', date: '2024-09-16' },
     { title: 'Festival Danza', date: '2024-09-17' }
   ]
 };

 constructor() { }

 ngOnInit(): void {
 }

}
