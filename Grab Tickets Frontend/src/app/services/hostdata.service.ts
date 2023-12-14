import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Host } from '../dao/host';

@Injectable({
  providedIn: 'root'
})
export class HostDataService {

  retriveHost(id:number){
    return this.http.get<Host>(`http://localhost:8080/findbyid/$id`);
  }
  constructor(private http:HttpClient) { }

  retriveRecords(){
    console.log("INside retiveRecords");
    return this.http.get<Host[]>(`http://localhost:8080/getAllHosts`);
  }

  deleteHost(id:number)
  {
    return this.http.delete<Host[]>(`http://localhost:8080/deleteById/${id}`);
  }


  createHost(host:Host){
    return this.http.post<Host>(`http://localhost:8080/registerHost`,host);
  }


  updateHost(id:number,host:Host){
    return this.http.put<Host>(`http://localhost:8080/updatehost/${id}`,host);
  }

  getloginDetails(email:string,pass:string){
    return this.http.get<Host>(`http://localhost:8080/loginDetails/${email}/${pass}`);
  }
  checkHostBackEnd(email:string){
    return this.http.get<Host[]>(`http://localhost:8080/checkUserExist/${email}`);
  }

}
