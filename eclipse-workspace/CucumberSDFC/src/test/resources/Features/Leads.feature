@Regression
Feature: Check the leads tab link
Background:
Given  Launch the salesforce application
When   Login using correct username "abcd@sam.com" and password "Shrihan$123"
And    click on Leads tab in home page

  Scenario: check the leads tab
    Then   Leads page should displayed
  
  Scenario: Validate view dropdown list contents
     And  click on viewdropdown
     Then View dropdown list should display