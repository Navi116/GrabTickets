import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Shows } from '../dao/shows';

@Injectable({
  providedIn: 'root'
})
export class ShowsdataService {


  constructor(private http:HttpClient) { }

  retriveRecords(){
    return this.http.get<Shows[]>(`http://localhost:8080/getAllShows`);
  }
  getShowById(id:number){
    return this.http.get<Shows>(`http://localhost:8080/getShowById/${id}`);
  }

}
