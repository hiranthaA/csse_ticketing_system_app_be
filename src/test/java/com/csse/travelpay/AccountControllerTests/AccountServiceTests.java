package com.csse.travelpay.AccountControllerTests;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import com.csse.travelpay.TravelpayApplicationTests;
import com.csse.travelpay.controller.AccountController;
import com.csse.travelpay.model.Account;
import com.csse.travelpay.service.AccountService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.util.JSON;

import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Contains;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringRunner.class)
//@ContextConfiguration(classes=Account.class)
@WebMvcTest(value = AccountController.class,secure = false)
public class AccountServiceTests{
   
    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private AccountService accountService;
    
    Account account = new Account();
    String actualPassengerId = "941234567v";
    String expectedPassengerId = "941234567v";
    double actualBalance = 200;
    
    
    @Test
    public void getAccountByPassengerId() throws Exception{
    account.setPassengerId(actualPassengerId);
    account.setAccountQuantity(actualBalance);
    	Mockito.when(
    				accountService.getAccountByPassengerIdOrAccountId(Mockito.anyString(),Mockito.anyString())
    				).thenReturn(account);
    				
    	RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
    			"/accounts/getbyid/?id="+actualPassengerId
    			).accept(MediaType.APPLICATION_JSON);
    	
    	MvcResult result = mockMvc.perform(requestBuilder).andReturn();
    	System.out.println(result.getResponse());
    	String expected = "{passengerId:941234567v,accountQuantity:200}";
    	
    	JSONAssert.assertEquals(expected,result.getResponse().getContentAsString(),false);
    			
    	
    }
    
    
}