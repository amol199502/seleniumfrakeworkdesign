@tag 
Feature:  purchase the roder ecommerce site

Background:
Given i landed on Ecommerce page

@tag2
Scenario Outline: Postivie Test of submit the order

Given logged in with username <name> and password <password>
And i add product "<productname>" to cart
And Checkout "<productname>" and submit the order
Then "THANKYOU FOR THE ORDER." message is displayed on confirmationpage

Examples:
| name                        | password            | productname    |
| chaudhariamol173@gmail.com | Chaudhari@199502   | ZARA COAT 3    |