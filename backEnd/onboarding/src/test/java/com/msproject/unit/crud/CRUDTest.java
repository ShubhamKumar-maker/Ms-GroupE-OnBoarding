package com.msproject.unit.crud;


import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import com.msproject.dao.OnboardDao;
import com.msproject.model.OnboardeeDetails;
import com.msproject.service.impl.OnboardServiceImpl;
import org.mockito.Mock;
import org.mockito.Mockito;;


@SpringBootTest
class CRUDTest {
  
  @Mock
  OnboardDao onboardDao;
  
  @InjectMocks
  OnboardServiceImpl onboardserviceimpl;
  
  @Test
  void getdataTest() {
    List<OnboardeeDetails> lt=new ArrayList<>();
    OnboardeeDetails onboardeedetails=getMockedObject();
    lt.add(onboardeedetails);
    Mockito.when(onboardDao.fetchall()).thenReturn(lt);
    List<OnboardeeDetails> outputList = onboardserviceimpl.getonboardeelist();
    assertNotNull(outputList);
    
  }
  
  @Test
  public void saveTest()  {
    OnboardeeDetails onboardeedetails = getMockedObject();
     Mockito.when(onboardDao.save(onboardeedetails)).thenReturn(onboardeedetails);
     OnboardeeDetails onboardeedetail = onboardserviceimpl.savedata(onboardeedetails);
     assertEquals(onboardeedetail.getOnboardeeId(),onboardserviceimpl.savedata(onboardeedetails).getOnboardeeId());
  }
  
  @Test
  public void updatedataTest()  {
    OnboardeeDetails onboardeedetails = getMockedObject();
     Mockito.when(onboardDao.update(onboardeedetails,1)).thenReturn(onboardeedetails);
     OnboardeeDetails outputonboardeedetails = onboardserviceimpl.updatedata(onboardeedetails, 1);
     assertEquals( outputonboardeedetails, onboardeedetails);
  }
  
  
  
  
  @Test
  public void deletedataTest()
  {
    Mockito.when(onboardDao.delete(1)).thenReturn(1);
    assertEquals(1,onboardserviceimpl.deletedata(1));
    
  }
  
  
  

  private OnboardeeDetails getMockedObject() {
    OnboardeeDetails onboardeedetail=new OnboardeeDetails(16, "shubham", "shubham@gmail.com", (long)334264497,
        "ranchi", 121, "Banglore", "DS", new Date(2021-05-01), "checked",
        "process", new Date(2021-05-01), "Manager",new Date(2021-05-01),
        new Date(2021-05-01));
    
    return onboardeedetail;
  }
  
  

}
