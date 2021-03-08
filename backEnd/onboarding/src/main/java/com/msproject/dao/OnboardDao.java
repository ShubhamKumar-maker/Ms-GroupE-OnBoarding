package com.msproject.dao;

import java.util.List;
import com.msproject.model.OnboardeeDetails;

public interface OnboardDao {
  List<OnboardeeDetails>fetchall();
  OnboardeeDetails save(OnboardeeDetails onboardeedetails);
  int delete(int id);
  OnboardeeDetails update(OnboardeeDetails onboardeedetails,int id);

}
