import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { RegistroComponent } from './components/registro/registro.component';
import { InicioComponent } from './components/inicio/inicio.component';
import { FooterComponent } from './layouts/footer/footer.component';
import { NavbarComponent } from './layouts/navbar/navbar.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatDialogModule } from '@angular/material/dialog';
import { MeetupComponent } from './components/meetups/meetup/meetup.component';
import { LogoutComponent } from './components/logout/logout.component';
import { ListadoAsistentesComponent } from './components/listado-asistentes/listado-asistentes.component';
import { PerfilComponent } from './components/perfil/perfil.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { NuevoMeetupComponent } from './components/meetups/nuevo-meetup/nuevo-meetup.component';
import { ConstantesService } from './shared/constantes.service';
import { MeetupsComponent } from './components/meetups/listado-meetups/listado-meetups.component';
import { ModalErrorComponent } from './shared/modal-error/modal-error.component';

@NgModule({
  declarations: [
    AppComponent,
    MeetupsComponent,
    LoginComponent,
    RegistroComponent,
    InicioComponent,
    FooterComponent,
    NavbarComponent,
    MeetupComponent,
    LogoutComponent,
    ListadoAsistentesComponent,
    PerfilComponent,
    NuevoMeetupComponent,
    ModalErrorComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatDialogModule,
    FormsModule,
    HttpClientModule,
  ],
  providers: [ConstantesService],
  bootstrap: [AppComponent],
})
export class AppModule {}
