Feature: Bank functionality


  Scenario: I can add user to bank
    Given I instantiate bank
    And I create user with name 'Anna Rybacka' and pesel '123456789'
    When I insert user to bank
    Then User is present in bank
