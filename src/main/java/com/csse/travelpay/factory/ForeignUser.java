package com.csse.travelpay.factory;

import java.util.Calendar;
import java.util.Date;

import com.csse.travelpay.model.Customer;

public class ForeignUser implements User{

	@Override
	public Customer createUser(Customer cust) {
		System.out.println("this is foreign user createuser");
		Customer temp = new Customer();;
		temp.setFname(cust.getFname());
		temp.setLname(cust.getLname());
		temp.setCustomerType("foreign");
		temp.setDob(cust.getDob());
		temp.setMobile(cust.getMobile());
		temp.setPassport(cust.getNicorpassport());
		temp.setPassword(cust.getPassword());
		temp.setNicorpassport(cust.getNicorpassport());
		
		Date currentDate = new Date();
		Calendar c = Calendar.getInstance();
        c.setTime(currentDate);
        c.add(Calendar.DATE, 6);
        Date expdate = c.getTime();
        temp.setExpDate(expdate);
        System.out.println(temp.getExpDate());
		return temp;
	}

}
