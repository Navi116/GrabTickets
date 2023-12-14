import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PartnerHardCodedAuthenticationService {

  constructor() { }

  validateUser(username: string,password:string,backuser:string,backpass:string){

    console.log("In handle login");
    if(username==backuser && password==backpass){
      sessionStorage.setItem("loggedinuser",username);
      return true;
    }else{
      return false;
    }
  }

  isUserLoggedIn(){
    let user =sessionStorage.getItem("loggedinuser");
    return !(user===null);
  }

  logout(){
    sessionStorage.removeItem("loggedinuser");
  }
}
