@signup

Feature: Signup

  Scenario: Successful Account Creation
    Given the user is on the signup page
    When the user fills in valid details (first name, last name, email, password) and submits the form
    Then the user should land on the home page indicating successful account creation

  Scenario Outline: Attempt Signup with Existing Email
    Given the user is on the signup page
    When the user tries to create an account using an existing "<existing_email>" and other relevant details ("<first name>", "<last name>", "<password>")
    Then an error message should be displayed saying the email is already in use
    Examples:
      | existing_email     | first name | last name | password       |
      | test6197@gmail.com | Monica     | Belluchi  | Hollywood@6197 |