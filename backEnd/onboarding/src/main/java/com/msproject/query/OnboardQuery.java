package com.msproject.query;

import com.msproject.onboardeedetails.table.constant.OnboardeeTableConstant;

public class OnboardQuery {
  
  private OnboardQuery()
  {
    
  }
  public static final String FIND_ALL_QUERY="select * from "+OnboardeeTableConstant.TABLE_NAME;
  
  
  public static final String INSERT_QUERY= "insert into "+OnboardeeTableConstant.TABLE_NAME+" (name,contact_number,address,email,location,skills,bgcstatus,onboarding_status,ms_hiring_manager,eta,onboarding_date,creationdate,modificationtime,demand_id)"+
      " values(:"+OnboardeeTableConstant.NAME +" , :"+OnboardeeTableConstant.PHONE +", :"+OnboardeeTableConstant.ADDRESS +", :"+OnboardeeTableConstant.EMAIL +", :"+OnboardeeTableConstant.LOCATION +
", :"+OnboardeeTableConstant.SKILLS +", :"+OnboardeeTableConstant.BG_STATUS +", :"+OnboardeeTableConstant.ONBOARDING_STATUS+ ", :"+OnboardeeTableConstant.MS_HIRING_MANAGER+ ", :"+OnboardeeTableConstant.ETA+ ", :"+OnboardeeTableConstant.ONBOARDING_DATE+ ", :"+
  OnboardeeTableConstant.CREATION_DATE+ ", :"+OnboardeeTableConstant.MODIFICATION_TIME+ ", :"+OnboardeeTableConstant.DEMAND_ID +")";

  public static final String DELETE_QUERY="delete from "+OnboardeeTableConstant.TABLE_NAME+" where "+OnboardeeTableConstant.ID+"=:"+OnboardeeTableConstant.ID;

  
  public static final String UPDATE_QUERY="UPDATE "+ OnboardeeTableConstant.TABLE_NAME +" SET "+
      OnboardeeTableConstant.NAME + " =:" + OnboardeeTableConstant.NAME + ","+
      OnboardeeTableConstant.ADDRESS + " =:" + OnboardeeTableConstant.ADDRESS + ","+
      OnboardeeTableConstant.PHONE + " =:" + OnboardeeTableConstant.PHONE + ","+
      OnboardeeTableConstant.EMAIL + " =:" + OnboardeeTableConstant.EMAIL + ","+
      OnboardeeTableConstant.LOCATION + " =:" + OnboardeeTableConstant.LOCATION + ","+
      OnboardeeTableConstant.BG_STATUS + " =:" + OnboardeeTableConstant.BG_STATUS + ","+
      OnboardeeTableConstant.ONBOARDING_STATUS + " =:" + OnboardeeTableConstant.ONBOARDING_STATUS + ","+
      OnboardeeTableConstant.MS_HIRING_MANAGER + " =:" + OnboardeeTableConstant.MS_HIRING_MANAGER + ","+
      OnboardeeTableConstant.ETA + " =:" + OnboardeeTableConstant.ETA + ","+
      OnboardeeTableConstant.ONBOARDING_DATE + " =:" + OnboardeeTableConstant.ONBOARDING_DATE + ","+
      OnboardeeTableConstant.MODIFICATION_TIME + " =:" + OnboardeeTableConstant.MODIFICATION_TIME + ","+
      OnboardeeTableConstant.CREATION_DATE + " =:" + OnboardeeTableConstant.CREATION_DATE + ","+
      OnboardeeTableConstant.DEMAND_ID + " =:" + OnboardeeTableConstant.DEMAND_ID + ","+
      OnboardeeTableConstant.SKILLS + "=:" + OnboardeeTableConstant.SKILLS 

      + " WHERE "
      + OnboardeeTableConstant.ID + " =:" + OnboardeeTableConstant.ID;




}
