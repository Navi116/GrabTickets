

import { Venue } from '../dao/venue';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Partner } from '../dao/partner';

@Injectable({
  providedIn: 'root'
})
export class PartnerDataService {

  url:string="http://localhost:8080/";  

  retrivePartner(pid:number){
    return this.http.get<Partner>(`http://localhost:8080/findbyid1/${pid}`);
  }

  constructor(private http:HttpClient) { }

  retriveRecords(){
    return this.http.get<Partner[]>(`http://localhost:8080/getAllPartners`);
  }

  createPartner(partner:Partner){
    return this.http.post<Partner>(`http://localhost:8080/registerPartner`,partner);
  }

  getloginDetails(email:string,pass:string){
    return this.http.get<Partner>(`http://localhost:8080/loginDetails1/${email}/${pass}`);
  }

  checkPartnerBackEnd(email:string){
    return this.http.get<Partner>(`http://localhost:8080/checkUserExists/${email}`);
  }

  // Venue methods
registerVenue(venue: Venue) {
  return this.http.post<Venue>(this.url+`registerVenue`,venue);
}
}
