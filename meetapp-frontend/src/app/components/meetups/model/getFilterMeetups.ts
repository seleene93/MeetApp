export class GetFilterMeetups {
  public idMeetup?: number | null;
  public idTematica?: number | null;
  public idCiudad?: number | null;

  constructor(
    idMeetup: number | null,
    idTematica: number | null,
    idCiudad: number | null
  ) {
    this.idMeetup = idMeetup;
    this.idTematica = idTematica;
    this.idCiudad = idCiudad;
  }
}
