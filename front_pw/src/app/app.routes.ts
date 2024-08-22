import { Routes } from '@angular/router';

export const routes: Routes = [
{
  path: 'suplementos', loadComponent() {
    return import('./Suplementos/listar-suplementos/listar-suplementos.component').then(m => m.ListarSuplementosComponent);
 }
},
{
  path: 'suplementos/create', loadComponent() {
    return import('./Suplementos/criar-suplementos/criar-suplementos.component').then(m => m.CriarSuplementosComponent);
  }
}
];
