import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { FormsModule } from '@angular/forms';
import { RegisterComponent } from './components/register/register.component';
import { WelcomComponent } from './components/welcom/welcom.component';
import { LogoutComponent } from './components/logout/logout.component';
import { MenuComponent } from './components/menu/menu.component';
import { HostComponent } from './components/host/host.component';
import { HostRegisterComponent } from './components/host-register/host-register.component';
import { PartnerRegisterComponent } from './components/partner-register/partner-register.component';
import { VenueRegisterComponent } from './components/venue-register/venue-register.component';
import { ShowsComponent } from './components/shows/shows.component';
import { PartnerComponent } from './components/partner/partner.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    WelcomComponent,
    LogoutComponent,
    MenuComponent,
    HostComponent,
    HostRegisterComponent,
    PartnerRegisterComponent,
    VenueRegisterComponent,
    ShowsComponent,
    PartnerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
