import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Host } from 'src/app/dao/host';
import { HostDataService } from 'src/app/services/hostdata.service';



@Component({
  selector: 'app-host-register',
  templateUrl: './host-register.component.html',
  styleUrls: ['./host-register.component.css']
})
export class HostRegisterComponent {
  host:Host;

  id:number;
 

  constructor(private router:Router, private hostDataService:HostDataService ,private activateRoute:ActivatedRoute){}

  ngOnInit(){
    this.id=this.activateRoute.snapshot.params['id'];
    this.host=new Host(this.id,'','','','','','','','');

    // if(this.id!=-1){
    //   this.hostDataService.retriveHost(this.id).subscribe(
    //     data=>this.host=data
    //   );
    // }
    
  }

  addHost(){
    console.log("Inside Register host"+this.id)

    if(this.id==-1){
      this.hostDataService.createHost(this.host).subscribe(
        data=>{
          console.log(data)
          //this.router.navigate(['hosts'])
        },

        backenderror=>this.errorHandling(backenderror)
      );
    }

    
  }

  errorHandling(banckenderror:any):void{
    console.log("inside error"+banckenderror);
   // console.log(banckenderror.error);
   // console.log(banckenderror.error.message);
    console.log("status="+banckenderror.status);
  
   if(banckenderror.status==400){
        // this.errorMessage="Username already exists"
         alert("email id already exists")
   }
   }

  
}
