Feature: Logout the application
@Smoke
 Scenario: Login the application and logout
 
 Given Login into salesforce application
 When  Enter username "abcd@sam.com" and password "Shrihan$123" click on login button
 And   In home page click on usermenu and click on logout
 Then  Salesforce login page should display.