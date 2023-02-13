package com.cart.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.cart.entity.Cart;
import com.cart.entity.CartDetails;
import com.cart.entity.Product;
import com.cart.repository.CartRepository;

@Service
public class CartService {

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private RestTemplate restTemplate;

	public String saveCart(Cart cart) {
		List<Cart> cartList = cartRepository.findByUserId(cart.getUserId());
		String str = new String();
		boolean isAvailable = false;
		if (cartList.size() != 0) {
			for (int i = 0; i < cartList.size(); i++) {
				if (cart.getProductId() == cartList.get(i).getProductId()) {
					isAvailable = true;
				}
			}
		}
		if (isAvailable) {
			str = "This product is already in your cart.";
		} else {
			cartRepository.save(cart);
			str = "Product is added to cart.";
		}
		return str;
	}

	public CartDetails getCartDetails(Integer userId) {
		// TODO Auto-generated method stub
		CartDetails cartDetails = new CartDetails();
		cartDetails.setUserId(userId);

		List<Cart> cartList = cartRepository.findByUserId(userId);

		List<Product> products = new ArrayList<>();
		for (int i = 0; i < cartList.size(); i++) {
			Product product = restTemplate.getForObject(
					"http://PRODUCT-SERVICE/ecommerce/products/getbyid/" + cartList.get(i).getProductId(),
					Product.class);

			products.add(product);
		}
		cartDetails.setProducts(products);

		return cartDetails;
	}

}
