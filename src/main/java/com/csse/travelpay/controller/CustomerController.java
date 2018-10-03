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
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Customer addCustomer(@RequestBody Customer c) {
		return customerservice.addCustomer(c);
	}
	
	@RequestMapping(value="/getuser/{id}",method=RequestMethod.GET)
	public Customer getUserById(@PathVariable String id) {
		return customerservice.getUser(id);
	}

}
