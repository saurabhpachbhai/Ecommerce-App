package com.product.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.product.entity.Product;
import com.product.repository.ProductRepository;
@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	public Product getProductById(Integer productId) {
		// TODO Auto-generated method stub
		return productRepository.findByProductId(productId);
	}

	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

}
