package com.msproject.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.msproject.model.OnboardeeDetails;
import com.msproject.service.OnboardService;

@RestController
@RequestMapping("Onboarding")

public class Controller {
  
  
  @Autowired
  OnboardService onboardeeservice;
  
  @PostMapping("/onboardee-add")
  public OnboardeeDetails add(@RequestBody OnboardeeDetails onboardeedetails)
  {
    
    return onboardeeservice.savedata(onboardeedetails) ;
  }
  
  
  @GetMapping("/onboardee-list")
  public List<OnboardeeDetails>getAllData()
  {
    return onboardeeservice.getonboardeelist();
  }
  
  @GetMapping("/onboardee-delete/{id}")
  public int delete(@PathVariable int id)
  {
    return onboardeeservice.deletedata(id);
  }
  
  @PutMapping("/onboardee-update/{id}")
  public OnboardeeDetails update(@RequestBody OnboardeeDetails onboardeedetails,@PathVariable int id )
  {
    return onboardeeservice.updatedata(onboardeedetails, id);
  }
  

}
