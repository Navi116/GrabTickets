import { Component } from '@angular/core';
declare var Rozorpay:any;
@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent {
  payNow(){
    const RozorpayOptions={
      description:'Sample Rozorpay demo',
      currency:'INR',
      amount:30000,
      name:'Saikiran ',
      key:'rzp_test_iIK4kpH1i513Sp',
      image:'http://i.imgur.com/FApqk3D.jpeg',
      prefill:{
        name:'Saikiran Pagadala',
        email:'kiranpagadala17@gmail.com',
        phone:'9985498670'
      },
      theme:{
        color:'#f37254'
      },
      modal:{
        ondismiss:()=>{
          console.log('dismissed')
        }
      }
      
    }
    const successCallback=(paymentid:any)=>{
        console.log(paymentid);
    }
    const failureCallback=(e:any)=>{
      console.log(e);
    }
    Rozorpay.open(RozorpayOptions, successCallback,failureCallback)
  
  }
  
  

}
