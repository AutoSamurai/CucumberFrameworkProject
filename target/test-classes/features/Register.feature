@all
Feature: User Register

Background:
Given User navigates to Register Account page

@smoke
Scenario: Register with mandatory field
When User enters below details
|firstName      | Itachi                 |
|lastName       | Uchiha                 |
|email          | itachiuchiha13@gmail.com |
|telephone      | 1234567678             |
|password       | Sasuke@123             |
And Selects Privacy Policy field
And Clicks on Continue button
Then Account should get successfully created

@smoke
Scenario: Register with all field
When User enters below details
|firstName      | Itachi                  |
|lastName       | Uchiha                  |
|email          | itachiuchiha14@gmail.com |
|telephone      | 1234567678              |
|password       | Sasuke@123              |
And Selects Yes for Newsletter
And Selects Privacy Policy field
And Clicks on Continue button
Then Account should get successfully created

Scenario: Register with duplicate email address
When User enters below details
|firstName      | Itachi                   |
|lastName       | Uchiha                   |
|email          | itachiuchiha@gmail.com   |
|telephone      | 1234567678               |
|password       | Sasuke@123               |
And Selects Privacy Policy field
And Clicks on Continue button
Then Warning message informing the user about duplicate email address should be displayed

@smoke
Scenario: Register without providing any fields
When User dont enter details into any field
And Clicks on Continue button
Then Warning message should be displayed for the mandatory fields
