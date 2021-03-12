package com.msproject.unit.controller;


import org.springframework.test.context.ContextConfiguration;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.msproject.dao.OnboardDao;
import com.msproject.model.OnboardeeDetails;
import com.msproject.service.OnboardService;
import io.cucumber.messages.internal.com.google.gson.Gson;

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
   
  @Test
  void setDataTest() throws Exception {
    OnboardeeDetails onboardeedetails=getMockedObject1();
    String cntnt=getMockedObject1().toString();  
    Gson g = new Gson();
    String jsondata=g.toJson(onboardeedetails);
    
    Mockito.when(onboardDao.save(getMockedObject1())).thenReturn(onboardeedetails);
    MvcResult result = mvc.perform(MockMvcRequestBuilders.post("/Onboarding/onboardee-add").accept(MediaType.APPLICATION_JSON).content(jsondata).contentType(MediaType.APPLICATION_JSON)).andReturn();
    MockHttpServletResponse response = result.getResponse();
    assertEquals(HttpStatus.OK.value(), response.getStatus());
    System.out.println(result.getResponse().getStatus());
    System.out.println(HttpStatus.CREATED.value());
  }
  
  @Test
  void updateTest() throws Exception
  {
    
    OnboardeeDetails onboardeedetails=getMockedObject1();
    String cntnt=getMockedObject1().toString();  
    Gson g = new Gson();
    String jsondata=g.toJson(updateMockedObject());
    
    Mockito.when(onboardDao.update(onboardeedetails, 16)).thenReturn(updateMockedObject());
    MvcResult result = mvc.perform(MockMvcRequestBuilders.put("/Onboarding/onboardee-update/{id}",16).accept(MediaType.APPLICATION_JSON).content(jsondata).contentType(MediaType.APPLICATION_JSON)).andReturn();
    MockHttpServletResponse response = result.getResponse();
    assertEquals(HttpStatus.OK.value(), response.getStatus());
    System.out.println(result.getResponse().getStatus());
    System.out.println(HttpStatus.CREATED.value());
    
  }
  
  
  @Test
  void groupdata() throws Exception
  {
    List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
    Map<String, Object> map1 = new HashMap<String, Object>();
    Map<String, Object> map2 = new HashMap<String, Object>();
    Map<String, Object> map3 = new HashMap<String, Object>();
    Map<String, Object> map4 = new HashMap<String, Object>();
    Map<String, Object> map5 = new HashMap<String, Object>();
    Map<String, Object> map6 = new HashMap<String, Object>();
    map1.put("good",8);
    map2.put("c++",1);
    map3.put("skills",3);
    map4.put("java",2);
    map5.put("java ",2);
    map6.put("ds",1);
    
    list.add(map1);
    list.add(map2);
    list.add(map3);
    list.add(map4);
    list.add(map5);
    list.add(map6);
    
    
    Mockito.when(onboardDao.groupbydata("skills")).thenReturn(list);
    MvcResult result=mvc.perform(MockMvcRequestBuilders.get("/Onboarding/onboardee-group/{column}","skills").accept(MediaType.APPLICATION_JSON)).andReturn();
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
  private OnboardeeDetails getMockedObject1() {
    OnboardeeDetails onboardeedetail=new OnboardeeDetails(16, "shubham", "shubham@gmail.com", (long)334264497,
        "ranchi", 121, "Banglore", "DS", new Date(2021-05-01), "checked",
        "process", null, "Manager",null,
        null);    
    return onboardeedetail;
  }
  private OnboardeeDetails updateMockedObject() {
    OnboardeeDetails onboardeedetail=new OnboardeeDetails(16, "shubham", "shubham@gmail.com", (long)334264497,
        "DELHI", 121, "Banglore", "DS", new Date(2021-05-01), "checked",
        "process", null, "Manager",null,
        null);    
    return onboardeedetail;
  }

}
