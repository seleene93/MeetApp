import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { Meetup } from '../model/meetup';
import { GetFilterMeetups } from '../model/getFilterMeetups';
import { Usuario } from '../../perfil/model/usuario';

@Injectable({
  providedIn: 'root',
})
export class MeetupService {
  private url: string = 'http://localhost:8080/api/public/';
  private urlPrivate: string = 'http://localhost:8080/api/private/';
  private authToken = localStorage.getItem('token');

  constructor(private httpClient: HttpClient) {}

  getAllMeetupsFilter(meetup: GetFilterMeetups): Observable<Meetup[]> {
    const getAllMeetupsFilterUrl = `${this.url}meetups`;
    return this.httpClient.post<Meetup[]>(getAllMeetupsFilterUrl, meetup);
  }

  getMeetupById(meetup: GetFilterMeetups): Observable<Meetup> {
    const getMeetupByIdUrl = `${this.url}meetups/meetup`;
    return this.httpClient.post<Meetup>(getMeetupByIdUrl, meetup);
  }

  nuevoMeetup(meetup: Meetup): Observable<Meetup> {
    const nuevoMeetupUrl = `${this.urlPrivate}meetups/nuevo`;

    const headers = new HttpHeaders({
      Authorization: `Bearer ${this.authToken}`,
    });

    const httpOptions = {
      headers: headers,
      withCredentials: true,
    };

    return this.httpClient.post<Meetup>(nuevoMeetupUrl, meetup, httpOptions);
  }
}
