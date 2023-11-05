import { Component } from '@angular/core';
import { UsuarioService } from '../perfil/service/usuario.service';
import { Router } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';
import { Usuario } from '../perfil/model/usuario';
import { ConstantesService } from 'src/app/shared/constantes.service';
import { ModalErrorComponent } from 'src/app/shared/modal-error/modal-error.component';
import { Meetup } from '../meetups/model/meetup';

@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.css'],
})
export class RegistroComponent {
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
  nombreImagen: string = '';
  imagenBase64: string = '';
  extensionImg: string = '';
  errorType = '';

  constructor(
    private readonly usuarioService: UsuarioService,
    private router: Router,
    private dialog: MatDialog,
    private constantesService: ConstantesService
  ) {}

  registro() {
    this.usuario.avatarFileName = this.nombreImagen;
    this.usuario.avatarBase64 = this.imagenBase64;

    if (this.extensionImg === 'png') {
      this.usuarioService.registro(this.usuario).subscribe(
        (data: Usuario) => {
          localStorage.setItem('token', data.token);
          this.dialog.closeAll();
          this.router.navigate(['/meetups']);
          this.constantesService.tokenExists = true;
        },
        (error) => {
          console.error('Error al registrar el usuario', error);
          this.errorType = 'registerError';
          this.openErrorModal(this.errorType);
        }
      );
    } else {
      this.errorType = 'noValidImgFile';
      this.openErrorModal(this.errorType);
    }
  }

  openErrorModal(errorType: string) {
    const dialogRef = this.dialog.open(ModalErrorComponent, {
      width: '25rem',
      data: { errorType: errorType },
    });

    dialogRef.afterClosed().subscribe((result) => {});
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
}
