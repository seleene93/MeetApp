import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Ciudad } from '../model/ciudad';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class CiudadService {
  private url: string = 'http://localhost:8080/api/public/';

  constructor(private httpClient: HttpClient) {}

  getAllCiudades(): Observable<Ciudad[]> {
    const getAllCiudadesUrl = `${this.url}ciudades`;
    return this.httpClient.get<Ciudad[]>(getAllCiudadesUrl);
  }
}
