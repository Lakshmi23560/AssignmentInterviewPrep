Feature: Create an account
@Prod
Scenario: Create an account by clicking on account tab


Given launch and login to Salesforce application 
When  login using username "abcd@sam.com" and password "Shrihan$123"
And   click on accont tab in home page
And   click on new button and enter account name "Marry" 
And   click on save buuton
Then  Account page should displayed with account details