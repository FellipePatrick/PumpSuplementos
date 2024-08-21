import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Suplemento } from '../model/suplemento';
import { first, Observable, tap } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class SuplementosServiceService {
  private API_URL = "http://localhost:3000/Suplementos";
  constructor(private httpClient:HttpClient) { }

  list():Observable<Suplemento[]>{
    return this.httpClient.get<Suplemento[]>(this.API_URL)
    .pipe(first(),
    tap(p => console.log(p))
    )
    }


  public getSuplementos(){
    return this.httpClient.get<Suplemento[]>(this.API_URL);
  }

  public getSuplementoById(id:number){
    return this.httpClient.get<Suplemento>(`${this.API_URL}/${id}`);
  }

  public postSuplemento(suplemento:Suplemento){
    return this.httpClient.post(this.API_URL, suplemento);
  }

  public putSuplemento(suplemento:Suplemento){
   // return this.httpClient.put(`${this.API_URL}/${suplemento.id}`, suplemento);
  }
}
