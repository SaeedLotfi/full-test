Feature: Sum API

  Scenario: Sum of two positive numbers
    Given the numbers 2 and 3
    When I call the sum endpoint
    Then the result should be 5

  Scenario: Sum of negative and positive number
    Given the numbers -1 and 4
    When I call the sum endpoint
    Then the result should be 3