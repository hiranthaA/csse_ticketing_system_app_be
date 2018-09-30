package com.csse.travelpay.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.csse.travelpay.config.MongoConfig;
import com.csse.travelpay.model.Journey;
import com.csse.travelpay.repository.JourneyRepository;
import com.csse.travelpay.service.JourneyService;

@Service
public class JourneyServiceImpl implements JourneyService{
	
	@Autowired
	private JourneyRepository journeyrepo;

	@Override
	public Journey addJourney(Journey j) {
		return journeyrepo.save(j);
	}

	@Override
	public List<Journey> getJourneyList(String cid, String status) {
		if(cid==null && status==null) {
			return journeyrepo.findAll();
		}
		else {
			if(cid!=null && status!=null) {
				//journey list of specific customer with given status
				System.out.println(cid+ " " +status);
				ApplicationContext ctx = new AnnotationConfigApplicationContext(MongoConfig.class);
				MongoOperations mongoOperation =  (MongoOperations) ctx.getBean("mongoTemplate");
				Query query = new Query();
				query.addCriteria(Criteria.where("passengerId").is(cid).and("jstatus").is(status));
				return mongoOperation.find(query, Journey.class);
			}
			else if(cid!=null){
				//journey list of specific customer
				System.out.println(cid+ " " +status);
				return journeyrepo.findAllByPassengerId(cid);
			}
			else if(status!=null){
				//journey list of given status 
				System.out.println(cid+ " " +status);
				return journeyrepo.findAllByJstatus(status);
			}
			else {
				return null;
			}
		}
	}

}
