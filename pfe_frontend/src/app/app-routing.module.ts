import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from "./athentification/login/login.component";
import {RegistrationComponent} from "./athentification/registration/registration.component";
import {HomeRhComponent} from "./agentRH/home-rh/home-rh.component";
import {ImportPointageComponent} from "./agentRH/import-pointage/import-pointage.component";
import {VerificationPresenceComponent} from "./agentRH/presence/verification-presence/verification-presence.component";
import {EffectifComponent} from "./agentRH/presence/effectif/effectif.component";
import {ConsultRemplacentComponent} from "./agentRH/consult-remplacent/consult-remplacent.component";
import {ModifierCompteComponent} from "./athentification/modifier-compte/modifier-compte.component";
import {AuthGuard} from "./guards/auth.guard";
import {ModifierPasswordComponent} from "./athentification/modifier-password/modifier-password.component";

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'signup', component: RegistrationComponent},
  {path: 'home-rh', component: HomeRhComponent},
  {path: 'import-pointage', component: ImportPointageComponent, canActivate: [AuthGuard]},
  {path: 'consult-effectif', component: EffectifComponent, canActivate: [AuthGuard]},
  {path: 'consult-remplacent', component: ConsultRemplacentComponent, canActivate: [AuthGuard]},
  {path: 'choisir-date', component: VerificationPresenceComponent, canActivate: [AuthGuard]},
  { path: 'modifier-profil', component: ModifierCompteComponent , canActivate: [AuthGuard]},
  { path: 'modifier-password', component: ModifierPasswordComponent , canActivate: [AuthGuard]},
  {path: '**', redirectTo: 'login'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule {

}
