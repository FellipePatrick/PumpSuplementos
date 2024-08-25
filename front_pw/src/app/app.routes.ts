import { Routes } from '@angular/router';
import { ListarSuplementosComponent } from './Suplementos/listar-suplementos/listar-suplementos.component';
import { FormSuplementoComponent } from './Suplementos/form-suplemento/form-suplemento.component';
import { EditSuplementosComponent } from './Suplementos/edit-suplementos/edit-suplementos.component';
import { LoginComponent } from './Usuarios/login/login.component';
import { PrincipalCompentComponent } from './shared/components/principal-compent/principal-compent.component';

export const routes: Routes = [

  {path: "", redirectTo: "login", pathMatch: 'full'},
  {path: "login", component: LoginComponent},

  {path: "suplementos", component: PrincipalCompentComponent, children: [
    {path: 'listar',component: ListarSuplementosComponent},
    {path: 'criar',component: FormSuplementoComponent},
    {path: 'editar/:id',component: EditSuplementosComponent},
  ]}
];
