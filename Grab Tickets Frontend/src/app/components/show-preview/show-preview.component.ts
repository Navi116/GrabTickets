import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Shows } from 'src/app/dao/shows';
import { Ticket } from 'src/app/dao/ticket';

import { ShowsdataService } from 'src/app/services/showsdata.service';

@Component({
  selector: 'app-show-preview',
  templateUrl: './show-preview.component.html',
  styleUrls: ['./show-preview.component.css']
})
export class ShowPreviewComponent {
  ticket:Ticket;
  show:Shows;
  
  id:number;
  
  constructor(private activatedRoute:ActivatedRoute,private showsdata:ShowsdataService){}

  ngOnInit(){
    this.id=this.activatedRoute.snapshot.params['showid'];
    console.log(this.id);
    this.showsdata.getShowById(this.id).subscribe(
      data=>{ console.log(data);
        this.show=data
      }
    );
    
  }

  tickeDetails(){
    console.log(this.show)
  }

}
