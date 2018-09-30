package com.csse.travelpay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

import com.csse.travelpay.config.MongoConfig;

@SpringBootApplication
public class TravelpayApplication {

	public static void main(String[] args) {
		SpringApplication.run(TravelpayApplication.class, args);
	}
}
