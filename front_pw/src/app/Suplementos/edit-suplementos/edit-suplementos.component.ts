import { Component } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { SuplementosServiceService } from '../service/suplementos-service.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Location } from '@angular/common';
import { Router, ActivatedRoute } from '@angular/router';
import { Suplemento } from '../model/suplemento';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { FooterComponent } from '../footer/footer.component';
import Swal from 'sweetalert2';
@Component({
  selector: 'app-edit-suplementos',
  standalone: true,
  imports: [
    MatInputModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    FooterComponent,
  ],
  templateUrl: './edit-suplementos.component.html',
  styleUrl: './edit-suplementos.component.scss',
})
export class EditSuplementosComponent {
  // suplemento$: Observable<Suplemento[]>;
  form: FormGroup;
  //suplemento$: Observable<Suplemento[]>;

  id: string | null = null;
  suplemento: Suplemento | undefined;

  constructor(
    private formBuilder: FormBuilder,
    private location: Location,
    private router: Router,
    private route: ActivatedRoute,
    private service: SuplementosServiceService
  ) {
    this.form = this.formBuilder.group({
      id: [''],
      nome: [''],
      quantidade: [''],
      imageUri: [''],
      preco: [''],
      descricao: [''],
      categoria: [''],
    });
  }

  ngOnInit(): void {
    // Obtenha o ID da rota
    const id = Number(this.route.snapshot.paramMap.get('id'));

    // Faça a chamada ao serviço para buscar os dados do suplemento
    this.service.getSuplementoById(id).subscribe((suplemento: Suplemento) => {
      this.suplemento = suplemento;


      // Atualize o formulário com os dados do suplemento
      this.form.patchValue({
        id: this.suplemento.id,
        nome: this.suplemento.nome,
        quantidade: this.suplemento.quantidade,
        imageUri: this.suplemento.imageUri,
        preco: this.suplemento.preco,
        descricao: this.suplemento.descricao,
        categoria: this.suplemento.categoria,
      });
    });
  }
  onSubmit() {
    this.service.putSuplemento(this.form.value).subscribe({
      next: (v) => this.onSucess('Salvo com sucesso!'),
      error: (e) => this.onErro('Erro ao salvar, verifique os campos!'),
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
      didClose: () => {
        this.router.navigate(['suplementos']);
      },
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
  onCancel() {
    this.location.back();
  }
}
