import { Component } from '@angular/core';
import { MatTableModule } from '@angular/material/table';
import { Suplemento } from '../model/suplemento';
import { Observable, delay, catchError } from 'rxjs';
import { SuplementosServiceService } from '../service/suplementos-service.service';
import { AsyncPipe } from '@angular/common';
import { MatSnackBarModule, MatSnackBar } from '@angular/material/snack-bar';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { ActivatedRoute, Router } from '@angular/router';
import { Location } from '@angular/common'; // Importe Location
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-listar-suplementos',
  standalone: true,
  imports: [
    MatTableModule,
    AsyncPipe,
    MatSnackBarModule,
    MatButtonModule,
    MatIconModule,
    CommonModule,
  ],
  templateUrl: './listar-suplementos.component.html',
  styleUrl: './listar-suplementos.component.scss',
})
export class ListarSuplementosComponent {
  suplemento$: Observable<Suplemento[]>;
  //suplemento: Suplemento = new Suplemento();
  produtos_array: Suplemento[] = [];
  displayedColumns = [
    'nome',
    'quantidade',
    'imageUri',
    'preco',
    'descricao',
    'categoria',
    'acao',
  ];
  constructor(
    private produtosService: SuplementosServiceService,
    public snackBar: MatSnackBar,
    private router: Router,
    private activatedRoute: ActivatedRoute,
    private location: Location
  ) {
    produtosService.list().subscribe((p) => (this.produtos_array = p));
    this.suplemento$ = produtosService
      .list()
      .pipe(delay(3000))
      .pipe(
        catchError((error) => {
          this.snackBar.open('Erro ao carregar a lista de produtos', 'Fechar', {
            duration: 2000,
          });
          throw error;
        })
      );
  }

  editar(id: number) {
    alert('Editar');
    this.router.navigate(['suplementos/editar/', id], {
      relativeTo: this.router.routerState.root,
    });
  }

  deletar(id: number) {
    this.produtosService.deleteSuplemento(id).subscribe({
      next: (v) => this.onSucess('Produto deletado com sucesso!'),
      error: (e) => this.onErro(e, 'Fechar'),
      complete: () => console.info('complete'),
    });
  }

  onSucess(string: string) {
    alert('Deletado com sucesso!');
    this.snackBar.open(string, '', { duration: 1000 });
    this.router.navigate(['/'], { skipLocationChange: true }).then(() => {
      this.router.navigate(['/']);
    });
  }

  onErro(errorMensage: string, action: string) {
    this.snackBar.open(errorMensage, action, {
      duration: 2000,
    });
  }
}
