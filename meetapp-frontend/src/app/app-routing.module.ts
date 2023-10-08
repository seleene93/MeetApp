import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MeetupsComponent } from './components/meetups/meetups.component';
import { InicioComponent } from './components/inicio/inicio.component';
import { MeetupComponent } from './components/meetup/meetup.component';

const routes: Routes = [
  { path: '', redirectTo: '/inicio', pathMatch: 'full' },
  { path: 'inicio', component: InicioComponent },
  { path: 'meetups', component: MeetupsComponent },
  { path: 'meetup', component: MeetupComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
