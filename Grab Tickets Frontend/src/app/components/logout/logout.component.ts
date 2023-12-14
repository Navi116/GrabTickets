import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { HardCodedAuthenticationService } from 'src/app/services/hard-coded-authentication.service';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent {
  constructor(public hardcodedAuthentication:HardCodedAuthenticationService, private router:Router){}
  ngOnInit(): void {
      this.hardcodedAuthentication.logout();
      
      //this.router.navigate(['']);
  }

}
