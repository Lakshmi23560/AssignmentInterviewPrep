
Feature: Login to SalesForce website
@Smoke @Regression
 Scenario: Check login into salesforce application
 
 Given  Open the salesaforce login page
 When   Enter correct username "abcd@sam.com" and password "Shrihan$123"
 Then   Check home page is displayed