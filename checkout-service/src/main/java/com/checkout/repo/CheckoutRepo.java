package com.checkout.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.checkout.entity.CheckOutDetails;


public interface CheckoutRepo extends JpaRepository<CheckOutDetails, Integer> {

	CheckOutDetails findByUserId(Integer userId);

}
