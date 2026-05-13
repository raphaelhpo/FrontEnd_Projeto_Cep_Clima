import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CepClimaResponse } from '../models/cep-clima';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CepClimaService {

  private apiUrl = environment.apiUrl;

  constructor(private http: HttpClient) { }

  buscarCepClima(cep: string): Observable<CepClimaResponse> {
    return this.http.get<CepClimaResponse>(`${this.apiUrl}/api/cep/${cep}`, {});
  }
}