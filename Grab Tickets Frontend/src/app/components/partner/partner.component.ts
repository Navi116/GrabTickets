import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Partner } from 'src/app/dao/partner';

import { PartnerDataService } from 'src/app/services/partner-data.service';
import { PartnerHardCodedAuthenticationService } from 'src/app/services/partner-hard-coded-authentication.service';


@Component({
  selector: 'app-partner',
  templateUrl: './partner.component.html',
  styleUrls: ['./partner.component.css']
})
export class PartnerComponent {
  email1="";
  password1="";
  loginemail=false;
  partner:Partner;
partners:Partner[]=[];

  

  constructor(private router:Router, private partnerDataService:PartnerDataService,private activateRoute:ActivatedRoute ){}



  handleLogin(){
    console.log("Inside handlelogin")
      // if(this.uemail=="Naveen" && this.pass=="Naveen@123"){
      // this.loginuser=true;
      // this.router.navigate(['welcome',this.uemail]);
      // }
    this.partnerDataService.checkPartnerBackEnd(this.email1).subscribe(
      data=>{//this.validUser(data),
        sessionStorage.setItem("loggedinuser",this.email1)
      this.router.navigate(['welcom',this.email1])

      this.loginemail=false;
      },
      backenderror=>this.errorHandling(backenderror)
    );
  }

  errorHandling(backenderror:any):void{
    console.log("inside error"+backenderror);
    //
    //
    console.log("status="+backenderror.status);

    if(backenderror.status==400){
      alert("Not exists Please Register")
    }
  }

  createPartner(){
    this.router.navigate(['partners',-1])
  }
  
  }



