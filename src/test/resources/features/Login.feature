@all
Feature: User Login
Registered user should be able to login to access account details

Background:
Given User navigates to login page

@smoke @failed
Scenario Outline: Login with valid credentials
When User enters valid email address <email>
And Enter valid password <password>
And Clicks on login button
Then User should login successfully
Examples:
|email                 |password    |
|ErenYeager@gmail.com  |Mikasa@7858 |
|ErenYeager1@gmail.com |Mikasa@7858 |

@smoke                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     
Scenario: Login with Invalid credentials
When User enters invalid email address "ErenYeager123@gmail.com"
And Enter invalid password "1234"
And Clicks on login button
Then User should get a proper warning message

Scenario: Login with invalid email address and valid password
When User enters invalid email address "ErenYeager123@gmail.com"
And Enter valid password "Mikasa@7858"
And Clicks on login button
Then User should get a proper warning message

Scenario: Login with valid email address and invalid password
When User enters valid email address "ErenYeager@gmail.com"
And Enter invalid password "1234"
And Clicks on login button
Then User should get a proper warning message

@smoke
Scenario: Login without providing any credentials
When User dont enter any credentials
And Clicks on login button
Then User should get a proper warning message

