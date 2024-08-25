import { Component } from '@angular/core';
import { ListarSuplementosComponent } from '../../../Suplementos/listar-suplementos/listar-suplementos.component';
import { FormSuplementoComponent } from '../../../Suplementos/form-suplemento/form-suplemento.component';
import { RouterOutlet } from '@angular/router';
@Component({
  selector: 'app-principal-compent',
  standalone: true,
  imports: [RouterOutlet, ListarSuplementosComponent, FormSuplementoComponent],
  templateUrl: './principal-compent.component.html',
  styleUrl: './principal-compent.component.scss'
})
export class PrincipalCompentComponent {

}
