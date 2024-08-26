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
import { HeaderComponent } from '../header/header.component';
import { FooterComponent } from '../footer/footer.component';
import Swal from 'sweetalert2';
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
    FooterComponent,
    HeaderComponent,
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
    this.suplemento$ = produtosService.list().pipe(
      catchError((error) => {
        this.onErro('Erro ao carregar a lista de produtos');
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
      error: (e) => this.onErro('Fechar'),
      complete: () => console.info('complete'),
    });
  }

  onSucess(message: string) {
    Swal.fire({
      icon: 'success',
      title: 'Sucesso',
      text: message,
      showConfirmButton: false,
      timer: 1500,
      // didClose: () => {
      //   this.router.navigate(['/suplementos']);
      // },
    });
  }

  onErro(errorMessage: string) {
    Swal.fire({
      icon: 'error',
      title: 'Erro',
      text: errorMessage,
      confirmButtonText: 'Fechar',
      allowOutsideClick: false,
    });
  }
}
