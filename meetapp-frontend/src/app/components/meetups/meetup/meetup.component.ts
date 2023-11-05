import { AUTO_STYLE } from '@angular/animations';
import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { format } from 'date-fns';
import { es } from 'date-fns/locale';
import { ListadoAsistentesComponent } from 'src/app/components/listado-asistentes/listado-asistentes.component';
import { ActivatedRoute } from '@angular/router';
import { MeetupService } from '../service/meetup.service';
import { Meetup } from '../model/meetup';
import { Usuario } from '../../perfil/model/usuario';
import { GetFilterMeetups } from '../model/getFilterMeetups';
import { ConstantesService } from 'src/app/shared/constantes.service';

@Component({
  selector: 'app-meetup',
  templateUrl: './meetup.component.html',
  styleUrls: ['./meetup.component.css'],
})
export class MeetupComponent {
  getFilterMeetup: GetFilterMeetups = new GetFilterMeetups(null, null, null);
  asistentes: Usuario[] = [];

  meetup: Meetup = new Meetup(
    0,
    0,
    0,
    '',
    0,
    '',
    '',
    '',
    '',
    this.asistentes,
    0,
    '',
    '',
    ''
  );

  locale = 'es-ES';
  fechaFormateada: string = '';

  constructor(
    private dialog: MatDialog,
    private route: ActivatedRoute,
    private readonly meetupService: MeetupService,
    public constantes: ConstantesService
  ) {}

  ngOnInit() {
    this.route.queryParams.subscribe((params) => {
      const meetupId = parseInt(params['id'], 10);
      this.getFilterMeetup.idMeetup = meetupId;
      this.meetupService
        .getMeetupById(this.getFilterMeetup)
        .subscribe((data: any) => {
          this.meetup = data;

          if (this.meetup.fecha) {
            const fecha = new Date(this.meetup.fecha);
            this.fechaFormateada = format(
              fecha,
              "dd 'de' MMMM 'de' yyyy 'a las' HH:mm",
              { locale: es }
            );

            if (this.fechaFormateada != 'Fecha inválida') {
              this.meetup.fecha = this.fechaFormateada;
            }
          }

          if (this.meetup.imgBase64) {
            this.meetup.imgBase64 =
              this.constantes.imgMeetupBase64Init + this.meetup.imgBase64;
          }
        });
    });
  }

  ModalListadoAsistentes(idMeetup: number) {
    this.dialog.open(ListadoAsistentesComponent, {
      width: AUTO_STYLE,
      data: { meetupId: idMeetup },
    });
  }
}
