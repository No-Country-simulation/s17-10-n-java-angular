import { Routes } from '@angular/router';
import { AdmiDashboardComponent } from './admin-layout/admi-dashboard/admi-dashboard.component';
import { CalendarComponent } from './admin-calendar/calendar/calendar.component';
import { GradeComponent } from './admin-grade/grade/grade.component';

export const ADMIN_ROUTES: Routes = [
    {
        path: 'admin',
        component: AdmiDashboardComponent,
        children: [
            { path: 'calendar', component: CalendarComponent },
            { path: 'grade', component: GradeComponent },
        ]
    }
];
