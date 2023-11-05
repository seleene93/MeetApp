import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Tematica } from '../model/tematica';

@Injectable({
  providedIn: 'root',
})
export class TematicaService {
  private url: string = 'http://localhost:8080/api/public/';

  constructor(private httpClient: HttpClient) {}

  getAllTematicas(): Observable<Tematica[]> {
    const getAllTematicasUrl = `${this.url}tematicas`;
    return this.httpClient.get<Tematica[]>(getAllTematicasUrl);
  }
}
