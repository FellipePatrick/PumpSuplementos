import { Routes } from '@angular/router';

export const routes: Routes = [
{
  path: 'suplementos', loadComponent() {
    return import('./Suplementos/listar-suplementos/listar-suplementos.component').then(m => m.ListarSuplementosComponent);
 },
}
];
