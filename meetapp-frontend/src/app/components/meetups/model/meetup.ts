import { Usuario } from '../../perfil/model/usuario';

export class Meetup {
  idMeetup: number;

  idUsuario: number;

  idTematica: number;

  tipoTematica: string;

  idCiudad: number;

  nombreCiudad: string;

  titulo: string;

  fecha: string;

  descripcion: string;

  usuarios: Usuario[];

  numeroAsistentes: number;

  imgBase64: string;

  imgFileName: string;

  avatarUsuario: string;

  constructor(
    idMeetup: number,
    idUsuario: number,
    idTematica: number,
    tipoTematica: string,
    idCiudad: number,
    nombreCiudad: string,
    titulo: string,
    fecha: string,
    descripcion: string,
    usuarios: Usuario[],
    numeroAsistentes: number,
    imgBase64: string,
    imgFileName: string,
    avatarUsuario: string
  ) {
    this.idMeetup = idMeetup;
    this.idUsuario = idUsuario;
    this.idTematica = idTematica;
    this.tipoTematica = tipoTematica;
    this.idCiudad = idCiudad;
    this.nombreCiudad = nombreCiudad;
    this.titulo = titulo;
    this.fecha = fecha;
    this.descripcion = descripcion;
    this.usuarios = usuarios;
    this.numeroAsistentes = numeroAsistentes;
    this.imgBase64 = imgBase64;
    this.imgFileName = imgFileName;
    this.avatarUsuario = avatarUsuario;
  }
}
