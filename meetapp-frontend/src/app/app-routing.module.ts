import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MeetupsComponent } from './components/meetups/listado-meetups/listado-meetups.component';
import { InicioComponent } from './components/inicio/inicio.component';
import { MeetupComponent } from './components/meetups/meetup/meetup.component';
import { PerfilComponent } from './components/perfil/perfil.component';

const routes: Routes = [
  { path: '', redirectTo: '/inicio', pathMatch: 'full' },
  { path: 'inicio', component: InicioComponent },
  { path: 'meetups', component: MeetupsComponent },
  { path: 'meetup', component: MeetupComponent },
  { path: 'perfil', component: PerfilComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
