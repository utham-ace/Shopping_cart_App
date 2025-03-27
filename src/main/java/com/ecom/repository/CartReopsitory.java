package com.ecom.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.model.Cart;

public interface CartReopsitory extends JpaRepository<Cart, Integer> {

	public Cart findByProductIdAndUserId(Integer productId,Integer userId);
	
	public Integer countByUserId(Integer UserId);
	
	public List<Cart> findByUserId(Integer userId);
}
