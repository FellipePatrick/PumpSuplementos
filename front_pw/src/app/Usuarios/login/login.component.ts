import { Component } from '@angular/core';
import {
  Form,
  FormBuilder,
  FormGroup,
  ReactiveFormsModule,
} from '@angular/forms';
import { UsuarioServiceService } from '../service/usuario-service.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Router } from '@angular/router';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import Swal from 'sweetalert2';
@Component({
  selector: 'app-login',
  standalone: true,
  imports: [MatInputModule, ReactiveFormsModule, MatFormFieldModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss',
})
export class LoginComponent {
  form: FormGroup;
  constructor(
    private usuarioService: UsuarioServiceService,
    private formBuilder: FormBuilder,
    private snackBar: MatSnackBar,
    private router: Router,
    private route: ActivatedRoute // Add this line
  ) {
    this.form = this.formBuilder.group({
      email: [''],
      password: [''],
    });
  }

  ngOnInit(): void {
    this.usuarioService.logout();
  }

  onSubmit() {
    this.usuarioService
      .login(this.form.value.email, this.form.value.password)
      .subscribe({
        next: (v) => this.onSucess('Logado com sucesso!'),
        error: (e) => this.onErro('Erro ao logar, verifique suas credenciais!'),
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
}
