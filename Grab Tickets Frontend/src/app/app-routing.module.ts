import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { WelcomComponent } from './components/welcom/welcom.component';
import { HostComponent } from './components/host/host.component';
import { HostRegisterComponent } from './components/host-register/host-register.component';

import { PartnerRegisterComponent } from './components/partner-register/partner-register.component';
import { LogoutComponent } from './components/logout/logout.component';
import { ShowsComponent } from './components/shows/shows.component';
import { ShowPreviewComponent } from './components/show-preview/show-preview.component';
import { TicketComponent } from './components/ticket/ticket.component';
import { PaymentComponent } from './components/payment/payment.component';
import { UserfirstpageComponent } from './components/userfirstpage/userfirstpage.component';
import { PartnerComponent } from './components/partner/partner.component';
import { VenueRegisterComponent } from './components/venue-register/venue-register.component';
import { RouteguardService } from './services/routeguard.service';

const routes: Routes = [
  {path:'', redirectTo:'login', pathMatch:'full'},
  {path:'login', component:LoginComponent,canActivate:[RouteguardService]},
  {path:'logout', component:LogoutComponent,canActivate:[RouteguardService]},//,canActivate:[RouteguardService]
  {path:'register/:id', component:RegisterComponent,canActivate:[RouteguardService]},
  // {path:'welcome', component:WelcomComponent,canActivate:[RouteguardService]},//,canActivate:[RouteguardService]
  {path:'Host',component:HostComponent,canActivate:[RouteguardService]},
  {path:"hosts/:id",component:HostRegisterComponent,canActivate:[RouteguardService]},
  {path:'partner',component:PartnerComponent,canActivate:[RouteguardService]},
  {path:'partners/:id',component:PartnerRegisterComponent,canActivate:[RouteguardService]},
  {path:'shows', component:ShowsComponent,canActivate:[RouteguardService]},
  {path:'showpreview/:showid',component:ShowPreviewComponent,canActivate:[RouteguardService]},
  {path:'ticket',component:TicketComponent,canActivate:[RouteguardService]},
  {path:'payment',component:PaymentComponent,canActivate:[RouteguardService]},
  // {path:'index',component:UserfirstpageComponent,canActivate:[RouteguardService]},
  {path:'venu',component:VenueRegisterComponent,canActivate:[RouteguardService]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
