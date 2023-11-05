import { Component } from '@angular/core';
import { Meetup } from '../model/meetup';
import { MeetupService } from '../service/meetup.service';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { Ciudad } from '../../ciudades/model/ciudad';
import { Tematica } from '../../tematicas/model/tematica';
import { CiudadService } from '../../ciudades/service/ciudad.service';
import { TematicaService } from '../../tematicas/service/tematica.service';

@Component({
  selector: 'app-nuevo-meetup',
  templateUrl: './nuevo-meetup.component.html',
  styleUrls: ['./nuevo-meetup.component.css'],
})
export class NuevoMeetupComponent {
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
    [],
    0,
    '',
    '',
    ''
  );
  nombreImagen: string = '';
  imagenBase64: string = '';
  extensionImg: string = '';

  ciudades: Ciudad[] = [];
  tematicas: Tematica[] = [];

  constructor(
    private readonly meetupService: MeetupService,
    private readonly ciudadService: CiudadService,
    private readonly tematicaService: TematicaService,
    private router: Router,
    private dialog: MatDialog
  ) {}

  ngOnInit() {
    this.getAllCiudades();
    this.getAllTematicas();
  }

  nuevoMeetup() {
    this.meetup.imgFileName = this.nombreImagen;
    this.meetup.imgBase64 = this.imagenBase64;

    this.meetupService.nuevoMeetup(this.meetup).subscribe(
      (data: Meetup) => {
        this.dialog.closeAll();
        this.router.navigate(['/meetups']);
      },
      (error) => {
        console.error('Error al subir el meetup', error);
      }
    );
  }

  onFileSelected(event: any) {
    const file = event.target.files[0];
    if (file) {
      const reader = new FileReader();
      this.nombreImagen = file.name;
      this.extensionImg = file.name.split('.')[1];

      reader.onload = (e: any) => {
        // e.target.result contiene la imagen en Base64
        this.imagenBase64 = e.target.result.split(',')[1];
      };

      reader.readAsDataURL(file);
    }
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
}
