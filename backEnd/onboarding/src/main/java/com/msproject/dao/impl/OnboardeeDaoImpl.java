package com.msproject.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import com.msproject.dao.OnboardDao;
import com.msproject.model.OnboardeeDetails;
import com.msproject.onboardeedetails.table.constant.OnboardeeTableConstant;
import com.msproject.query.OnboardQuery;

@Repository
public class OnboardeeDaoImpl implements OnboardDao{
  
  private static Logger logger = LoggerFactory.getLogger(OnboardeeDaoImpl.class);
  
  @Autowired
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
  
  @Autowired
  private JdbcTemplate jdbctemplate;

  @Override
  public List<OnboardeeDetails> fetchall() {
    
    String query=OnboardQuery.FIND_ALL_QUERY;
    logger.info(query);
    
    return jdbctemplate.query(query, (resultSet, rowNum)->{
      OnboardeeDetails onboardeeDetails=new OnboardeeDetails();
      onboardeeDetails.setOnboardeeId(resultSet.getInt(OnboardeeTableConstant.ID));
      onboardeeDetails.setName(resultSet.getString(OnboardeeTableConstant.NAME));
      onboardeeDetails.setContactNumber(resultSet.getLong(OnboardeeTableConstant.PHONE));
      onboardeeDetails.setAddress(resultSet.getString(OnboardeeTableConstant.ADDRESS));
      onboardeeDetails.setEmail(resultSet.getString(OnboardeeTableConstant.EMAIL));
      onboardeeDetails.setLocation(resultSet.getNString(OnboardeeTableConstant.LOCATION));
      onboardeeDetails.setSkills(resultSet.getNString(OnboardeeTableConstant.SKILLS));
      onboardeeDetails.setBGCstatus(resultSet.getNString(OnboardeeTableConstant.BG_STATUS));
      onboardeeDetails.setOnboardingStatus(resultSet.getNString(OnboardeeTableConstant.ONBOARDING_STATUS));
      onboardeeDetails.setMsHiringManager(resultSet.getNString(OnboardeeTableConstant.MS_HIRING_MANAGER));
      onboardeeDetails.setETA(resultSet.getDate(OnboardeeTableConstant.ETA));
      onboardeeDetails.setOnboardingDate(resultSet.getDate(OnboardeeTableConstant.ONBOARDING_DATE));
      onboardeeDetails.setCreationdate(resultSet.getDate(OnboardeeTableConstant.CREATION_DATE));
      onboardeeDetails.setModificationtime(resultSet.getDate(OnboardeeTableConstant.MODIFICATION_TIME));
      onboardeeDetails.setDemandId(resultSet.getInt(OnboardeeTableConstant.DEMAND_ID));
      
      
      return onboardeeDetails;
    });
  }

  @Override
  public OnboardeeDetails save(OnboardeeDetails onboardeedetails) {
    final KeyHolder holder = new GeneratedKeyHolder();
    String sql=OnboardQuery.INSERT_QUERY;
    logger.info(sql);
    MapSqlParameterSource srcMap = new MapSqlParameterSource();
    srcMap.addValue(OnboardeeTableConstant.NAME, onboardeedetails.getName());
    srcMap.addValue(OnboardeeTableConstant.ADDRESS,onboardeedetails.getAddress());
    srcMap.addValue(OnboardeeTableConstant.PHONE,onboardeedetails.getContactNumber());
    srcMap.addValue(OnboardeeTableConstant.EMAIL,onboardeedetails.getEmail());
    srcMap.addValue(OnboardeeTableConstant.LOCATION,onboardeedetails.getLocation());
    srcMap.addValue(OnboardeeTableConstant.SKILLS,onboardeedetails.getSkills());
    srcMap.addValue(OnboardeeTableConstant.BG_STATUS,onboardeedetails.getBGCstatus());
    srcMap.addValue(OnboardeeTableConstant.ONBOARDING_STATUS,onboardeedetails.getOnboardingStatus());
    srcMap.addValue(OnboardeeTableConstant.MS_HIRING_MANAGER,onboardeedetails.getMsHiringManager());
    srcMap.addValue(OnboardeeTableConstant.ETA,onboardeedetails.getETA());
    srcMap.addValue(OnboardeeTableConstant.ONBOARDING_DATE,onboardeedetails.getOnboardingDate());
    srcMap.addValue(OnboardeeTableConstant.CREATION_DATE,onboardeedetails.getCreationdate());
    srcMap.addValue(OnboardeeTableConstant.MODIFICATION_TIME,onboardeedetails.getModificationtime());
    srcMap.addValue(OnboardeeTableConstant.DEMAND_ID,onboardeedetails.getDemandId());
    
    namedParameterJdbcTemplate.update(sql,srcMap,holder, new String[] {OnboardeeTableConstant.ID});
    onboardeedetails.setOnboardeeId(holder.getKey().intValue());
    return onboardeedetails;
  }

  @Override
  public int delete(int id) {
    String query=OnboardQuery.DELETE_QUERY;
    logger.info(query);
    MapSqlParameterSource srcMap = new MapSqlParameterSource();
    srcMap.addValue(OnboardeeTableConstant.ID,id);
    return namedParameterJdbcTemplate.update(query, srcMap);
  }

  @Override
  public OnboardeeDetails update(OnboardeeDetails onboardeedetails, int id) {
    String query=OnboardQuery.UPDATE_QUERY;
    logger.info(query);
    MapSqlParameterSource srcMap = new MapSqlParameterSource();
    srcMap.addValue(OnboardeeTableConstant.ID,id);
    srcMap.addValue(OnboardeeTableConstant.NAME, onboardeedetails.getName());
    srcMap.addValue(OnboardeeTableConstant.ADDRESS,onboardeedetails.getAddress());
    srcMap.addValue(OnboardeeTableConstant.PHONE,onboardeedetails.getContactNumber());
    srcMap.addValue(OnboardeeTableConstant.EMAIL,onboardeedetails.getEmail());
    srcMap.addValue(OnboardeeTableConstant.LOCATION,onboardeedetails.getLocation());
    srcMap.addValue(OnboardeeTableConstant.SKILLS,onboardeedetails.getSkills());
    srcMap.addValue(OnboardeeTableConstant.BG_STATUS,onboardeedetails.getBGCstatus());
    srcMap.addValue(OnboardeeTableConstant.ONBOARDING_STATUS,onboardeedetails.getOnboardingStatus());
    srcMap.addValue(OnboardeeTableConstant.MS_HIRING_MANAGER,onboardeedetails.getMsHiringManager());
    srcMap.addValue(OnboardeeTableConstant.ETA,onboardeedetails.getETA());
    srcMap.addValue(OnboardeeTableConstant.ONBOARDING_DATE,onboardeedetails.getOnboardingDate());
    srcMap.addValue(OnboardeeTableConstant.CREATION_DATE,onboardeedetails.getCreationdate());
    srcMap.addValue(OnboardeeTableConstant.MODIFICATION_TIME,onboardeedetails.getModificationtime());
    srcMap.addValue(OnboardeeTableConstant.DEMAND_ID,onboardeedetails.getDemandId());
    namedParameterJdbcTemplate.update(query, srcMap);
    return onboardeedetails;
  }
  
  public List<Map<String, Object>>groupbydata(String column)
  {
    String query="select count("+OnboardeeTableConstant.ID+") as value ,"+column +" as data from onboardee_details group by "+column;
    List<Map<String, Object>> values = jdbctemplate.queryForList(query);
    return values;
       
  }

}