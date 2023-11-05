import { Meetup } from '../../meetups/model/meetup';

export class Usuario {
  idUsuario: number;

  nombre: string;

  email: string;

  password: string;

  biografia: string;

  avatarBase64: string;

  avatarFileName: string;

  token: string;

  hasErrors: boolean;

  error: string;

  errorCode: number;

  numeroMeetups: number;

  meetups: Meetup[];

  constructor(
    idUsuario: number,
    nombre: string,
    email: string,
    password: string,
    biografia: string,
    avatarBase64: string,
    avatarFileName: string,
    token: string,
    hasErrors: boolean,
    error: string,
    errorCode: number,
    numeroMeetups: number,
    meetups: Meetup[]
  ) {
    this.idUsuario = idUsuario;
    this.nombre = nombre;
    this.email = email;
    this.password = password;
    this.biografia = biografia;
    this.avatarBase64 = avatarBase64;
    this.avatarFileName = avatarFileName;
    this.token = token;
    this.hasErrors = hasErrors;
    this.error = error;
    this.errorCode = errorCode;
    this.numeroMeetups = numeroMeetups;
    this.meetups = meetups;
  }
}
