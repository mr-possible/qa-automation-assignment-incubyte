package com.incubyte.frontend.pageobjects;

import com.incubyte.utils.UserActions;
import org.openqa.selenium.By;

public class SignUpPage {

  private static final By INPUT_FIRSTNAME = By.cssSelector("#firstname");
  private static final By INPUT_LASTNAME = By.cssSelector("#lastname");
  private static final By INPUT_EMAIL = By.cssSelector("#email_address");
  private static final By INPUT_PASSWORD = By.cssSelector("#password");
  private static final By INPUT_CNF_PASSWORD = By.cssSelector("#password-confirmation");
  private static final By BTN_CREATE_ACCOUNT = By.xpath("//button[@type='submit' and @title='Create an Account']");

  public SignUpPage enterFirstName(final String firstName) {
    UserActions.fillTextfield(INPUT_FIRSTNAME, firstName);
    return this;
  }

  public SignUpPage enterLastName(final String lastName) {
    UserActions.fillTextfield(INPUT_LASTNAME, lastName);
    return this;
  }

  public SignUpPage enterEmail(final String email) {
    UserActions.fillTextfield(INPUT_EMAIL, email);
    return this;
  }

  public SignUpPage enterPassword(final String password) {
    UserActions.fillTextfield(INPUT_PASSWORD, password);
    return this;
  }

  public SignUpPage enterConfirmPassword(final String password) {
    UserActions.fillTextfield(INPUT_CNF_PASSWORD, password);
    return this;
  }

  public HomePage doSignUp() {
    UserActions.jsClick(BTN_CREATE_ACCOUNT);
    return new HomePage();
  }
}
