package com.csse.travelpay.service;

import java.util.List;

import com.csse.travelpay.model.Journey;

public interface JourneyService {
	
	Journey addJourney(Journey j);
	List<Journey> getJourneyList(String cid,String status);
	Journey getOnboardCust(String cid);
	Journey getJourneyById(String jid);
}
