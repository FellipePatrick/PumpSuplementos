import { Component } from '@angular/core';
import { MatTableModule } from '@angular/material/table';
import { Suplemento } from '../model/suplemento';
import { Observable } from 'rxjs';
import { SuplementosServiceService } from '../service/suplementos-service.service';
@Component({
  selector: 'app-listar-suplementos',
  standalone: true,
  imports: [MatTableModule],
  templateUrl: './listar-suplementos.component.html',
  styleUrl: './listar-suplementos.component.scss'
})
export class ListarSuplementosComponent {

  produtos$: Observable<Suplemento[]>;
  produtos_array: Suplemento[] = [];
  displayedColumns = ['nome', 'descricao']
  constructor(private produtosService: SuplementosServiceService) {
  produtosService.list().subscribe(p => this.produtos_array = p)
  this.produtos$ = produtosService.list();
  console.log(produtosService.list());
}

}
