import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Users } from 'src/app/dao/users';
import { UserServiceService } from 'src/app/services/user-service.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
   user:Users;
   id:number;
  
  constructor(private userService:UserServiceService, private router:Router,private activedRoute:ActivatedRoute){}
  ngOnInit(){
    this.id=this.activedRoute.snapshot.params['id'];
    // this.user=new Users(this.id,'','','','','','',new Date(),'');
console.log(this.id)
    this.userService.getUserbyId(this.id).subscribe(
      data =>{ console.log(data) 
      this.user=data
      })
  }
  registerUser(){
    if(this.id==-1){
      console.log("Inside reg");
        console.log("Inside registerUser "+this.user);

      this.userService.registerUser(this.user).subscribe(
        data=>{console.log(data)
          alert("Registration successful")
          this.router.navigate(['login'])
        }
      )
    }else{
      console.log("inside update")
      this.userService.updateUser(this.id,this.user).subscribe(
        data =>{
          console.log(data)
          this.router.navigate([''])
        }
      )
    }
    
    
  }
}
