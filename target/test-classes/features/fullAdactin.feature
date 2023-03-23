Feature:Adactin page validation

Scenario: End to End Credentials

Given User is on Adactin page
When User enter the username , password and clicks on login
And User enter the location , hotels, room type , number of rooms , adults per room, children per room and clicks on search in the Search Hotel page
And User clicks on select radio button and clicks on continue in the Select Hotel page
And User enter the first name, last name , billing address, credit card no , credit card type, expiry date, cvv number and clicks on book now in the Book A Hotel page
Then User verify the error message