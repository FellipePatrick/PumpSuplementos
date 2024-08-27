import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatSnackBar, MatSnackBarModule } from '@angular/material/snack-bar';
import { Router, ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Suplemento } from '../model/suplemento';
import { SuplementosServiceService } from '../service/suplementos-service.service';
import { MatTableModule } from '@angular/material/table';
import { MatIconModule } from '@angular/material/icon';
import { MatPaginatorModule, PageEvent } from '@angular/material/paginator';

@Component({
  selector: 'app-listar-suplementos',
  standalone: true,
  imports: [CommonModule, MatSnackBarModule, MatTableModule, MatIconModule, MatPaginatorModule],
  templateUrl: './listar-suplementos.component.html',
  styleUrls: ['./listar-suplementos.component.scss'],
})
export class ListarSuplementosComponent implements OnInit {
  suplemento$: Observable<Suplemento[]> = new Observable<Suplemento[]>();
  produtos_array: Suplemento[] = [];
  displayedColumns = [
    'nome',
    'quantidade',
    'preco',
    'descricao',
    'categoria',
    'acao',
  ];
  totalElements: number = 0;
  pageSize: number = 10;
  currentPage: number = 0;

  constructor(
    private produtosService: SuplementosServiceService,
    public snackBar: MatSnackBar,
    private router: Router,
    private activatedRoute: ActivatedRoute,
    private location: Location
  ) {}

  ngOnInit(): void {
    this.loadSuplementos(this.currentPage, this.pageSize);
  }

  loadSuplementos(page: number, size: number): void {
    console.log(`Carregando suplementos - Página: ${page}, Tamanho: ${size}`);
    this.produtosService.list(page, size).subscribe({
      next: (response) => {
        console.log('Resposta recebida do backend:', response);
        this.produtos_array = response.content;
        this.totalElements = response.totalElements;
        console.log('Suplementos carregados:', this.produtos_array);
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
    this.router.navigate(['editar', id], { relativeTo: this.activatedRoute });
  }

  deletar(id: number): void {
    this.produtosService.deleteSuplemento(id).subscribe({
      next: () => {
        this.snackBar.open('Suplemento deletado com sucesso', 'Fechar', {
          duration: 1000,
        });
        this.loadSuplementos(this.currentPage, this.pageSize);
      },
      error: (error) => {
        this.snackBar.open('Erro ao deletar suplemento', 'Fechar', {
          duration: 1000,
        });
        console.error('Erro ao deletar suplemento:', error);
      }
    });
  }
}
