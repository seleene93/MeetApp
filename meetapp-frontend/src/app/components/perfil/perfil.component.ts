import { Component } from '@angular/core';
import { Usuario } from './model/usuario';
import { UsuarioService } from './service/usuario.service';
import { ActivatedRoute } from '@angular/router';
import { ConstantesService } from 'src/app/shared/constantes.service';
import { format } from 'date-fns';
import { es } from 'date-fns/locale';

@Component({
  selector: 'app-perfil',
  templateUrl: './perfil.component.html',
  styleUrls: ['./perfil.component.css'],
})
export class PerfilComponent {
  asistentes: Usuario[] = [];
  locale = 'es-ES';
  fechaFormateada: string = '';

  usuario: Usuario = new Usuario(
    0,
    '',
    '',
    '',
    '',
    '',
    '',
    '',
    false,
    '',
    0,
    0,
    []
  );

  constructor(
    private readonly usuarioService: UsuarioService,
    private route: ActivatedRoute,
    public constantes: ConstantesService
  ) {}

  ngOnInit() {
    this.route.queryParams.subscribe((params) => {
      const usuarioId = parseInt(params['id'], 10);
      this.usuario.idUsuario = usuarioId;
    });
    this.usuarioService.getUsuarioById(this.usuario).subscribe((data: any) => {
      this.usuario = data;

      for (let meetup of this.usuario.meetups) {
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
      }

      if (this.usuario.avatarBase64) {
        this.usuario.avatarBase64 =
          this.constantes.imgMeetupBase64Init + this.usuario.avatarBase64;
      }
    });
  }
}
