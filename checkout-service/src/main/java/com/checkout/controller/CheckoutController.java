package com.checkout.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.checkout.entity.CheckOutDetails;
import com.checkout.entity.ResponseTemplate;
import com.checkout.service.CheckoutService;

@RestController
@RequestMapping("/ecommerce/checkout")
public class CheckoutController {
	
	@Autowired
	private CheckoutService checkoutService;

	@GetMapping("/{userId}")
	public ResponseTemplate checkoutOrder(@PathVariable Integer userId) {
		return checkoutService.checkoutOrder(userId);
	}
	
	@PostMapping("/adddetails")
	public CheckOutDetails saveCheckOutDetails(@RequestBody CheckOutDetails checkOutDetails) {
		return checkoutService.saveCheckOutDetails(checkOutDetails);
	}
}
