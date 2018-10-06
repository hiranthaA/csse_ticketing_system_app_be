package com.csse.travelpay.factory;

import com.csse.travelpay.model.Customer;

public class LocalUser implements User{

	@Override
	public Customer createUser(Customer cust) {
		System.out.println("this is local user createuser");
		Customer temp = new Customer();;
		temp.setFname(cust.getFname());
		temp.setLname(cust.getLname());
		temp.setBalance(cust.getBalance());
		temp.setCustomerType("local");
		temp.setDob(cust.getDob());
		temp.setMobile(cust.getMobile());
		temp.setNic(cust.getNicorpassport());
		temp.setPassword(cust.getPassword());
		temp.setNicorpassport(cust.getNicorpassport());

        System.out.println(temp.getExpDate());
		return temp;
	}

}
