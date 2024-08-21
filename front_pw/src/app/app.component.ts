import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { MatButtonModule } from '@angular/material/button';
import {MatCardModule} from '@angular/material/card';
import { MatToolbarModule } from
'@angular/material/toolbar';
import { ListarSuplementosComponent } from "./Suplementos/listar-suplementos/listar-suplementos.component";
import { CriarSuplementosComponent } from './Suplementos/criar-suplementos/criar-suplementos.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, MatButtonModule, MatCardModule, MatToolbarModule, ListarSuplementosComponent, ListarSuplementosComponent, CriarSuplementosComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss',
})
export class AppComponent {
  title = 'front_pw';
}
