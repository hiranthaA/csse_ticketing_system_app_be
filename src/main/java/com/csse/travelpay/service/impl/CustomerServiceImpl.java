package com.csse.travelpay.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csse.travelpay.model.Customer;
import com.csse.travelpay.repository.CustomerRepository;
import com.csse.travelpay.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository custrepo;

	@Override
	public Customer addCustomer(Customer c) {
		return custrepo.save(c);
	}

	@Override
	public Customer getUser(String id) {
		// TODO Auto-generated method stub
		return custrepo.findOneByNicorpassport(id);
	}

	

}
