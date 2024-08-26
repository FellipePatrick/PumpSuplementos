import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { SuplementosServiceService } from '../service/suplementos-service.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatFormField } from '@angular/material/form-field';
import { Observable } from 'rxjs';
import { Suplemento } from '../model/suplemento';
import { ReactiveFormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { Location } from '@angular/common'; // Importe Location
import { Router } from '@angular/router';
import { FooterComponent } from '../footer/footer.component';
import { HeaderComponent } from '../header/header.component';
import Swal from 'sweetalert2';
@Component({
  selector: 'app-form-suplemento',
  standalone: true,
  imports: [
    MatInputModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    FooterComponent,
    HeaderComponent,
  ],
  templateUrl: './form-suplemento.component.html',
  styleUrl: './form-suplemento.component.scss',
})
export class FormSuplementoComponent {
  // suplemento$: Observable<Suplemento[]>;
  form: FormGroup;
  //suplemento$: Observable<Suplemento[]>;
  constructor(
    private formBuilder: FormBuilder,
    private service: SuplementosServiceService,
    private snackBar: MatSnackBar,
    private location: Location,
    private router: Router
  ) {
    // this.suplemento$ = service.list();
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

  onSubmit() {
    this.service.postSuplemento(this.form.value).subscribe({
      next: (v) => this.onSucess('Salvo com sucesso!'),
      error: (e) => this.snackBar.open(e, '', { duration: 1000 }),
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
        this.router.navigate(['/suplementos']);
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
