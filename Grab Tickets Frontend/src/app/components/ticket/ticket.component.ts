import { Component } from '@angular/core';
import { Ticket } from 'src/app/dao/ticket';
import { TicketService } from 'src/app/services/ticket.service';

@Component({
  selector: 'app-ticket',
  templateUrl: './ticket.component.html',
  styleUrls: ['./ticket.component.css']
})
export class TicketComponent {
  tickets:Ticket[]=[];
  constructor(private ticketService:TicketService){}

  ngOnInit(){
    this.ticketService.getBookedTickets().subscribe(
      reponse=> this.bookingHistory(reponse)
    );
  }
  bookingHistory(reponse) {
   console.log(reponse); 
   this.tickets=reponse;
   }
}
