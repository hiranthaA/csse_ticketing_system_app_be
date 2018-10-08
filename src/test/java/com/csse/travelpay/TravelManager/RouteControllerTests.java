package com.csse.travelpay.TravelManager;

import com.csse.travelpay.TravelpayApplicationTests;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class RouteControllerTests extends TravelpayApplicationTests {

//    private static int halt1 = 3;
//    private static int halt2 = 8;
//    private static String fare = "30.0";
//
//    @Autowired
//    WebApplicationContext webApplicationContext;
//    @Autowired
//    ObjectMapper objectMapper;
//    private MockMvc mockMvc;
//
//    @Before
//    public void setup() {
//        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
//                .build();
//    }
//
//
//    @Test
//    public void getFareTest() throws Exception {
//
//        this.mockMvc.perform(get("/route/getFare?halt1=" + halt1 + "&halt2=" + halt2))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(content().string(fare));
//    }


}

