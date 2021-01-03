
Feature: Rest country API

  Scenario Outline: Verify the capital city by using user input code or name
    Given Set service endpoint
    When set header and get method with parameter "<alpha3Code>"
    Then validate the status code 
    And check the capital name "<capitalname>" belong to that country code.

  Examples: 
      |alpha3Code|capitalname  |
      | IND      |New Delhi    |
      | AUS      |Canberra     |
  
 Scenario Outline: Verify the capital city by using incorrect code 
    Given Set service endpoint
    When set header and get method with invalid parameter "<alpha3Code>"
    Then validate the status code with invalid code
   
  Examples: 
      |alpha3Code|
      | INR      |
     