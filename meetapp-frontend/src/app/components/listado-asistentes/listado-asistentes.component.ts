import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Usuario } from '../perfil/model/usuario';
import { ConstantesService } from 'src/app/shared/constantes.service';
import { AsistenteService } from './service/asistente.service';

@Component({
  selector: 'app-listado-asistentes',
  templateUrl: './listado-asistentes.component.html',
  styleUrls: ['./listado-asistentes.component.css'],
})
export class ListadoAsistentesComponent {
  asistentes: Usuario[] = [];
  meetupId: number = 0;

  constructor(
    @Inject(MAT_DIALOG_DATA) public data: any,
    private readonly asistenteService: AsistenteService,
    private readonly constantes: ConstantesService
  ) {
    this.meetupId = this.data.meetupId;
  }

  ngOnInit() {
    this.asistenteService
      .getMeetupAssist(this.meetupId)
      .subscribe((data: any) => {
        this.asistentes = data;
        this.checkAndFixImg(this.asistentes);
      });
  }

  checkAndFixImg(asistentes: Usuario[]) {
    for (const asistente of this.asistentes) {
      if (asistente.avatarBase64) {
        asistente.avatarBase64 =
          this.constantes.imgUserBase64Init + asistente.avatarBase64;
      }
    }
  }
}
