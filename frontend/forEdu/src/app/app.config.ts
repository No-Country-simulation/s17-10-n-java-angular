import { ApplicationConfig, importProvidersFrom, provideZoneChangeDetection } from '@angular/core';
import { provideRouter, RouterModule } from '@angular/router';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { routes } from './app.routes';
import { ButtonModule } from 'primeng/button';
import { ReactiveFormsModule } from '@angular/forms';

import { MenuModule } from 'primeng/menu';
import { MenubarModule } from 'primeng/menubar';
import { provideHttpClient, withInterceptors } from '@angular/common/http';
import { authInterceptor } from './custom/auth.interceptor';

export const appConfig: ApplicationConfig = {
  providers: [
    provideZoneChangeDetection({ eventCoalescing: true }),
    provideRouter(routes),
    importProvidersFrom(
      BrowserAnimationsModule,
      RouterModule,
      ReactiveFormsModule,
      ButtonModule,
      MenuModule,
      MenubarModule,

    ),
    provideHttpClient(withInterceptors([authInterceptor]))
  ]
};
