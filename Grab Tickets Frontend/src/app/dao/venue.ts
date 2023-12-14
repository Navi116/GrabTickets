export class Venue {
    constructor(
        public id:number,
        public venuename:string,
        public venuecategory:string,
        public seatcapacity:number,
        public street:string,
        public city:string,
        public state:string,
        public pincode:number,
        public description:string,
        public rent:number,
        public venuedocuments:string,
        public status:boolean,
        public partnerid:number
    ){}
}
