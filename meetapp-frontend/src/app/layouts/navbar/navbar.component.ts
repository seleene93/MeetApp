import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { RegistroComponent } from '../../components/registro/registro.component'; // Asegúrate de importar tu componente de modal
import { LoginComponent } from 'src/app/components/login/login.component';
import { LogoutComponent } from 'src/app/logout/logout.component';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
})
export class NavbarComponent {
  constructor(private dialog: MatDialog) {}

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
}
