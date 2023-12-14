import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot } from '@angular/router';
import { HardCodedAuthenticationService } from './hard-coded-authentication.service';

@Injectable({
  providedIn: 'root'
})
export class RouteguardService implements CanActivate{

  constructor(private  hardcodedAuthenticationService:HardCodedAuthenticationService,public router:Router) { }
  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot){
    if(this.hardcodedAuthenticationService.isUserLoggedIn())
   {
    return true;
   } 
   else{
     this.router.navigate(['login']);
    return false;
   }

  }
}
