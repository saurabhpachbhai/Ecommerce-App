package com.checkout.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.checkout.entity.CartDetails;


@Component
@FeignClient(name = "cartdetailsfeign" , url = "http://localhost:8013/ecommerce/carts/")
public interface CartDetailsProxy {
	
	@GetMapping("cartdetails/{userId}")
	public CartDetails getCartDetails(@PathVariable Integer userId);

}
