package com.csse.travelpay.service;

import com.csse.travelpay.model.Customer;

public interface CustomerService {
	
	Customer addCustomer(Customer c);

	Customer getUser(String email);

	Customer getUserdetails(String id);

}
