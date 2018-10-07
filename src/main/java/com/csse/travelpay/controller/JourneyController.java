package com.csse.travelpay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.csse.travelpay.model.Journey;
import com.csse.travelpay.service.JourneyService;

@RestController
@CrossOrigin
@RequestMapping("/journey")
public class JourneyController {
	
	@Autowired
	private JourneyService journeyservice;
	
	//	this will post a journey object to the database
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Journey addJourney(@RequestBody Journey j){
		return journeyservice.addJourney(j);
	}
	
	// this method will return all the journey details related to a customer and his status(onboard or completed)
	@RequestMapping(value="/getall",method=RequestMethod.GET)
	public List<Journey> getJourneyList(@RequestParam(value = "cid", required = false) String cid, @RequestParam(value = "status", required = false) String status){
		return journeyservice.getJourneyList(cid,status);
	}
	
	//this method will return journey details related to the given specific journey id
	@RequestMapping(value="/getbyid",method=RequestMethod.GET)
	public Journey getJourneyById(@RequestParam(value = "jid") String jid){
		return journeyservice.getJourneyById(jid);
	}
	
	//this will return journey details of the customers if they are in onboard status
	@RequestMapping(value="/getonboardcust",method=RequestMethod.GET)
	public Journey getOnboardCust(@RequestParam("cid") String cid){
		return journeyservice.getOnboardCust(cid);
	}

}
