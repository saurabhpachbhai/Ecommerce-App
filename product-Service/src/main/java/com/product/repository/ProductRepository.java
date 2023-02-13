package com.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.product.entity.Product;

public interface ProductRepository  extends JpaRepository<Product, Integer>{

	Product findByProductId(Integer productId);

}
