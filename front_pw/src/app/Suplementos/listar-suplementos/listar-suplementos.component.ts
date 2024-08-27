import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Observable } from 'rxjs';
import { Suplemento } from '../model/suplemento';
import { SuplementosServiceService } from '../service/suplementos-service.service';
import { MatSnackBar, MatSnackBarModule } from '@angular/material/snack-bar';
import { Router, ActivatedRoute, RouterModule } from '@angular/router';
import { MatPaginatorModule, PageEvent } from '@angular/material/paginator';
import { MatTableModule, MatTableDataSource } from '@angular/material/table';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { catchError, map } from 'rxjs/operators';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-listar-suplementos',
  standalone: true,
  imports: [
    CommonModule,
    MatSnackBarModule,
    RouterModule,
    MatPaginatorModule,
    MatTableModule,
    MatIconModule,
    MatButtonModule
  ],
  templateUrl: './listar-suplementos.component.html',
  styleUrls: ['./listar-suplementos.component.scss'],
})
export class ListarSuplementosComponent implements OnInit {
  suplemento$: Observable<{ content: Suplemento[], totalElements: number }> = new Observable<{ content: Suplemento[], totalElements: number }>();
  dataSource = new MatTableDataSource<Suplemento>();
  displayedColumns = ['id', 'nome', 'quantidade', 'preco', 'descricao', 'categoria', 'acao'];
  totalElements: number = 0;
  pageSize: number = 10;
  currentPage: number = 0;

  constructor(
    private produtosService: SuplementosServiceService,
    public snackBar: MatSnackBar,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.loadSuplementos(this.currentPage, this.pageSize);
  }

  loadSuplementos(page: number, size: number): void {
    this.suplemento$ = this.produtosService.list(page, size).pipe(
      map(response => ({
        content: response.content,
        totalElements: response.totalElements
      })),
      catchError((error) => {
        this.onErro('Erro ao carregar a lista de produtos');
        throw error;
      })
    );

    this.suplemento$.subscribe({
      next: (response) => {
        this.dataSource.data = response.content;
        this.totalElements = response.totalElements;
      },
      error: (error) => {
        this.snackBar.open('Erro ao carregar a lista de produtos', 'Fechar', {
          duration: 1000,
        });
        console.error('Erro ao carregar suplementos:', error);
      }
    });
  }

  onPageChange(event: PageEvent): void {
    this.currentPage = event.pageIndex;
    this.pageSize = event.pageSize;
    this.loadSuplementos(this.currentPage, this.pageSize);
  }

  editar(id: number): void {
    this.router.navigate(['suplementos/editar/', id], {
      relativeTo: this.router.routerState.root,
    });
  }

  deletar(id: number): void {
    this.produtosService.deleteSuplemento(id).subscribe({
      next: () => {
        Swal.fire({
          icon: 'success',
          title:  'Success',
          text: 'Suplemento deletado com sucesso!',
          confirmButtonText: 'Fechar',
          allowOutsideClick: false,
        });
        this.loadSuplementos(this.currentPage, this.pageSize);
        this.router.navigate(['/suplementos']);
      },
      error: (error) => {
        Swal.fire({
          icon: 'error',
          title: 'Erro',
          text: 'Erro ao deletar suplemento: ' + error.message,
          confirmButtonText: 'Fechar',
          allowOutsideClick: false,
        });
        console.error('Erro ao deletar suplemento:', error);
      }
    });
  }

  mostrarProdutos(produtos: Suplemento[]): void {
    // Implementação da função mostrarProdutos
  }

  onErro(mensagem: string): void {
    this.snackBar.open(mensagem, 'Fechar', {
      duration: 1000,
    });
  }
}
