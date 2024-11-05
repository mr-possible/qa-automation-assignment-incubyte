@login

Feature: Login

  Scenario Outline: Successful Login with Registered Account
    Given the user has a registered account with valid credentials and is on the login page
    When the user enters their "<email>" and "<password>" and submits the form
    Then the user should be logged in successfully
    Examples:
      | email              | password   |
      | test6197@gmail.com | Peaky@6197 |

  Scenario Outline: Failed Login with Incorrect Password
    Given the user has a registered account with the "<email>"
    When the user enters an incorrect "<password>"
    Then an error message should be displayed indicating incorrect credentials
    Examples:
      | email              | password               |
      | test6197@gmail.com | IncorrectPassword34343 |
