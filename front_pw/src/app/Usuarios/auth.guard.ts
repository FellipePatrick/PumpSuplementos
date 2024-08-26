import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';


export const authGuard: CanActivateFn = (route, state) => {
    const loggedUser = localStorage.getItem('token');
    const router = inject(Router);
    if(loggedUser != null){
        return true;
    }else{
      //redireciona tela login
      router.navigate(['/login']);
      return false;
    }
};
