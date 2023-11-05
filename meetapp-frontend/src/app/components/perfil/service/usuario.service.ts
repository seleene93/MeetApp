import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Usuario } from '../model/usuario';

@Injectable({
  providedIn: 'root',
})
export class UsuarioService {
  private url: string = 'http://localhost:8080/api/public/';

  constructor(private httpClient: HttpClient) {}

  login(usuario: Usuario): Observable<Usuario> {
    const loginUrl = `${this.url}login`;
    return this.httpClient.post<Usuario>(loginUrl, usuario);
  }

  registro(usuario: Usuario): Observable<Usuario> {
    const registroUrl = `${this.url}registro`;
    return this.httpClient.post<Usuario>(registroUrl, usuario);
  }

  getUsuarioById(usuario: Usuario): Observable<Usuario> {
    const getUsuarioByIdUrl = `${this.url}usuarios/usuario`;
    return this.httpClient.post<Usuario>(getUsuarioByIdUrl, usuario);
  }
}
