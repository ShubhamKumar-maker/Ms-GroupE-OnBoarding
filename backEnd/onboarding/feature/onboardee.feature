Feature: Onboarding flow 
 
Scenario: Get Onboard record
    
    Given I Set GET onboarding service api endpoint
    When I Set request HEADER
    And Send GET HTTP request
    Then I receive valid HTTP response code

    Scenario: WITH ALL REQUIRED FIELDS IS SUCCESSFUL
  

      		Given user wants to create an Onboardee-details with the following attributes
     	        | onboardeeID  | name   | address  | constactNumber  | email            | location    | BGCstatus | msHiringManager | skills | demandId | onboardingStatus | ETA        |
      		    | 20           | Rachel | Ranchi   | 9334264497      | rachel@gmail.com | Banglore    | confirm   | Ashok kumar     | Java   | 255	    | confirm          | 2021-03-11 |
		When user saves the new Onboardee-details'WITH ALL REQUIRED FIELDS'
    		Then the save 'IS SUCCESSFUL'