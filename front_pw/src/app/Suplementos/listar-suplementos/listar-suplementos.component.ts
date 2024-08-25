import { Component } from '@angular/core';
import { MatTableModule } from '@angular/material/table';
import { Suplemento } from '../model/suplemento';
import { Observable, delay, catchError} from 'rxjs';
import { SuplementosServiceService } from '../service/suplementos-service.service';
import { AsyncPipe } from '@angular/common';
import { MatSnackBarModule, MatSnackBar } from '@angular/material/snack-bar';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { ActivatedRoute, Router } from '@angular/router';


@Component({
  selector: 'app-listar-suplementos',
  standalone: true,
  imports: [MatTableModule, AsyncPipe, MatSnackBarModule, MatButtonModule, MatIconModule],
  templateUrl: './listar-suplementos.component.html',
  styleUrl: './listar-suplementos.component.scss'
})
export class ListarSuplementosComponent {
  suplemento$: Observable<Suplemento[]>;
  //suplemento: Suplemento = new Suplemento();
  produtos_array: Suplemento[] = [];
  displayedColumns = ['nome', 'quantidade', 'imageUri', 'preco', 'descricao', 'categoria', 'acao'];
  constructor(
    private produtosService:SuplementosServiceService,
    public snackBar: MatSnackBar,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {
    produtosService.list().subscribe(p => this.produtos_array = p)
    this.suplemento$ = produtosService.list()
    .pipe(delay(3000))
    .pipe(
      catchError(error => {
        this.snackBar.open('Erro ao carregar a lista de produtos', 'Fechar', {
          duration: 2000,
        });
        throw error;
      }
    )
    );
  }

  editar(){
    alert('Editar');
    console.log('Método editar foi chamado');
  }

  deletar(id: number){
    this.produtosService.deleteSuplemento(id)
    .subscribe({
      //next: (v) => this.onSucess('Produto deletado com sucesso!'),
      error: (e) => this.onErro(e, 'Fechar'),
      complete: () => console.info('complete')
    })
    //refresh na pagina
    this.router.navigate(['suplementos'], {relativeTo: this.activatedRoute})

  }

  onAdd(){
    alert('Adicionar');
    console.log('Método onAdd foi chamado');
    this.router.navigate(['suplementos/create'], {relativeTo: this.activatedRoute})
  }


  onErro(errorMensage: string, action: string) {
    this.snackBar.open(errorMensage, action, {
      duration: 2000,
    });
  }

}
