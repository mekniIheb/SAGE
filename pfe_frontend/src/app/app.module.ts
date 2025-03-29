import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './athentification/login/login.component';
import { RegistrationComponent } from './athentification/registration/registration.component';
import { AcceuilComponent } from './acceuil/acceuil.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import { HorizontalMenuAgentRhComponent } from './agentRH/horizontal-menu-agent-rh/horizontal-menu-agent-rh.component';
import { VerticalMenuAgentRhComponent } from './agentRH/vertical-menu-agent-rh/vertical-menu-agent-rh.component';
import { HomeRhComponent } from './agentRH/home-rh/home-rh.component';
import { FooterComponent } from './footer/footer.component';
import {ImportPointageComponent} from "./agentRH/import-pointage/import-pointage.component";
import { VerificationPresenceComponent } from './agentRH/presence/verification-presence/verification-presence.component';
import { EffectifComponent } from './agentRH/presence/effectif/effectif.component';
import { ConsultRemplacentComponent } from './agentRH/consult-remplacent/consult-remplacent.component';
import { LogoutConfirmDialogComponent } from './athentification/logout-confirm-dialog/logout-confirm-dialog.component';
import { ModifierCompteComponent } from './athentification/modifier-compte/modifier-compte.component';
import {httpInterceptorProviders} from "./_helpers/http.interceptor";
import { CustomPopupComponent } from './components/custom-popup/custom-popup.component';
import { ModifierPasswordComponent } from './athentification/modifier-password/modifier-password.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegistrationComponent,
    AcceuilComponent,
    HorizontalMenuAgentRhComponent,
    VerticalMenuAgentRhComponent,
    HomeRhComponent,
    FooterComponent,
    ImportPointageComponent,
    VerificationPresenceComponent,
    EffectifComponent,
    ConsultRemplacentComponent,
    LogoutConfirmDialogComponent,
    ModifierCompteComponent,
    CustomPopupComponent,
    ModifierPasswordComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    FormsModule,
  ],
  providers: [httpInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
