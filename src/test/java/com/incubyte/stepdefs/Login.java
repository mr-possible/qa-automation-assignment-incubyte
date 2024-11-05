package com.incubyte.stepdefs;

import com.incubyte.frontend.pageobjects.LoginPage;
import com.incubyte.utils.UserActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;

public class Login {

  LoginPage loginPage = new LoginPage();

  @Given("the user has a registered account with valid credentials and is on the login page")
  public void theUserHasARegisteredAccountWithValidCredentialsAndIsOnTheLoginPage() throws MalformedURLException {
    UserActions.open(new URL("https://magento.softwaretestingboard.com/customer/account/login/"));
    Assert.assertTrue(UserActions.checkPageHeader("Customer Login"), "I can't see login page!");
  }

  @When("the user enters their {string} and {string} and submits the form")
  public void theUserEntersTheirCredentialsAndAndSubmitsTheForm(String email, String password) {
    loginPage
        .enterEmail(email)
        .enterPassword(password)
        .doLogin();
  }

  @Then("the user should be logged in successfully")
  public void theUserShouldBeLoggedInSuccessfully() {
    Assert.assertTrue(UserActions.checkPageHeader("My Account"), "I can't see home page!");
  }

  @Given("the user has a registered account with the {string}")
  public void theUserHasARegisteredAccountWithThe(String registeredEmail) throws MalformedURLException {
    UserActions.open(new URL("https://magento.softwaretestingboard.com/customer/account/login/"));
    loginPage.enterEmail(registeredEmail);
  }

  @When("the user enters an incorrect {string}")
  public void theUserEntersAnIncorrect(String incorrectPassword) {
    loginPage.enterPassword(incorrectPassword)
        .doLogin();
  }

  @Then("an error message should be displayed indicating incorrect credentials")
  public void anErrorMessageShouldBeDisplayedIndicatingIncorrectCredentials() {
    Assert.assertTrue(UserActions.isAlertMessagePresent("The account sign-in was incorrect"), "I should be getting the error message for wrong password.");
  }


}
