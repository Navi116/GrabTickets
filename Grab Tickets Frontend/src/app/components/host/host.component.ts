import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Host } from 'src/app/dao/host';
import { HostDataService } from 'src/app/services/hostdata.service';





@Component({
  selector: 'app-host',
  templateUrl: './host.component.html',
  styleUrls: ['./host.component.css']
})
export class HostComponent {

  
  email1="";
  password1="";
  loginemail=false;
  host:Host;
hosts:Host[]=[];
 
 

  constructor(private router:Router, private hostDataService:HostDataService){}

  

 
  handleLogin(){
    console.log("Inside handlelogin")
      
    this.hostDataService.checkHostBackEnd(this.email1).subscribe(
      data=>{
      sessionStorage.setItem("loginemail",this.email1)
      // this.loginemail=true;
      this.router.navigate(['welcom',this.email1])

      

      
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

  createHost(){
    this.router.navigate(['hosts',-1])
    }
  
  
}
