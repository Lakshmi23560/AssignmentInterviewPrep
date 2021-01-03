Feature: Redfin Application


Scenario Outline: UseCase1
Given the redfin application is launched for "<testName>"
Then verify the home page using "<homePageTitle>"
When enter the "<cityName>" in searchbox and press the enter button
Then validate pop up appears
When On the pop up select the entry "<SelectionFromPopUp>"
Then verify the city Real Estate page using "<estatePageHeader>"
Then assert the Search box on the top left side has "<cityName>"
When Select the min price as "<MinPriceIndex>" and max price as "<MaxPriceIndex>"
Then Verify all the homes listed are from "<searchResult>", if no homes listed throw an errorMessage


Examples:
|testName|homePageTitle|cityName|SelectionFromPopUp|estatePageHeader|MinPriceIndex|MaxPriceIndex|searchResult|
|test1|Real Estate, Homes for Sale, MLS Listings, Agents|Sunnyvale|https://www.redfin.com/city/19457/CA/Sunnyvale|Sunnyvale Homes for Sale|25|3|/CA/Sunnyvale/|
|test2|Real Estate, Homes for Sale, MLS Listings, Agents|Sunnyvale|https://www.redfin.com/neighborhood/338644/TX/Dallas/Sunnyvale|Sunnyvale Homes for Sale|21|4|/TX/Dallas|