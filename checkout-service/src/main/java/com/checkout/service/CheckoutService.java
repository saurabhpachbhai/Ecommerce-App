package com.checkout.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.checkout.entity.CartDetails;
import com.checkout.entity.CheckOutDetails;
import com.checkout.entity.ResponseTemplate;
import com.checkout.repo.CheckoutRepo;

@Service
public class CheckoutService {
	
	@Autowired
	private CartDetailsProxy cartDetailsProxy;
	
	@Autowired
	private ResponseTemplate responseTemplate;
	
	@Autowired
	private CheckoutRepo checkoutRepo;
	
	public ResponseTemplate checkoutOrder(Integer userId) {

		
		CartDetails cartDetails = cartDetailsProxy.getCartDetails(userId);
		CheckOutDetails checkOutDetails = checkoutRepo.findByUserId(userId);
		
		double amount =0;;
		for(int i=0;i<cartDetails.getProducts().size();i++) {
			amount = amount+ cartDetails.getProducts().get(i).getProductPrice();
		}
		
		String str1 = "Check order details and make payment of ruppes "+ amount;
		
		
		responseTemplate.setCartDetails(cartDetails);
		responseTemplate.setStr(str1);	
		responseTemplate.setContactNo(checkOutDetails.getContactNo());
		responseTemplate.setAddress(checkOutDetails.getAddress());
		
		return responseTemplate;
	}

	public CheckOutDetails saveCheckOutDetails(CheckOutDetails checkOutDetails) {
		// TODO Auto-generated method stub
		return checkoutRepo.save(checkOutDetails);
	}

}
