import { Component } from '@angular/core';
import { UsuarioService } from '../perfil/service/usuario.service';
import { Usuario } from '../perfil/model/usuario';
import { Router } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';
import { ConstantesService } from 'src/app/shared/constantes.service';
import { ModalErrorComponent } from 'src/app/shared/modal-error/modal-error.component';
import { Meetup } from '../meetups/model/meetup';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent {
  meetups: Meetup[] = [];
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
    this.meetups
  );
  errorType = '';

  constructor(
    private readonly usuarioService: UsuarioService,
    private router: Router,
    private dialog: MatDialog,
    private constantesService: ConstantesService
  ) {}

  login() {
    this.usuarioService.login(this.usuario).subscribe(
      (data: Usuario) => {
        if (!data.hasErrors) {
          localStorage.setItem('token', data.token);
          this.dialog.closeAll();
          this.router.navigate(['/meetups']);
          this.constantesService.tokenExists = true;
          this.constantesService.imgUsuarioLogueado =
            this.constantesService.imgUserBase64Init + data.avatarBase64;
        } else {
          this.errorType = 'loginError';
          this.openErrorModal(this.errorType);
        }
      },
      (error) => {
        console.error('Error de inicio de sesión', error);
      }
    );
  }

  openErrorModal(errorType: string) {
    const dialogRef = this.dialog.open(ModalErrorComponent, {
      width: '25rem',
      data: { errorType: errorType },
    });

    dialogRef.afterClosed().subscribe((result) => {});
  }
}
