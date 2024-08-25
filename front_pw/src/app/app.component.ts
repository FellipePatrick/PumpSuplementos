import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { MatButtonModule } from '@angular/material/button';
import {MatCardModule} from '@angular/material/card';
import { MatToolbarModule } from
'@angular/material/toolbar';
import { ListarSuplementosComponent } from "./Suplementos/listar-suplementos/listar-suplementos.component";
import { FormSuplementoComponent } from './Suplementos/form-suplemento/form-suplemento.component';

import { RouterLink } from '@angular/router';
import { RouterLinkActive } from '@angular/router';
import { NgModel } from '@angular/forms';




@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    RouterOutlet,
    MatButtonModule,
    MatCardModule,
    MatToolbarModule,
    ListarSuplementosComponent,
    FormSuplementoComponent,
    RouterLink,
    RouterLinkActive
  ],

  templateUrl: './app.component.html',
  styleUrl: './app.component.scss',
})
export class AppComponent {
  secondLink = 'listar-suplementos';
  title = 'front_pw';
}
