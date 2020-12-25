Feature: Check the Developer console window
@Prod
Scenario: Select developer console from usermenu dropdown

Given login to salesforce application with username "abcd@sam.com" and password "Shrihan$123"
When  click on usermenu 
And   click on Developer Console option from usermenu dropdown
Then  Developer Console window should display