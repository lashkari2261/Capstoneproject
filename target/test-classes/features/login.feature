@signInTest
Feature: Sign In Feature

  #this is comment
  Background: 
    Given User is on retail website
    When User click on Sign in option
    And User enter email 'sohail@tek.com' and password 'Shadab9166@'
    And User click on loginbutton
    And User should be logged in into Account
    When User click on Account option

  Scenario: Verify user can sign in into Retail Application
    And User enter email 'sohail@tek.com' and password 'Shadab9166@'
    And User click on login button
    Then User should be logged in into Account

  @Moh
  Scenario: Verify user can create an account into Retail Website
    And User click on Create New Account button
    And User fill the signUp information with below data
      | name | email                 | password  | confirmPassword |
      | Moh  | Cordova2422@gmail.com | Cordova1! | Cordova1!       |
    And User click on SignUp button
    Then User should be logged into account page

  @UpDate
  Scenario: Verify User can update Profile Information
    When User click on Account option
    And User update Name 'Shadab Lashkari' and Phone '5308134254'
    And User click on Update button
    Then user profile information should be updated

  @Changepass
  Scenario: Verify User can Update password
    When User click on Account option
    And User enter below information
      | previousPassword | newPassword | confirmPassword |
      | Shadab916@       | Shadab9166@ | Shadab9166@     |
    And User click on Change Password button
    Then a message should be displayed ‘Password Updated Successfully’

  @Payment
  Scenario: Verify User can add a payment method
    When User click on Account option
    And User click on Add a payment method link
    And User fill Debit or credit card information
      | cardNumber       | nameOnCard | expirationMonth | expirationYear | securityCode |
      | 1234567132121314 | Sohail     |              11 |           2024 |          911 |
    And User click on Add your card button
    Then a message should be displayed ‘Payment Method added successfully’

  @Updatepayment
  Scenario: Verify User can edit Debit or Credit card
    When User click on Account option
    And User select card with ending '6132'
    And User click on Edit option of card section
    And user edit information with below data
      | cardNumber       | nameOnCard | expirationMonth | expirationYear | securityCode |
      | 5682347623476132 | Moh        |              12 |           2025 |          211 |
    And user click on Update Your Card button
    Then a message should be displayed ‘Payment Method updated Successfully’

  @Addaddress
  Scenario: Verify User can add an Address
    When User click on Account option
    And User click on Add address option
    And user fill new address form with below information
      | country       | fullName | phoneNumber | streetAddress | apt  | city           | state      | zipCode |
      | United States | Moh      |  9158856481 | 12346 street  | 1222 | Rancho Cordova | California |   95670 |
    And User click Add Your Address button
    Then a message should be displayed ‘Address Added Successfully’

  @RemoveCard
  Scenario: Verify User can remove Debit or Credit card
    When User click on Account option
    And User click on remove option of card section
    Then payment details should be removed
@EditAddress
  Scenario: Verify User can edit an Address added on accountWhen User click on Account option
    And User click on edit address option
    And User fill Upated information below
      | country       | fullName | phoneNumber | streetAddress  | apt | city      | state      | zipCode |
      | United States | Sohils    |  1389263892 | 622 abc street | 1212 | Rancho Cordova | California |   95670 |
    And User click update Your Address button
    Then a message should be displayed ‘Address Updated Successfully’
   @RemoveAddress 
    Scenario: Verify User can remove Address from Account 
    When User click on Account option 
    And User click on remove option of Address section
    Then Address details should be removed
