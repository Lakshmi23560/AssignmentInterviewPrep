
Feature: Create new contact
#Background:

@Regression  
Scenario:  Create new contact in contacts page
  Given  Launch the salesforce application
  When   login using username "abcd@sam.com" and password "Shrihan$123"
  And    click on contacts tab in home page
  And    Click on New button
  And    Enter lastname "Rosy" in lastname field and accountname "Marry" in accountname field
  And    Click on save button
  Then   New contact should be created
   
#Scenario: Check recently created contact 
  #And  check recently created from dropdown list
  #Then  Recently created contact page should be displayed