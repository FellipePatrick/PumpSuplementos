import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, map, Observable, tap } from 'rxjs';
import { Usuario } from '../model/usuario';
import { send } from 'process';
@Injectable({
  providedIn: 'root'
})
export class UsuarioServiceService {
  private url = 'https://reqres.in/api/login';
  constructor(private httpClient: HttpClient) {
  }

  login(email: string, password: string): Observable<any> {
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    const body = { email, password };

    return this.httpClient.post<any>(this.url, body, { headers }).pipe(
      map(response => {
        if (response.token) {
          this.setToken(response.token);
          alert('Usuário logado com sucesso');
        } else {
          alert('Usuário ou senha inválidos');
        }
      }),
    );
  }


  logout() {
    localStorage.removeItem('token');
  }

  private getToken() {
    return localStorage.getItem('token');
  }

  private setToken(token: string) {
    localStorage.setItem('token', token);
  }

  isLogged() {
    return !!localStorage.getItem('token') ;
  }

  jwtDecode(token: string) {
    try {
      return JSON.parse(atob(token.split('.')[1]));
    } catch (e) {
      return null;
    }
  }

  hasPermission(permission: string) {
    const token = this.getToken();
    if (!token) {
      return false;
    }
    const payload = this.jwtDecode(token);
    if (!payload) {
      return false;
    }
    return payload.permissions.includes(permission);
  }
}
