package com.edu.eventbooking.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.eventbooking.dao.Booking;
import com.edu.eventbooking.dao.PaymentRequest;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	@PostMapping("/process")
	public  ResponseEntity<String> processPayment(@RequestBody PaymentRequest paymentRequest) {
		boolean paymentSuccess = simulatePaymentProcessing(paymentRequest);
		System.out.println("in payment");
		if (paymentSuccess) {
			return ResponseEntity.ok("Payment successful");
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Payment failed");
		}
	}

	private boolean simulatePaymentProcessing(PaymentRequest paymentRequest) {
		return true;
	}
}


//@PostMapping("/buyTicket")
//public Booking buyTicket(@RequestBody Booking book) {
//	PaymentRequest paymentRequest = new PaymentRequest();
//    paymentRequest.setCardNumber("1234567812345678"); // You should get this from 'book' or user input
//    
//    // Set other payment details
//    
//    
//	ResponseEntity<String> s=paymentController.processPayment(paymentRequest);
//	if(s.toString().contains("Payment successful")) {
//		System.out.println("Payment successful");
//
//		return bookingservice.buyTicket(book);
//	}
//	else {
//		return null;
//	}
//}