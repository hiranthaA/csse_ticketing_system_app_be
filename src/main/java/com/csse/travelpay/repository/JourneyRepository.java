package com.csse.travelpay.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.csse.travelpay.model.Journey;

@Repository
public interface JourneyRepository extends MongoRepository<Journey,String>{
	List<Journey> findAllByPassengerId(String id);
	List<Journey> findAllByJstatus(String status);
	Journey findOneByJourneyId(String id);
}
