package com.incubyte.frontend.pageobjects;

import com.incubyte.utils.UserActions;
import org.openqa.selenium.By;

public class LoginPage {

  private static final By INPUT_EMAIL = By.cssSelector("#email");
  private static final By INPUT_PASSWORD = By.cssSelector("#pass");
  private static final By BTN_LOGIN = By.cssSelector("#send2");

  public LoginPage enterEmail(final String email) {
    UserActions.fillTextfield(INPUT_EMAIL, email);
    return this;
  }

  public LoginPage enterPassword(final String password) {
    UserActions.fillTextfield(INPUT_PASSWORD, password);
    return this;
  }

  public HomePage doLogin() {
    UserActions.click(BTN_LOGIN);
    return new HomePage();
  }
}
