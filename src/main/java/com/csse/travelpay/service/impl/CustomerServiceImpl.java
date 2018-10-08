package com.csse.travelpay.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csse.travelpay.factory.User;
import com.csse.travelpay.factory.UserFactory;
import com.csse.travelpay.model.Customer;
import com.csse.travelpay.repository.CustomerRepository;
import com.csse.travelpay.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository custrepo;

	@Override
	public Customer addCustomer(Customer c) {
		System.out.println("this is addCustomer in Customer Service");
		UserFactory userfactory = new UserFactory();
		User usr = userfactory.getUser(c.getCustomerType());
		return custrepo.save(usr.createUser(c));
		//return usr.createUser(c);
	}

	@Override
	public Customer getUser(String email) {
		// TODO Auto-generated method stub
		return custrepo.findOneByNicorpassport(email);
	}

	@Override
	public Customer getUserdetails(String id) {
		// TODO Auto-generated method stub
		return custrepo.findOneById(id);
	}

	

}
