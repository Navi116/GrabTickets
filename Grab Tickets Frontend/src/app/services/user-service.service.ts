import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Users } from '../dao/users';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {
  
  
  url:string="http://localhost:8080/";

  constructor(private http:HttpClient) { }

  //For login
  checkUser(user:string, pass:string){
    console.log("in check user");
    return this.http.get<Users>(this.url+`checkUserByPass/${user}/${pass}`); 
  }

  getUserbyId(id:number){
    return this.http.get<Users>(this.url+`getUserbyId/${id}`)
  }

  //User registration
  registerUser(user: Users) {
    return this.http.post<Users>(this.url+`addUser`,user);
  }

  //User updation
  updateUser(id: number, user: Users) {
    return this.http.put<Users>(this.url+`updateuser/${id}`,user);
  }
}
