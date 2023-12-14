import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class HardCodedAuthenticationService {
  logout() {
    sessionStorage.removeItem("loggedinUser");
  }

  constructor() { }

  // if(username==backuser && pass==backpass){
  //   sessionStorage.setItem("loggedinUser",username);
  //   return true;
  // }else{
  //   return false;
  // }

  isUserLoggedIn(): boolean {
    let user = sessionStorage.getItem("loggedinUser")
    
    return !(user==null);
  }

}


