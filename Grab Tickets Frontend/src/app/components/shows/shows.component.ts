import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Shows } from 'src/app/dao/shows';

import { Ticket } from 'src/app/dao/ticket';
import { ShowsdataService } from 'src/app/services/showsdata.service';

@Component({
  selector: 'app-shows',
  templateUrl: './shows.component.html',
  styleUrls: ['./shows.component.css']
})
export class ShowsComponent {
  shows:Shows[]=[];
  ticket:Ticket;
  seats:number;
  showid:number;
  show:Shows;


constructor(private showsDataService:ShowsdataService,private router:Router){}
ngOnInit(){
  this.showsDataService.retriveRecords().subscribe(
    data=>{
      this.displayshows(data);
    }
  )
}

displayshows(data: Shows[]){
  this.shows=data;
}
passingShow(selectedshow:Shows){
  this.router.navigate(['showpreview',selectedshow.showid]);
}


// bookTickets(show:Shows){

// this.ticket.showname=show.showname;
// this.ticket.user="kiranpagadala17@gmail.com";
// this.ticket.venue=show.venue;
// this.ticket.date=show.showdate;
// this.ticket.time=show.showtimings;
// this.ticket.seats=this.seats; //this we need to intialize with user input using 2way binding
// this.ticket.price=show.costcategory*this.ticket.seats;
// this.ticket.address=show.venue;

// this.router.navigate(['payment', show, this.ticket ]);



// }




}
