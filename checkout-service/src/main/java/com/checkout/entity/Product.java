package com.checkout.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Product {
	private int productId;
	private String productName;
	private Double productPrice;
	private Double productRating;

}