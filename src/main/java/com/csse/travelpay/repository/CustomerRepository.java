package com.csse.travelpay.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.csse.travelpay.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {
	Customer findOneByNicorpassport(String id);

}
