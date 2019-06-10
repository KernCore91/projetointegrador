import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { endpoint } from './const';

@Injectable({
  providedIn: 'root'
})
export class BaixaRestService {

  constructor(private http: HttpClient) { }


  save(baixa: any): Observable<any> {
    return this.http.post(endpoint + 'baixa/save', baixa);
  }

  calcular(baixa: any): Observable<any> {
    return this.http.post(endpoint + 'baixa/calcular', baixa);
  }

  list(): Observable<any> {
    return this.http.get(endpoint + 'baixa/list');
  }

  delete(id: any): Observable<any> {
    return this.http.delete(endpoint + 'baixa/delete/' + id);
  }
}