import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { SuplementosServiceService } from '../service/suplementos-service.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { Location } from '@angular/common';
import { Router } from '@angular/router';
import { FooterComponent } from '../footer/footer.component';
import { HeaderComponent } from '../header/header.component';
import Swal from 'sweetalert2';
import { ReactiveFormsModule } from '@angular/forms';

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
  styleUrls: ['./form-suplemento.component.scss'],
})
export class FormSuplementoComponent {
  form: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private service: SuplementosServiceService,
    private snackBar: MatSnackBar,
    private location: Location,
    private router: Router
  ) {
    this.form = this.formBuilder.group({
      id: [''],
      nome: ['', Validators.required],
      quantidade: ['', Validators.required],
      imageUri: ['', Validators.required],
      preco: ['', Validators.required],
      descricao: ['', Validators.required],
      categoria: ['', Validators.required],
      token: ['eyJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJzZWxmIiwic3ViIjoiam9hb0BnbWFpbC5jb20iLCJleHAiOjE3MjQ3MDQxNDQsImlhdCI6MTcyNDcwMDU0NCwic2NvcGUiOiJST0xFX0FETUlOIn0.Aji0W-ubGOzCn8-v0V7l2yr72iVUhGVkVeW6vjTL5s6i9cdDneUoTXWiqe9OwjC944KoqbG3PSdYAxrT_mh7s4FgeXzK1NpOT71fYgVWXVcBDM72pvx5GRXGXqcmw9WoklkJ5MEdOP1V97lcdQg4suBrMxmtL5lQqdVo05NBSVkxncHlRMT6sU1fhH1cbFVFNEEVOZ7LtAodGUEFFELlUN6XRA_KvCsg1UO7gYNAlc8TSWCt2KHV2ScVMaBgQf4Ebx_XcOLgtbYVwx6otiBjCHTSPiID00_MaU6cdOGF5NXRFLMz45ud-7Jh8WX-Pzw1bVs9hcNLrhl7XKsCsGhOKg'],
    });
  }

  onSubmit() {
    if (this.form.valid) {
      console.log('Dados do formulário:', this.form.value);
      this.service.postSuplemento(this.form.value).subscribe({
        next: (response) => {
          Swal.fire({
            icon: 'success',
            title: 'Sucesso',
            text: 'Suplemento criado com sucesso!',
            showConfirmButton: false,
            timer: 1500
          });
          this.router.navigate(['/suplementos']);
        },
        error: (error) => {
          Swal.fire({
            icon: 'error',
            title: 'Erro',
            text: 'Erro ao criar suplemento: ' + error.message,
            confirmButtonText: 'Fechar',
            allowOutsideClick: false
          });
          console.error('Erro ao criar suplemento:', error);
        }
      });
    } else {
      Swal.fire({
        icon: 'error',
        title: 'Erro',
        text: 'Por favor, preencha todos os campos obrigatórios.',
        confirmButtonText: 'Fechar',
        allowOutsideClick: false
      });
    }
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
