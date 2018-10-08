package com.csse.travelpay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.csse.travelpay.model.Customer;
import com.csse.travelpay.service.CustomerService;

@RestController
@CrossOrigin
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerservice;
	
	//add customer method mapping
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Customer addCustomer(@RequestBody Customer c) {
		return customerservice.addCustomer(c);
	}
	
	//get user mapping
	@RequestMapping(value="/getuser/{email}",method=RequestMethod.GET)
	public Customer getUserById(@PathVariable String email) {
		return customerservice.getUser(email);
	}

}
