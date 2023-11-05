import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Usuario } from '../../perfil/model/usuario';

@Injectable({
  providedIn: 'root',
})
export class AsistenteService {
  private url: string = 'http://localhost:8080/api/public/';

  constructor(private httpClient: HttpClient) {}

  getMeetupAssist(idMeetup: number): Observable<Usuario[]> {
    const getMeetupAssistUrl = `${this.url}meetups/asistentes`;
    return this.httpClient.post<Usuario[]>(getMeetupAssistUrl, idMeetup);
  }
}
