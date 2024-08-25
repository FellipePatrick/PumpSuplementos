import { Routes } from '@angular/router';
import { ListarSuplementosComponent } from './Suplementos/listar-suplementos/listar-suplementos.component';
import { FormSuplementoComponent } from './Suplementos/form-suplemento/form-suplemento.component';
import { EditSuplementosComponent } from './Suplementos/edit-suplementos/edit-suplementos.component';

export const routes: Routes = [
  {
    path: 'Suplementos/listar-suplementos',
    component: ListarSuplementosComponent
  },
  {
    path: 'Suplementos/criar-suplementos',
    component: FormSuplementoComponent
  },
  {path: 'Suplementos/editar-suplementos/:id', component: EditSuplementosComponent}
];
