Feature: Zoopla Application


Scenario Outline: UseCase1
Given the Zoopla application is launched for "<testName>"
Then verify the home page using "<homePageTitle>"
When enter the "<Location>" in searchbox and press the search button
Then validate list of properties page "<propertiespagetitle>"
When print all the price values in sorted order(descending order) on the console
And select the fifth property on the list of properties
Then verify the property list page with logo,agentname and telephone
When click on the agentname link to get into agents page 
Then Verify the properties listed  belong to the same mentioned "<agentname>" on the agents page.
   


Examples:
|testName|homePageTitle|Location|propertiespagetitle|agentname|
|test1|Zoopla > Search Property to Buy, Rent, House Prices, Estate Agents|London|Property for Sale in London - Buy Properties in London - Zoopla|Panther International Properties|