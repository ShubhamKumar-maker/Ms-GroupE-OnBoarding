package stepdefination;

import org.junit.Assert;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.java.en.Given;

public class stepdef {
  private RestTemplate restTemplate;
  private HttpHeaders headers;
  private String addURI;
  private ResponseEntity<Object> response;
  private Object responseBodyGET;
  private String responseBody;
  
  @When("I Set request HEADER")
  public void i_set_request_header() {
      this.headers=new HttpHeaders();
  }

  @When("Send GET HTTP request")
  public void send_get_http_request() {
    this.restTemplate=new RestTemplate();
    
    this.response=this.restTemplate.getForEntity(addURI, null, headers);
  }

  @Then("I receive valid HTTP response code")
  public void i_receive_valid_http_response_code() {
    this.responseBodyGET=response.getBody();
    Assert.assertTrue(response.getStatusCode()==HttpStatus.OK);
  }
  
  

}
