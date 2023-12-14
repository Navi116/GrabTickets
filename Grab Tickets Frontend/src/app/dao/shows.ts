import { Time } from "@angular/common";

export class Shows {
    constructor(
        public showid:number,
        public showcategory:string,
        public showname:string,
        public showdate:Date,
        public showtimings:Time,
        public costcategory:number,
        public availableseats:number,
        public seatcapacity:number,
        public showimagepath:string,
        public venue:any
 
     ){}
 
}
