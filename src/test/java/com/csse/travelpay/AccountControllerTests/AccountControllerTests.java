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
import org.mockito.internal.matchers.Contains;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


//@RunWith(SpringRunner.class)
//@ContextConfiguration(classes=Account.class)
//@WebMvcTest(AccountController.class)
public class AccountControllerTests extends TravelpayApplicationTests{
   
    @Autowired
    WebApplicationContext webApplicationContext;

    

    private MockMvc mockMvc;

    Account account = new Account();
    
    private static double amountInitial = 200;
    private static double amountAfterRecharge = 400;
    private static String passenngerId = "941234567v";
    private static String mobile = "0767590028";
    
    JSONObject json;
    
    @Autowired
    ObjectMapper objectMapper;
    

    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                            .build();
    }
    
    /**
     * Created By: Parakrama
     * AccountController,  addAccount
     * Service test for add account
     * @throws Exception
     */
    @Test
    public void addAccountTest() throws Exception{

		account.setPassengerId(passenngerId);
        account.setAccountQuantity(amountInitial);    	
		this.mockMvc.perform(post("/accounts/add")
		                    .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(account)))
                            .andDo(print())
                            .andExpect(status().isOk())
		                    .andExpect(jsonPath("$.passengerId").value(account.getPassengerId()))
		                    .andExpect(jsonPath("$.accountQuantity").value(account.getAccountQuantity()));
		        
    }
   
   /**
    * Created By: Parakrama
    * AccountController, getAccountById
    * Service Test for get all accounts
    * @throws Exception
    */
   @Test
   public void getAccountByIdTest() throws Exception{
        account.setPassengerId(passenngerId );
        account.setAccountQuantity(amountInitial);
        this.mockMvc.perform(get("/accounts/getbyid/?id="+passenngerId)).andDo(print())
                   .andExpect(status().isOk())
                   .andExpect(content().contentType("application/json;charset=UTF-8"))
                   .andExpect(jsonPath("$.passengerId").value(account.getPassengerId()))
                   .andExpect(jsonPath("$.accountQuantity").value(amountInitial));
   }
   
  

   

   /**
     * Created By: Parakrama
     * AccountController, sendMessage
     * Service test for Send Validation SMS
     * @throws Exception
     */
    @Test
    public void sendMessageTest() throws Exception{
        
        account.setPassengerId(passenngerId);
        account.setAccountQuantity(amountInitial);
        account.setPhoneNo(mobile);
        this.mockMvc.perform(post("/accounts/sendSMS")
                     .contentType(MediaType.APPLICATION_JSON)
                     .content(objectMapper.writeValueAsString(account)))
                     .andDo(print())
                     .andExpect(status().isOk())
                     .andExpect(content().contentType("application/json;charset=UTF-8"))
                     .andExpect(jsonPath("$.passengerId").value(passenngerId))
                     .andExpect(jsonPath("$.accountQuantity").value(amountInitial));
    }
 
     /**
     * Created By: Parakrama
     * AccountController, verifyCode
     * For invalid verification
     * Service test for Send Validation SMS
     * @throws Exception
     */
    @Test
    public void verifyCodeTest() throws Exception{
        Account account2 =new Account();
        account.setPassengerId(passenngerId);
        account.setAccountQuantity(amountInitial);
        account.setPhoneNo("0767590028");
        this.mockMvc.perform(post("/accounts/recharge/1234")
                     .contentType(MediaType.APPLICATION_JSON)
                     .content(objectMapper.writeValueAsString(account)))
                     .andDo(print())
                     .andExpect(status().isOk())
                     .andExpect(content().contentType("application/json;charset=UTF-8"))
                     .andExpect(jsonPath("$.passengerId").value("Code Invalid or Passenger non exist"));
                     
    }
    
    /**
     * Created By: Parakrama
     * AccountController, addAccountBalance
     * Service test for adding account amount
     * @throws Exception
     */
   @Test
   public void addAccountAmountTest() throws Exception{
   	
        account.setPassengerId(passenngerId);
        account.setAccountQuantity(amountInitial);
        this.mockMvc.perform(post("/accounts/addAccountBalance")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(account)))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(content().contentType("application/json;charset=UTF-8"))
                    .andExpect(jsonPath("$.passengerId").value(passenngerId))
                    .andExpect(jsonPath("$.accountQuantity").value(amountAfterRecharge));
   }


}


