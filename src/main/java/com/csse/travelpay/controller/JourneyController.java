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
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Journey addJourney(@RequestBody Journey j){
		return journeyservice.addJourney(j);
	}
	
	@RequestMapping(value="/getall",method=RequestMethod.GET)
	public List<Journey> getJourneyList(@RequestParam(value = "cid", required = false) String cid, @RequestParam(value = "status", required = false) String status){
		System.out.println(cid+ " " +status);
		return journeyservice.getJourneyList(cid,status);
	}
	
	@RequestMapping(value="/getonboardcust",method=RequestMethod.GET)
	public Journey getOnboardCust(@RequestParam String cid){
		return journeyservice.getOnboardCust(cid);
	}

}
