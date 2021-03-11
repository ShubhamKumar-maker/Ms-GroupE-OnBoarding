package stepdefination;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Assert;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.And;

public class stepdefi {
  private RestTemplate restTemplate;
  private HttpHeaders headers;
  private String addURI;
  private ResponseEntity<Object> response;
  private Object responseBodyGET;
  private String responseBody;
  

  @Given("I Set GET onboarding service api endpoint")
  public void i_set_get_onboarding_service_api_endpoint() {
    addURI = "http://localhost:8900/Onboarding/onboardee-list";
  }

  @When("I Set request HEADER")
  public void i_set_request_header() {
    headers = new HttpHeaders();
  }

  @When("Send GET HTTP request")
  public void send_get_http_request() {
    this.restTemplate=new RestTemplate();
    
    this.response=this.restTemplate.getForEntity(addURI, null, headers);
  }

  @Then("I receive valid HTTP response code")
  public void i_receive_valid_http_response_code() {
    this.responseBodyGET=response.getBody();
    // this.responseBody=this.response.getBody().toString();
     //System.out.println(responseBody);
     assertEquals(response.getStatusCode(), HttpStatus.OK);
  }
  
  

 
}
