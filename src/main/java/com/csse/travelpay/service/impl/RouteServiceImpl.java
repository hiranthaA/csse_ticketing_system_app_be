package com.csse.travelpay.service.impl;

import com.csse.travelpay.config.MongoConfig;
import com.csse.travelpay.model.BusRoute;
import com.csse.travelpay.model.FareList;
import com.csse.travelpay.model.Journey;
import com.csse.travelpay.repository.FareRepository;
import com.csse.travelpay.repository.JourneyRepository;
import com.csse.travelpay.repository.RouteRepository;
import com.csse.travelpay.service.JourneyService;
import com.csse.travelpay.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteServiceImpl implements RouteService {
	
	@Autowired
	private RouteRepository routeRepo;

	@Autowired
	private FareRepository fareRepo;

	@Override
	public BusRoute addRoute(BusRoute route) {
		return routeRepo.save(route);
	}

	@Override
	public List<BusRoute> getRouteList() {
		return routeRepo.findAll();
	}

	@Override
	public List<BusRoute> getActiveRouteList() {
		return routeRepo.findAllByActiveTrue();
	}

	@Override
	public FareList setFareList(FareList list) {
		return fareRepo.save(list);
	}

	@Override
	public FareList getFareList(FareList list) {
		return fareRepo.findFareListByFareListId(list.getFareListId());
	}

}
