export class Asistente {
  private idAsistencia: number;

  private idMeetup: number;

  private idUsuario: number;

  constructor(idAsistencia: number, idMeetup: number, idUsuario: number) {
    this.idAsistencia = idAsistencia;
    this.idMeetup = idMeetup;
    this.idUsuario = idUsuario;
  }
}
