package com.ecom.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class OrderRequest {

	private String firstName;
	
    private String lastName;
	
	private String email;
	
	private String mobileNo;
	
	private String address;
	
	private String city;
	
	private String state;
	
	private String pincode;
	
	private String paymentType;
	
	@OneToOne(cascade = CascadeType.ALL)
	private OrderAddress orderAddress;

	public String getPaymentType() {
		// TODO Auto-generated method stub
		return null;
	}
}
