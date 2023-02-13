package com.checkout.entity;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Component
public class ResponseTemplate {
	
	private String str;
	private long contactNo;
	private String address;
	private CartDetails cartDetails;

	
}
