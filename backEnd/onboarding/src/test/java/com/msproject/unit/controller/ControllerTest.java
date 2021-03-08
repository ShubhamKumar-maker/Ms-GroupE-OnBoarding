package com.msproject.unit.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.msproject.dao.OnboardDao;
import com.msproject.model.OnboardeeDetails;
import com.msproject.service.OnboardService;

@SpringBootTest
@AutoConfigureMockMvc
class ControllerTest {
  

  
  @Autowired
   OnboardService onboardservice;
  
  @Autowired 
   MockMvc mvc;
  
  @Mock
  OnboardDao onboardDao;
  
  

  @Test
  void getDataTest() throws Exception {
    List<OnboardeeDetails> lt =new ArrayList<OnboardeeDetails>();
    OnboardeeDetails onboardeedetails=getMockedObject();
    lt.add(onboardeedetails);
    Mockito.when(onboardDao.fetchall()).thenReturn(lt);
    MvcResult result=mvc.perform(MockMvcRequestBuilders.get("/Onboarding/onboardee-list").accept(MediaType.APPLICATION_JSON)).andReturn();
    MockHttpServletResponse response = result.getResponse();
    assertEquals(HttpStatus.OK.value(), response.getStatus());
    
  }
   
  
  
  private OnboardeeDetails getMockedObject() {
    OnboardeeDetails onboardeedetail=new OnboardeeDetails(16, "shubham", "shubham@gmail.com", (long)334264497,
        "ranchi", 121, "Banglore", "DS", new Date(2021-05-01), "checked",
        "process", new Date(2021-05-01), "Manager",new Date(2021-05-01),
        new Date(2021-05-01));
    
    return onboardeedetail;
  }

}
