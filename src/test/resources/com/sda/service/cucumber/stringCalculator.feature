Feature:

  Scenario: I can calculate single number
    Given I initialize stringCalculator
    And I pass single number value
    When I trigger calculate function
    Then I get 5 as a result

  Scenario: I can calculate null number
    Given I initialize stringCalculator
    And I pass null value
    When I trigger calculate function
    Then I get 0 as a result

  Scenario: I can calculate empty number
    Given I initialize stringCalculator
    And I pass empty value
    When I trigger calculate function
    Then I get 0 as a result

  Scenario: I can calculate two numbers
    Given I initialize stringCalculator
    And I pass two numbers value
    When I trigger calculate function
    Then I get 9 as a result

  Scenario: I can calculate multiple numbers
    Given I initialize stringCalculator
    And I pass multiple numbers value
    When I trigger calculate function
    Then I get 9 as a result

  Scenario: I can calculate numbers with whitespaces
    Given I initialize stringCalculator
    And I pass multiple numbers with whitespaces value
    When I trigger calculate function
    Then I get 9 as a result

