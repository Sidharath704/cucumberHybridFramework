Feature: Registration functionality

Scenario: User Creates an account only with mandatory fields
Given User navigates to Register Account page
When  User enters the details into below fields
|First Name         |Sidharath                |
|Last Name          |rawat                    |
|Email              |siddhurawat22@gmail.com  |
|Password           |Pitu@1234                |
|Confirm Password   |Pitu@1234                |
And User clicks on create an account button for registration new user
Then User Account should get created successfully


Scenario: User Creates an duplicate account 
Given User navigates to Register Account page
When  User enters the details into below fields
|First Name         |Sidharath                  |
|Last Name          |singh                      |
|Email              |sidharathsingh931@gmail.com |
|Password           |Pitu@1234                  |
|Confirm Password   |Pitu@1234                  |
And User clicks on create an account button for registration new user
Then User should get a proper warning about duplicate email  

Scenario: User creates an account without filling any details
When User do not enters any details into fields
And User clicks on create an account button for registration new user
Then User should get a warning messages for every mandatory field
