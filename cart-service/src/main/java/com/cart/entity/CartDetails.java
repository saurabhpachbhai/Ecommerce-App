package com.cart.entity;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CartDetails {

	private int userId;

	private List<Product> products;

}
