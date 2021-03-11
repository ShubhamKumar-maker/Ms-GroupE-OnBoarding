package com.msproject.service;

import java.util.List;
import java.util.Map;
import com.msproject.model.OnboardeeDetails;

public interface OnboardService {
  
  List<OnboardeeDetails>getonboardeelist();
  OnboardeeDetails savedata(OnboardeeDetails onboardeedetails);
  int deletedata(int id);
  OnboardeeDetails updatedata(OnboardeeDetails onboardeedetails,int id);
  List<Map<String, Object>>groupbyOnboardee(String column);
  
  
}
