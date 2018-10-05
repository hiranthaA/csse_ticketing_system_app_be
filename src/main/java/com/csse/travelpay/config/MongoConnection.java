package com.csse.travelpay.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

public class MongoConnection {
	
	private static MongoConnection instance;
	private MongoOperations mo;
	
	private MongoConnection() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(MongoConfig.class);
		mo =  (MongoOperations) ctx.getBean("mongoTemplate");
		System.out.println("connection created");
	};
	
	public static MongoConnection getInstance(){
	    if(instance == null){
	        synchronized (MongoConnection.class) {
	            if(instance == null){
	                instance = new MongoConnection();
	            }
	        }
	    }
	    return instance;
	}
	
	public MongoOperations getMongoOperation() {
		return mo;
	}

	
}
