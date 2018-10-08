package com.csse.travelpay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.csse.travelpay.model.Bus;
import com.csse.travelpay.service.BusService;

@RestController
@CrossOrigin
@RequestMapping("/bus")
public class BusController {

	@Autowired
	private BusService busService;
	
	@RequestMapping(value="/getcurrentlocation",method=RequestMethod.GET)
	public Bus getCurrentLocation(@RequestParam String busId){
		return busService.getCurrentLocation(busId);
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public Bus login(@RequestParam String busId,@RequestParam String password){
		return busService.login(busId, password);
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Bus addBus(@RequestBody Bus bus){
		return busService.addBus(bus);
	}
}
