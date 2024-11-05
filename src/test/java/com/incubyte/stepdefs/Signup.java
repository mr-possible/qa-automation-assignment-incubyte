package com.incubyte.stepdefs;

import com.github.javafaker.Faker;
import com.incubyte.frontend.pageobjects.SignUpPage;
import com.incubyte.utils.PasswordGenerator;
import com.incubyte.utils.UserActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;

public class Signup {

  SignUpPage signUpPage = new SignUpPage();
  Faker faker = new Faker();

  @Given("the user is on the signup page")
  public void the_user_is_on_the_signup_page() throws MalformedURLException {
    UserActions.open(new URL("https://magento.softwaretestingboard.com/customer/account/create/"));
  }

  @When("the user fills in valid details \\(first name, last name, email, password) and submits the form")
  public void theUserFillsInValidDetailsFirstNameLastNameEmailPasswordAndSubmitsTheForm() {
    final String password = PasswordGenerator.generateSecurePassword(10, 16);

    signUpPage
        .enterFirstName(faker.name().firstName())
        .enterLastName(faker.name().lastName())
        .enterEmail(faker.internet().safeEmailAddress())
        .enterPassword(password)
        .enterConfirmPassword(password)
        .doSignUp();
  }

  @Then("the user should land on the home page indicating successful account creation")
  public void the_user_should_land_on_the_home_page_indicating_successful_account_creation() {
    Assert.assertTrue(UserActions.checkPageHeader("My Account"), "Home page header not present!");
  }

  @When("the user tries to create an account using an existing {string} and other relevant details \\({string}, {string}, {string})")
  public void theUserTriesToCreateAnAccountUsingAnExistingAndOtherRelevantDetails(String existingEmail, String firstName, String lastName, String password) {
    signUpPage
        .enterFirstName(firstName)
        .enterLastName(lastName)
        .enterEmail(existingEmail)
        .enterPassword(password)
        .enterConfirmPassword(password)
        .doSignUp();
  }

  @Then("an error message should be displayed saying the email is already in use")
  public void anErrorMessageShouldBeDisplayedSayingTheEmailIsAlreadyInUse() {
    Assert.assertTrue(UserActions.isAlertMessagePresent("There is already an account with this email address."), "I should be getting the error message for duplicate email.");
    Assert.assertFalse(UserActions.checkPageHeader("My Account"), "I should still be on the sign up page");
  }
}
