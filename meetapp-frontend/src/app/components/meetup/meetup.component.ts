import { AUTO_STYLE } from '@angular/animations';
import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ListadoAsistentesComponent } from 'src/app/listado-asistentes/listado-asistentes.component';

@Component({
  selector: 'app-meetup',
  templateUrl: './meetup.component.html',
  styleUrls: ['./meetup.component.css'],
})
export class MeetupComponent {
  constructor(private dialog: MatDialog) {}

  ModalListadoAsistentes() {
    this.dialog.open(ListadoAsistentesComponent, {
      width: AUTO_STYLE,
    });
  }
}
