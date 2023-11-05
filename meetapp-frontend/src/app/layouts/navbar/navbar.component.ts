import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { RegistroComponent } from '../../components/registro/registro.component'; // Asegúrate de importar tu componente de modal
import { LoginComponent } from 'src/app/components/login/login.component';
import { LogoutComponent } from 'src/app/components/logout/logout.component';
import { NuevoMeetupComponent } from 'src/app/components/meetups/nuevo-meetup/nuevo-meetup.component';
import { ConstantesService } from 'src/app/shared/constantes.service';
import { UsuarioService } from 'src/app/components/perfil/service/usuario.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
})
export class NavbarComponent {
  constructor(
    private dialog: MatDialog,
    public constantesService: ConstantesService
  ) {}

  ModalRegistro() {
    this.dialog.open(RegistroComponent, {
      width: '25rem',
    });
  }

  ModalLogin() {
    this.dialog.open(LoginComponent, {
      width: '25rem',
    });
  }

  ModalConfirmLogout() {
    this.dialog.open(LogoutComponent, {
      width: '25rem',
    });
  }

  ModalNuevoMeetup() {
    this.dialog.open(NuevoMeetupComponent, {
      width: '25rem',
    });
  }
}
