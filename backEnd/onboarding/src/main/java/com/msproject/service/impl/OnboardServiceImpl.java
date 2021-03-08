package com.msproject.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.msproject.dao.OnboardDao;
import com.msproject.model.OnboardeeDetails;
import com.msproject.service.OnboardService;

@Service
public class OnboardServiceImpl implements OnboardService {
  
  @Autowired
  OnboardDao onboarddao;

  @Override
  public List<OnboardeeDetails> getonboardeelist() {
    
    return onboarddao.fetchall();
  }

  @Override
  public OnboardeeDetails savedata(OnboardeeDetails onboardeedetails) {
    return onboarddao.save(onboardeedetails);
  }

  @Override
  public int deletedata(int id) {
    return onboarddao.delete(id);
  }

  @Override
  public OnboardeeDetails updatedata(OnboardeeDetails onboardeedetails, int id) {
    return onboarddao.update(onboardeedetails, id);
  }

}
