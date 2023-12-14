import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Partner } from 'src/app/dao/partner';
import { PartnerDataService } from 'src/app/services/partner-data.service';
import { PartnerHardCodedAuthenticationService } from 'src/app/services/partner-hard-coded-authentication.service';

@Component({
  selector: 'app-partner-register',
  templateUrl: './partner-register.component.html',
  styleUrls: ['./partner-register.component.css']
})
export class PartnerRegisterComponent {

partner:Partner;

id:number;
  capacity:number;

  constructor(private router:Router, private partnerDataService:PartnerDataService,private activateRoute:ActivatedRoute ,private partnerhardcodedAuthentication:PartnerHardCodedAuthenticationService){}


ngOnInit(){
  this.id=this.activateRoute.snapshot.params['id'];
  this.partner=new Partner(this.id,'','','','','','','','',this.capacity,'')

  if(this.id!=-1){
    this.partnerDataService.retrivePartner(this.id).subscribe(
      data=>this.partner=data

    );
  }
}

RegisterPartner(){
  console.log("Inside register partner"+this.id)
  if(this.id==-1){
    this.partnerDataService.createPartner(this.partner).subscribe(
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
       alert("Username already exists")
 }
 }
}
