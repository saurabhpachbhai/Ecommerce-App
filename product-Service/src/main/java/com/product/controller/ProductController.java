package com.product.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.entity.Product;
import com.product.service.ProductService;

@RestController
@RequestMapping("/ecommerce/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/add")
	public Product saveProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
	}

	@GetMapping("/getbyid/{productId}")
	public Product getProductById(@PathVariable Integer productId) {
		return productService.getProductById(productId);
	}

	@GetMapping("/allproducts")
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}
}
