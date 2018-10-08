package com.csse.travelpay.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.csse.travelpay.model.Bus;

@Repository
public interface BusRepository extends MongoRepository<Bus,String> {
	Bus findOneBybusId(String busID);
}
