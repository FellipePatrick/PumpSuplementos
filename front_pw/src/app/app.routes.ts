import { Routes } from '@angular/router';
import { ListarSuplementosComponent } from './Suplementos/listar-suplementos/listar-suplementos.component';
import { FormSuplementoComponent } from './Suplementos/form-suplemento/form-suplemento.component';
import { EditSuplementosComponent } from './Suplementos/edit-suplementos/edit-suplementos.component';
import { LoginComponent } from './Usuarios/login/login.component';

export const routes: Routes = [
  {
    path: 'suplementos/listar',
    component: ListarSuplementosComponent,
  },
  {
    path: 'suplementos/criar',
    component: FormSuplementoComponent,
  },
  {
    path: 'suplementos/editar/:id',
    component: EditSuplementosComponent,
  },
  {
    path: 'login',
    component: LoginComponent,
  },
];
