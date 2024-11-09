Feature: Login functionality

Scenario: Login with valid credentials
Given User  navigates to login page
When User has entered valid email address "sidharathsingh931@gmail.com" into the email field
And User has entered valid password "Pitu@1234" into the password field
And User clicks on Login Button
Then User should get successfully logged in


Scenario: Login with invalid credentials
Given    User navigates to login page
When User enters invalid email address "sidharathsingh556566555@gmail.com" into the email field
And User enters invalid password "1255454666566625666" into the password field
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch


Scenario: Login with valid email and invalid password
Given   User navigates to login page
When User has entered valid email address "sidharathsingh931@gmail.com" into the email field
And User enters invaild password "144655265555" into the password field
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch


Scenario: Login with invalid email and valid password 
Given  User navigates to login page
When User has entered invalid email address "sidharathsingh93185455555555@gmail.com" into the email field
And User has entered valid password "Pitu@1234" into the password field
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch

Scenario: Login without providing any credentials
Given  User navigates to login page
When User do not enters email address into email field
And User do not enters password into password field
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch




