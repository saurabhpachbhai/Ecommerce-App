package com.cart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cart.entity.Cart;
import com.cart.entity.CartDetails;
import com.cart.service.CartService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/ecommerce/carts")
public class CartController {

	@Autowired
	private CartService cartService;

	@PostMapping("/add")
	public String saveCart(@RequestBody Cart cart) {
		return cartService.saveCart(cart);
	}

	@GetMapping("cartdetails/{userId}")
	@CircuitBreaker(name = "cartdetailbreaker", fallbackMethod = "cartdetailsfallback")
	public CartDetails getCartDetails(@PathVariable Integer userId) {
		return cartService.getCartDetails(userId);
	}

	public CartDetails cartdetailsfallback(Integer userId, Exception e) {

		CartDetails cartDetails = new CartDetails();
		cartDetails.setProducts(null);
		cartDetails.setUserId(00000);
		return cartDetails;
	}

}
