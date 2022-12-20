Feature: Retail Home Page

  @Test
  Scenario: Verify Shop by Department sidebar
    Given User is on retail website
    When User click on All section
    Then below options are present in Shop by Department sidebar
      | Electronics | Computers | Smart Home | Sports | Automative |

  @Test2
  Scenario Outline: Verify department sidebar options
    Given User is on retail website
    When User click on All section
    When User on <department>
    Then below options are present in department
      | <optionOne> | <optionTwo> |

    Examples: 
      | department  | optionOne                      | optionTwo                |
      | Electronics | TV & Video                     | Video Games              |
      | Computers   | Accessories                    | Networking               |
      | Smart Home  | Smart Home Lightning           | Plugs and Outlets        |
      | Sports      | Athletic Clothing              | Exercise & Fitness       |
      | Automotive  | Automative Parts & Accessories | MotorCycle & Powersports |

  @ADDTOTHECARD
  Scenario: Verify User can add an item to cart
    Given User is on retail website
    When User click on Sign in option
    And User enter email 'sohail@tek.com' and password 'Shadab9166@'
    And User click on login button
    And User should be logged in into Account
    And User change the category to 'Smart Home'
    And User search for an item 'kasa outdoor smart plug'
    And User click on Search icon
    And User click on item
    And User select quantity ‘2’
    And User click add to Cart button
    Then the cart icon quantity should change to ‘2’

  @Placeorder
  Scenario: Verify User can place an order without Shipping address and payment Method on file
    Given User is on retail website
    When User click on Sign in option
    And User enter email 'sohail@tek.com' and password 'Shadab9166@'
    And User click on login button
    And User should be logged in into Account
    And User change the category to 'Smart Home'
    And User search for an item 'kasa outdoor smart plug'
    And User click on Search icon
    And User click on item
    And User select quantity ‘2’
    And User click add to Cart button
    Then the cart icon quantity should change to ‘2’
    And User click on Cart option
    And User click on Proceed to Checkout button
    And User click Add a new address link for shipping address
    And User fill new address form with below information
      | country       | fullName | phoneNumber | streetAddress | apt  | city           | state      | zipCode |
      | United States | Moh      |  9158856481 | 12346 street  | 1222 | Rancho Cordova | California |   95670 |
    And User click Add Your Address button
    And User click Add a credit card or Debit Card for Payment method
    And User fill Debit or credit card information
      | cardNumber | nameOnCard | expirationMonth | expirationYear | securityCode |
      | 5682347623476132      | Moh      | 12           | 2025          | 211        |
    And User click on Add your card button
    And User click on Place Your Order
    Then a message should be displayed ‘Order Placed, Thanks’
    @Then
    Scenario:  Verify User can place an order with Shipping address and payment Method on file
    Given User is on retail website
    When User click on Sign in option
    And User enter email 'sohail@tek.com' and password 'Shadab9166@'
    And User click on login button
    And User should be logged in into Account
    And User change the category to 'Electronics'
    And User search for an item 'Apex Legends '
    And User click on Search icon
    And User click on item 
    And User select quantity ‘5’
    And User click add to Cart button 
    Then the cart icon quantity should change to ‘5’
    And User click on Cart option 
    And User click on Proceed to Checkout button
    And User click on Place Your Order
    Then a message should be displayed ‘Order Placed, Thanks’
    @Need
    Scenario: Verify User can cancel the order 
    Given User is on retail website
    When User click on Sign in option
    And User enter email 'sohail@tek.com' and password 'Shadab9166@'
    And User click on login button
    And User should be logged in into Account
    And User click on Orders section 
    And User click on first order in list 
    And User click on Cancel The Order button
    And User select the cancelation Reason ‘Bought wrong item’
    And User click on Cancel Order button
    Then a cancelation message should be displayed ‘Your Order Has Been Cancelled’
    @Return
    Scenario: Verify User can Return the order 
    Given User is on retail website
    When User click on Sign in option
    And User enter email 'sohail@tek.com' and password 'Shadab9166@'
    And User click on login button
    And User should be logged in into Account
    And User click on Orders section 
    And User click on first order in list 
    And User click on Return Items button
    And User select the Return Reason ‘Item damaged’
    And User select the drop off service ‘FedEx’
    And User click on Return Order button
    Then a cancelation message should be displayed ‘Return was successful’
     @Review
    Scenario: Verify User can write a review on order placed
    Given User is on retail website
    When User click on Sign in option
    And User enter email 'sohail@tek.com' and password 'Shadab9166@'
    And User click on login button
    And User should be logged in into Account
    And User click on Orders section 
    And User click on first order in list 
    And User click on Review button 
    And User write Review headline 'this item is good' and 'Good to watch netflix and chill'
    And User click Add your Review button
    Then a review message should be displayed ‘Your review was added successfully’
