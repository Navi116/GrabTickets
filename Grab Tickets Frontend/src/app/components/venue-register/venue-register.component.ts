import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Venue } from 'src/app/dao/venue';
import { PartnerDataService } from 'src/app/services/partner-data.service';

@Component({
  selector: 'app-venue-register',
  templateUrl: './venue-register.component.html',
  styleUrls: ['./venue-register.component.css']
})
export class VenueRegisterComponent {
  venue:Venue;
  id:number;
  partnerid:number;
  capacity:number;
  zipcode:number;
  rent:number;
  constructor(private router:Router, private partnerDataService:PartnerDataService,private activateRoute:ActivatedRoute ){}


  ngOnInit(){
    this.id=this.activateRoute.snapshot.params['id'];
    this.venue=new Venue(this.id,'','', this.capacity,'','','',this.zipcode,'',this.rent,'',false,this.partnerid)
    
    // if(this.id!=-1){
    //   this.partnerDataService.retriveVenue(this.id).subscribe(
    //     data=>this.venue=data

    //   );
    // }
  }

  RegisterVenue(){
    console.log("Inside register partner"+this.id)
    if(this.id==-1){
      this.partnerDataService.registerVenue(this.venue).subscribe(
        data=>{
          console.log(data)
          //this.router.navigate(['partners'])
        },
        backenderror=>this.errorHandling(backenderror)
      );
    }
  }

  errorHandling(backenderror:any):void{
    console.log("inside error"+backenderror);
  // console.log(banckenderror.error);
  // console.log(banckenderror.error.message);
    console.log("status="+backenderror.status);

  if(backenderror.status==400){
        // this.errorMessage="Username already exists"
        alert("Venue already exists")
  }
  }
}
