import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Ticket } from '../dao/ticket';

@Injectable({
  providedIn: 'root'
})
export class TicketService {
  

  constructor(private http:HttpClient) { }

  getBookedTickets() {
    console.log("getting");
   return this.http.get<Ticket[]>(`http://localhost:8080/bookinghistory`);
    }
}
