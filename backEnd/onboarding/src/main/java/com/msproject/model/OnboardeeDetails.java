package com.msproject.model;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.sun.istack.NotNull;

//@Entity
public class OnboardeeDetails {
  
//  @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int onboardeeId;
  
//  @Column
//  @NotNull
  private String name;
  
//  @Column
//  @NotNull
  private String email;
  
//  @Column
//  @NotNull
   private Long contactNumber;
  
//  @Column
//  @NotNull
   private String address;
  
//  @Column
//  @NotNull
   private int demandId;
//  
//  @Column
//  @NotNull
   private String location;
  
//  @Column
//  @NotNull
   private String skills;
  
//  @Column
//  @NotNull
   private Date ETA;
  
//  @Column
//  @NotNull
   private String BGCstatus;
  
//  @Column
//  @NotNull
   private String onboardingStatus;
  
//  @Column
   private Date onboardingDate;
  
//  @Column
//  @NotNull
   private String msHiringManager;
  
//  @Column
//  @NotNull
   private Date creationdate;
  
//  @Column
  private Date modificationtime;

  public int getOnboardeeId() {
    return onboardeeId;
  }

  public void setOnboardeeId(int onboardeeId) {
    this.onboardeeId = onboardeeId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Long getContactNumber() {
    return contactNumber;
  }

  public void setContactNumber(Long contactNumber) {
    this.contactNumber = contactNumber;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public int getDemandId() {
    return demandId;
  }

  public void setDemandId(int demandId) {
    this.demandId = demandId;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getSkills() {
    return skills;
  }

  public void setSkills(String skills) {
    this.skills = skills;
  }

  public Date getETA() {
    return ETA;
  }

  public void setETA(Date eTA) {
    ETA = eTA;
  }

  public String getBGCstatus() {
    return BGCstatus;
  }

  public void setBGCstatus(String bGCstatus) {
    BGCstatus = bGCstatus;
  }

  public String getOnboardingStatus() {
    return onboardingStatus;
  }

  public void setOnboardingStatus(String onboardingStatus) {
    this.onboardingStatus = onboardingStatus;
  }

  public Date getOnboardingDate() {
    return onboardingDate;
  }

  public void setOnboardingDate(Date onboardingDate) {
    this.onboardingDate = onboardingDate;
  }

  public String getMsHiringManager() {
    return msHiringManager;
  }

  public void setMsHiringManager(String msHiringManager) {
    this.msHiringManager = msHiringManager;
  }

  public Date getCreationdate() {
    return creationdate;
  }

  public void setCreationdate(Date creationdate) {
    this.creationdate = creationdate;
  }

  public Date getModificationtime() {
    return modificationtime;
  }

  public void setModificationtime(Date modificationtime) {
    this.modificationtime = modificationtime;
  }

  public OnboardeeDetails(int onboardeeId, String name, String email, Long contactNumber,
      String address, int demandId, String location, String skills, Date eTA, String bGCstatus,
      String onboardingStatus, Date onboardingDate, String msHiringManager, Date creationdate,
      Date modificationtime) {
    super();
    this.onboardeeId = onboardeeId;
    this.name = name;
    this.email = email;
    this.contactNumber = contactNumber;
    this.address = address;
    this.demandId = demandId;
    this.location = location;
    this.skills = skills;
    ETA = eTA;
    BGCstatus = bGCstatus;
    this.onboardingStatus = onboardingStatus;
    this.onboardingDate = onboardingDate;
    this.msHiringManager = msHiringManager;
    this.creationdate = creationdate;
    this.modificationtime = modificationtime;
  }

  public OnboardeeDetails() {
    
  }

  @Override
  public String toString() {
    return "OnboardeeDetails [onboardeeId=" + onboardeeId + ", name=" + name + ", email=" + email
        + ", contactNumber=" + contactNumber + ", address=" + address + ", demandId=" + demandId
        + ", location=" + location + ", skills=" + skills + ", ETA=" + ETA + ", BGCstatus="
        + BGCstatus + ", onboardingStatus=" + onboardingStatus + ", onboardingDate="
        + onboardingDate + ", msHiringManager=" + msHiringManager + ", creationdate=" + creationdate
        + ", modificationtime=" + modificationtime + "]";
  }
  
  
   
  

}
