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
      token: ['eyJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJzZWxmIiwic3ViIjoiam9hb0BnbWFpbC5jb20iLCJleHAiOjE3MjQ3MDQxNDQsImlhdCI6MTcyNDcwMDU0NCwic2NvcGUiOiJST0xFX0FETUlOIn0.Aji0W-ubGOzCn8-v0V7l2yr72iVUhGVkVeW6vjTL5s6i9cdDneUoTXWiqe9OwjC944KoqbG3PSdYAxrT_mh7s4FgeXzK1NpOT71fYgVWXVcBDM72pvx5GRXGXqcmw9WoklkJ5MEdOP1V97lcdQg4suBrMxmtL5lQqdVo05NBSVkxncHlRMT6sU1fhH1cbFVFNEEVOZ7LtAodGUEFFELlUN6XRA_KvCsg1UO7gYNAlc8TSWCt2KHV2ScVMaBgQf4Ebx_XcOLgtbYVwx6otiBjCHTSPiID00_MaU6cdOGF5NXRFLMz45ud-7Jh8WX-Pzw1bVs9hcNLrhl7XKsCsGhOKg'],
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
