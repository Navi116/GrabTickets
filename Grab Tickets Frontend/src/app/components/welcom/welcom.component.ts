import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Users } from 'src/app/dao/users';
import { HardCodedAuthenticationService } from 'src/app/services/hard-coded-authentication.service';
import { UserServiceService } from 'src/app/services/user-service.service';

@Component({
  selector: 'app-welcom',
  templateUrl: './welcom.component.html',
  styleUrls: ['./welcom.component.css']
})
export class WelcomComponent {
  constructor(public hardcodedAuthentication:HardCodedAuthenticationService, private userService:UserServiceService, private router:Router, private activedRoute:ActivatedRoute){}
  
  email:string="";
  loc:string="Location"
  user:Users;
  uid:number;

  ngOnInit(){
    // console.log(`before uid`+ this.activedRoute.snapshot.params['id'])
    this.uid=this.activedRoute.snapshot.params['id'];
  }

  // location
  selectedLabel(label:string){
    this.loc=label;
    console.log(this.loc);
  }

  routeToProfile(){
    console.log("Inside profile");
    this.uid=this.activedRoute.snapshot.params['id'];
    console.log(`uid=${this.uid}`);
    this.router.navigate(['register',this.uid])

    
  }
  
  routeToBooking(){}

  

}
