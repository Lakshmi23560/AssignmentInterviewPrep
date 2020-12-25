Feature: check manage users dropdown in home page
@Smoke
Scenario: check roles in manage users dropdown

 Given login to saleseforce with username "abcd@sam.com" and password "Shrihan$123"
 When  click on manage users in home page and then click on roles
 And   click on product based sample in downdrop 
 Then  product based sample roles should display