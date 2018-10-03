package com.csse.travelpay.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.csse.travelpay.config.MongoConfig;
import com.csse.travelpay.model.Bus;
import com.csse.travelpay.repository.BusRepository;
import com.csse.travelpay.service.BusService;
@Service
public class BusServiceImpl implements BusService {
	@Autowired
	private BusRepository busrepo;
	@Override
	public Bus getCurrentLocation(String busId) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(MongoConfig.class);
		MongoOperations mongoOperation =  (MongoOperations) ctx.getBean("mongoTemplate");
		Query query = new Query();
		query.addCriteria(Criteria.where("busId").is(busId));
		return mongoOperation.findOne(query, Bus.class);
	}
	@Override
	public Bus addBus(Bus bus) {
		System.out.println(bus.getBusId());
		return busrepo.save(bus);
	}

}
