package com.csse.travelpay.controller;

import com.csse.travelpay.dto.FareListUpdateRequest;
import com.csse.travelpay.model.BusHalt;
import com.csse.travelpay.model.BusRoute;
import com.csse.travelpay.model.FareList;
import com.csse.travelpay.model.Journey;
import com.csse.travelpay.service.JourneyService;
import com.csse.travelpay.service.RouteService;
import com.mongodb.client.result.UpdateResult;
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
	public List<BusRoute> getRoutes(){
		return routeService.getRouteList();
	}
	
	@RequestMapping(value="/getAllActive",method=RequestMethod.GET)
	public List<BusRoute> getAllActiveRoutes(){
		return routeService.getActiveRouteList();
	}

	@RequestMapping(value="/setFareList",method=RequestMethod.POST)
	public FareList setFareList(@RequestBody FareList list){
		return routeService.setFareList(list);
	}

	@RequestMapping(value="/getFareList",method=RequestMethod.POST)
	public FareList getFareList(@RequestBody FareList list){
		return routeService.getFareList(list);
	}

    //update fare list, given min fare and increment percentage
    @RequestMapping(value="/updateFareList",method=RequestMethod.POST)
	public FareList updateFareList(@RequestBody FareListUpdateRequest request){
		return routeService.updateFareList(request);
	}

    // returns a bus route by route number
    @RequestMapping(value="/get",method=RequestMethod.GET)
	public BusRoute getRouteByRouteNumber(@RequestParam String routeId){
		return routeService.getRouteByRouteNumber(routeId);
	}

    // return an bus halt, given route number and halt index
    @RequestMapping(value="/getHalt",method=RequestMethod.GET)
	public BusHalt getRoutes(@RequestParam String routeId, @RequestParam int haltIndex){
		return routeService.getHaltByRouteNumberAndHaltIndex(routeId, haltIndex);
	}

    // calculate fare between two given halts
    @RequestMapping(value="/getFare",method=RequestMethod.GET)
    public double getFare(@RequestParam int halt1, @RequestParam int halt2){
        return routeService.getFare(halt1, halt2);
    }

}
