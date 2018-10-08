package com.csse.travelpay.customercontroller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.csse.travelpay.TravelpayApplicationTests;
import com.csse.travelpay.model.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


public class CustomerControllerTest extends TravelpayApplicationTests{
   
//    @Autowired
//   WebApplicationContext webApplicationContext;
//
//
//    private MockMvc mockMvc;
//
//    Customer cust = new Customer();
//
//    private static String nicorpassport = ("1234");
//    private static String customerType = "foreign";
//    
//    JSONObject json;
//    
//    @Autowired
//    ObjectMapper objectMapper;
//    
//
//    @Before
//    public void setup(){
//        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
//                            .build();
//    }
//
//   @Test
//    public void addCustomerTest() throws Exception{
//
//		cust.setNicorpassport(nicorpassport);
//        cust.setCustomerType(customerType);  
//        
//		this.mockMvc.perform(post("/customer/add")
//		                    .contentType(MediaType.APPLICATION_JSON)
//                            .content(objectMapper.writeValueAsString(cust)))
//                            .andDo(print())
//                            .andExpect(status().isOk())
//		                    .andExpect(jsonPath("$.nicorpassport").value(cust.getNicorpassport()))
//		                    .andExpect(jsonPath("$.customerType").value(cust.getCustomerType()));
//		                    
//		        
//    }
//   
//
//   @Test
//   public void getCustomerByIdNicorPassport() throws Exception{
//        cust.setCustomerType(customerType);
//        cust.setNicorpassport(nicorpassport);
//        this.mockMvc.perform(get("/customer/getuser/"+nicorpassport))
//        			.andDo(print())
//                   .andExpect(status().isOk())
//                   .andExpect(content().contentType("application/json;charset=UTF-8"))
//                   .andExpect(jsonPath("$.nicorpassport").value(cust.getNicorpassport()))
//                   .andExpect(jsonPath("$.customerType").value(cust.getCustomerType()));
//   }


}


