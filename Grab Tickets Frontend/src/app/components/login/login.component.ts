import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Users } from 'src/app/dao/users';
import { UserServiceService } from 'src/app/services/user-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  user:Users;
  name:string="";
  pass:string="";
  loginuser:boolean;
  backuser:string="";
  backpass:string="";
  visible:boolean = false;
  changeType:boolean=true;
  uid:number;

  togglePassword() {
    this.visible = !this.visible;
    this.changeType = !this.changeType;
  }
  // $scope.togglePassword = function () { $scope.typePassword = !$scope.typePassword; };

  constructor(private router:Router, private userService:UserServiceService ){}

  handleLogin(){
    console.log("Inside handlelogin")
      // if(this.uemail=="Naveen" && this.pass=="Naveen@123"){
      // this.loginuser=true;
      // this.router.navigate(['welcome',this.uemail]);
      // }
    this.userService.checkUser(this.name,this.pass).subscribe(
      data=>this.validUser(data),
      errormsg=>this.invalidUser(errormsg)
    )
  }
  validUser(user:Users){
    // console.log(data)
    if(user!=null){
      this.user=user
      console.log(this.user)
      this.backuser=this.user.email;
      this.backpass=this.user.password;
      sessionStorage.setItem("loggedinUser",this.backuser);
      this.uid=user.id;
     this.loginuser=true;
      this.router.navigate(['shows']);
      console.log(this.loginuser)
    }else{
      alert("Username or Password is incorrect");
    }
  }

  invalidUser(errormsg:any){
    console.log("Invalid user" +errormsg)
    //console.log(todo)
    if(errormsg==null){
      console.log("Invalid user, user not exists, need to register")
    }
  }

  registerUser(){
    this.router.navigate(['register',-1])
  }



}
