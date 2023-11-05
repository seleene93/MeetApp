import { Component } from '@angular/core';
import { MeetupService } from '../service/meetup.service';
import { Meetup } from '../model/meetup';
import { format } from 'date-fns';
import { es } from 'date-fns/locale';
import { CiudadService } from '../../ciudades/service/ciudad.service';
import { Ciudad } from '../../ciudades/model/ciudad';
import { TematicaService } from '../../tematicas/service/tematica.service';
import { Tematica } from '../../tematicas/model/tematica';
import { GetFilterMeetups } from '../model/getFilterMeetups';
import { ConstantesService } from 'src/app/shared/constantes.service';

@Component({
  selector: 'app-meetups',
  templateUrl: './listado-meetups.component.html',
  styleUrls: ['./listado-meetups.component.css'],
})
export class MeetupsComponent {
  getFilterMeetup: GetFilterMeetups = {
    idTematica: null,
    idCiudad: null,
  };

  meetups: Meetup[] = [];
  ciudades: Ciudad[] = [];
  tematicas: Tematica[] = [];
  locale = 'es-ES';

  fechaFormateada: string = '';

  constructor(
    private readonly meetupService: MeetupService,
    private readonly ciudadService: CiudadService,
    private readonly tematicaService: TematicaService,
    private readonly constantes: ConstantesService
  ) {}

  ngOnInit() {
    this.getAllMeetupsFilter(this.getFilterMeetup);
    this.getAllCiudades();
    this.getAllTematicas();
  }

  getAllMeetupsFilter(getFilterMeetup: GetFilterMeetups) {
    this.meetupService
      .getAllMeetupsFilter(this.getFilterMeetup)
      .subscribe((data: Meetup[]) => {
        this.meetups = data;

        for (const meetup of this.meetups) {
          if (meetup.fecha) {
            const fecha = new Date(meetup.fecha);
            this.fechaFormateada = format(
              fecha,
              "dd 'de' MMMM 'de' yyyy 'a las' HH:mm",
              { locale: es }
            );

            if (this.fechaFormateada != 'Fecha inválida') {
              meetup.fecha = this.fechaFormateada;
            }
          }

          if (meetup.avatarUsuario) {
            meetup.avatarUsuario =
              this.constantes.imgUserBase64Init + meetup.avatarUsuario;
          }

          if (meetup.imgBase64) {
            meetup.imgBase64 =
              this.constantes.imgMeetupBase64Init + meetup.imgBase64;
          }
        }
      });
  }

  getAllCiudades() {
    this.ciudadService.getAllCiudades().subscribe((data: Ciudad[]) => {
      this.ciudades = data;
    });
  }

  getAllTematicas() {
    this.tematicaService.getAllTematicas().subscribe((data: Tematica[]) => {
      this.tematicas = data;
    });
  }

  getAllFilterByIdCiudad(event: any) {
    const idCiudad = event.target.value;
    this.getFilterMeetup.idCiudad = idCiudad;
    this.getAllMeetupsFilter(this.getFilterMeetup);
  }

  getAllFilterByIdTematica(event: any) {
    const idTematica = event.target.value;
    this.getFilterMeetup.idTematica = idTematica;
    this.getAllMeetupsFilter(this.getFilterMeetup);
  }
}
