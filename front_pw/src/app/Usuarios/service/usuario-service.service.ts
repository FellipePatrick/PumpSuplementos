import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { catchError, map, Observable, tap, throwError } from 'rxjs';
import { Usuario } from '../model/usuario';
import { send } from 'process';

@Injectable({
  providedIn: 'root'
})
export class UsuarioServiceService {
  private url = "http://localhost:8080/token/";
  constructor(private httpClient: HttpClient) {
  }

  login(email: string, password: string) {
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    const body = { email, password };
    console.log('Iniciando requisição de login'); // Log para verificar início da requisição
    return this.httpClient.post(this.url, body, { headers, responseType: 'text' }).pipe(
      map(response => {
        console.log('Resposta recebida:', response); // Log para verificar a resposta
        if (response) {
          this.setToken(response);
        }
        return response;
      }),
      catchError((error: HttpErrorResponse) => {
        return throwError(error);
      })
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
