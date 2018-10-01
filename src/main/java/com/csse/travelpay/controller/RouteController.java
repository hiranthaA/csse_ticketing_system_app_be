package com.csse.travelpay.controller;

import com.csse.travelpay.model.BusRoute;
import com.csse.travelpay.model.FareList;
import com.csse.travelpay.model.Journey;
import com.csse.travelpay.service.JourneyService;
import com.csse.travelpay.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/route")
public class RouteController {
	
	@Autowired
	private RouteService routeService;
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public BusRoute addRoute(@RequestBody BusRoute route){
		return routeService.addRoute(route);
	}
	
	@RequestMapping(value="/getAll",method=RequestMethod.GET)
	public List<BusRoute> getJourneyList(){
		return routeService.getRouteList();
	}
	
	@RequestMapping(value="/getAllActive",method=RequestMethod.GET)
	public List<BusRoute> getOnboardCust(){
		return routeService.getActiveRouteList();
	}

	@RequestMapping(value="/setFareList",method=RequestMethod.POST)
	public FareList setFareList(@RequestBody FareList list){
		return routeService.setFareList(list);
	}

	@RequestMapping(value="/getFareList",method=RequestMethod.POST)
	public FareList addRoute(@RequestBody FareList list){
		return routeService.getFareList(list);
	}
}
