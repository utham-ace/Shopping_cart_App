package com.ecom.service;

import java.util.List;

import com.ecom.model.Cart;

public interface CartService {
	
	public Cart saveCart(Integer productid, Integer userid);
	
	public List<Cart> getCartsByUser(Integer userid);
	
	public Integer getCountCart(Integer userId);

	public void updateQuantity(String sy, Integer cid);

}
