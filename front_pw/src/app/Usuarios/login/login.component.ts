import { Component } from '@angular/core';
import { Form, FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { UsuarioServiceService } from '../service/usuario-service.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Router} from '@angular/router';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [MatInputModule, ReactiveFormsModule, MatFormFieldModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent {
  form:FormGroup;
  constructor(
    private usuarioService: UsuarioServiceService,
    private formBuilder:FormBuilder,
    private snackBar:MatSnackBar,
    private router: Router,
    private route: ActivatedRoute // Add this line
  ) {
    this.form = this.formBuilder.group({
      email: [''],
      password: [''],
  })}

  onSubmit(){
    this.usuarioService.login(this.form.value.email, this.form.value.password)
    .subscribe({
      next: (v) => this.onSucess(),
      error: (e) => this.snackBar.open(e, "", {duration:1000 }),
      complete: () => console.info('complete')
    })
  }

  onSucess(){
    alert('Salvo com sucesso!');
    this.snackBar.open("Salvo!", "", {duration:1000 })
    this.router.navigate(['/'], { skipLocationChange: true }).then(() => {
      this.router.navigate(['/']);
    });
  }

}
