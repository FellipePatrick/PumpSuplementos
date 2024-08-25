import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Suplemento } from '../model/suplemento';
import { first, Observable, of, tap } from 'rxjs';
import { environment } from '../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class SuplementosServiceService {
  private API_URL = environment.api + '/Suplementos';
  constructor(private httpClient:HttpClient) { }

  list():Observable<Suplemento[]>{
    return this.httpClient.get<Suplemento[]>(this.API_URL)
    //.pipe(first(),
   // tap(p => console.log(p))
    //)
    }

  public deleteSuplemento(id:number){
    return this.httpClient.delete(`${this.API_URL}/${id}`);
  }


  public getSuplementos(){
    return this.httpClient.get<Suplemento[]>(this.API_URL);
  }

  public getSuplementoById(id:number){
    return this.httpClient.get<Suplemento>(`${this.API_URL}/${id}`);
  }

  public postSuplemento(suplemento:Suplemento){
    return this.httpClient.post(this.API_URL, suplemento).pipe(first(), tap(p => console.log(p)));
  }

  public putSuplemento(suplemento:Suplemento){
     return this.httpClient.put(`${this.API_URL}/${suplemento.id}`, suplemento);
  }

  // Tratador de erros genérico
  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(`${operation} falhou: ${error.message}`);
      return of(result as T);
    };
  }
}
