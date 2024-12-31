@all
Feature: Sign out functionality

@smoke
Scenario Outline: User successfully signs out
Given User is on login page
When User enters valid <email> and <password>
And User clicks on the sign out button
Then User should be redirected to the logout page
And User should see a confirmation message "You have been logged off your account. It is now safe to leave the computer."

Examples:
|email                 | password   |
|ErenYeager@gmail.com  | Mikasa@7858 |