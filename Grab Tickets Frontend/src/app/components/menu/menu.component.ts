import { Component, Input, Type, inject } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { NgbActiveModal, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Users } from 'src/app/dao/users';
import { HardCodedAuthenticationService } from 'src/app/services/hard-coded-authentication.service';
import { UserServiceService } from 'src/app/services/user-service.service';


@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent {
  
  
}
