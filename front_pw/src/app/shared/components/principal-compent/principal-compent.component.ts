import { Component } from '@angular/core';
import { ListarSuplementosComponent } from '../../../Suplementos/listar-suplementos/listar-suplementos.component';
import { FormSuplementoComponent } from '../../../Suplementos/form-suplemento/form-suplemento.component';
import { RouterOutlet } from '@angular/router';
import { HeaderComponent } from '../../../Suplementos/header/header.component';
import { FooterComponent } from '../../../Suplementos/footer/footer.component';
@Component({
  selector: 'app-principal-compent',
  standalone: true,
  imports: [
    RouterOutlet,
    ListarSuplementosComponent,
    FormSuplementoComponent,
    HeaderComponent,
    FooterComponent,
  ],
  templateUrl: './principal-compent.component.html',
  styleUrls: ['./principal-compent.component.scss'],
})
export class PrincipalCompentComponent {}
