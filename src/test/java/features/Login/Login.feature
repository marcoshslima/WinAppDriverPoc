Feature: Login
  As a User
  I Want To Login
  At PayTrue System

  Scenario Outline: Login With Incorrect username and password
    Given I open the paytrue system successfully
    And I fill the field Username <username> and PassWord <password> with incorrect values
    When I Click on the button Login
    Then The system should displayed the following message <messageError>
    Examples:
      | username | password | messageError |
      | abcder   | 123456   | a            |
      | dsfdsfsd | 3243243  | dfsfdsfdsf   |