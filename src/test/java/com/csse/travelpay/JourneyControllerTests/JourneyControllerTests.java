package com.csse.travelpay.JourneyControllerTests;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.csse.travelpay.TravelpayApplicationTests;
import com.csse.travelpay.model.Journey;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JourneyControllerTests extends TravelpayApplicationTests{

	@Autowired
	   WebApplicationContext webApplicationContext;


	    private MockMvc mockMvc;
	    
	    Journey journey = new Journey();
	    private static String journeyId = "100";
		private static String passengerId = "10";
		private static String busId = "AB-1111";
		private static String busroute = "90-A";
		private static String jstatus = "completed";
		private static double jfare = 56;
		
		JSONObject json;
	    
	    @Autowired
	    ObjectMapper objectMapper;
	    
	    @Before
	    public void setup(){
	        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
	                            .build();
	    }
	    
	    
	    @Test
	    public void addAccountTest() throws Exception{
	    	journey.setJourneyId(journeyId);
			journey.setPassengerId(passengerId);
			journey.setBusId(busId);
			journey.setBusroute(busroute);
			journey.setJstatus(jstatus);
			journey.setJfare(jfare);
			  	
			this.mockMvc.perform(post("/journey/add")
			                    .contentType(MediaType.APPLICATION_JSON)
	                            .content(objectMapper.writeValueAsString(journey)))
	                            .andDo(print())
	                            .andExpect(status().isOk())
	                            .andExpect(jsonPath("$.journeyId").value(journey.getJourneyId()))
			                    .andExpect(jsonPath("$.passengerId").value(journey.getPassengerId()))
			                    .andExpect(jsonPath("$.busId").value(journey.getBusId()))
			                    .andExpect(jsonPath("$.busroute").value(journey.getBusroute()))
			                    .andExpect(jsonPath("$.jstatus").value(journey.getJstatus()))
			                    .andExpect(jsonPath("$.jfare").value(journey.getJfare()));
			        
	    }
	    
	    
	    @Test
	    public void getAccountByIdTest() throws Exception{
	    	
	    	journey.setJourneyId(journeyId);
	    	journey.setPassengerId(passengerId);
			journey.setBusId(busId);
			journey.setBusroute(busroute);
			journey.setJstatus(jstatus);
			journey.setJfare(jfare);
			
	        this.mockMvc.perform(get("/journey/getbyid?jid="+journeyId))
	        			.andDo(print())
	                    .andExpect(status().isOk())
	                    .andExpect(content().contentType("application/json;charset=UTF-8"))
	                    .andExpect(jsonPath("$.journeyId").value(journey.getJourneyId()))
	                    .andExpect(jsonPath("$.passengerId").value(journey.getPassengerId()))
	                    .andExpect(jsonPath("$.busId").value(journey.getBusId()))
	                    .andExpect(jsonPath("$.busroute").value(journey.getBusroute()))
	                    .andExpect(jsonPath("$.jstatus").value(journey.getJstatus()))
	                    .andExpect(jsonPath("$.jfare").value(journey.getJfare()));
	    }
	    
	    
	    
	    
	    
}
