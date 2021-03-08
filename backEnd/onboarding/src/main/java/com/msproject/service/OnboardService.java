package com.msproject.service;

import java.util.List;
import com.msproject.model.OnboardeeDetails;

public interface OnboardService {
  
  List<OnboardeeDetails>getonboardeelist();
  OnboardeeDetails savedata(OnboardeeDetails onboardeedetails);
  int deletedata(int id);
  OnboardeeDetails updatedata(OnboardeeDetails onboardeedetails,int id);
  
  
}
