package com.csse.travelpay.factory;

public class UserFactory {
	public User getUser(String type) {
		User user=null;
		if(type.equals("local")) {
			user = new LocalUser();
		}
		else if(type.equals("foreign")) {
			user = new ForeignUser();
		}
		return user;
	}
}
