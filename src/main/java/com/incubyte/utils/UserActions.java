/* Incubyte QA Automation assignment */
package com.incubyte.utils;

import com.google.common.util.concurrent.Uninterruptibles;
import com.incubyte.config.factory.GlobalConfigFactory;
import com.incubyte.frontend.driver.DriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;

@Slf4j
public final class UserActions {

  private static final int LEAST_WAIT_TIME = GlobalConfigFactory.getConfig().leastwait();

  private UserActions() {
  }

  /**
   * Wait till the web element is visible on the Webpage
   *
   * @param by : Locator of the WebElement whose visibility is to be checked
   */
  public static void waitForTheElementToBeVisible(final By by) {
    WebDriver driver = DriverManager.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(LEAST_WAIT_TIME));
    waitForTheElementToBePresent(by);
    wait.until(ExpectedConditions.visibilityOf(driver.findElement(by)));
  }

  /**
   * Wait till the web element is present in the DOM
   *
   * @param by : Locator of the WebElement
   */
  public static void waitForTheElementToBePresent(final By by) {
    WebDriver driver = DriverManager.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(LEAST_WAIT_TIME));
    wait.until(ExpectedConditions.presenceOfElementLocated(by));
  }

  /**
   * This method is used to scroll to view the WebElement on the Webpage (but will scroll only if it is needed)
   *
   * @param by : Locator of the WebElement that needs to be viewed
   */
  public static void scrollToElementIfNeeded(final By by) {
    waitForTheElementToBePresent(by);
    WebDriver driver = DriverManager.getDriver();
    WebElement element = driver.findElement(by);
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].scrollIntoViewIfNeeded();", element);
  }

  /**
   * Wait till the web element is clickable.
   *
   * @param by : Locator of the WebElement to be clicked
   */
  public static void waitForTheElementToBeClickable(final By by) {
    WebDriver driver = DriverManager.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(LEAST_WAIT_TIME));
    wait.until(ExpectedConditions.presenceOfElementLocated(by));
    wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(by)));
  }

  /**
   * Used to open a particular page
   *
   * @param url The url of the page that user needs to open
   */
  public static void open(URL url) {
    DriverManager.getDriver().get(String.valueOf(url));
    log.warn("Navigated to [" + url + "]");
  }

  /**
   * Wait for the specified number of seconds
   *
   * @param seconds : Number of seconds to wait while the action is being performed
   */
  public static void waitInSeconds(int seconds) {
    Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(seconds));
    log.warn("Waited for [" + seconds + "] second(s)");
  }

  /**
   * This method is used to perform click action on the WebElement
   *
   * @param by : Locator of the WebElement on which click action is to be performed
   */
  public static void click(final By by) {
    waitForTheElementToBeClickable(by);
    moveToElement(by);
    WebElement element = getElement(by);
    element.click();
    log.info("Element click happened.");
  }

  /**
   * This method is used to perform click action on the WebElement through Actions class
   *
   * @param by : Locator of the WebElement on which click action is to be performed
   */
  public static void clickThroughSeleniumActions(final By by) {
    WebDriver driver = DriverManager.getDriver();
    Actions actions = new Actions(driver);
    WebElement element = driver.findElement(by);
    actions.click(element).build().perform();
    waitInSeconds(1);
    log.info("Element click happened through Selenium Actions class.");
  }

  /**
   * This method is used to perform click action on the WebElement through JavascriptExecutor
   *
   * @param element : The WebElement on which click action is to be performed
   */
  public static void jsClick(final By by) {
    JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
    js.executeScript("arguments[0].click();", DriverManager.getDriver().findElement(by));
    waitInSeconds(1);
    log.info("Element click happened through JavascriptExecutor.");
  }

  /**
   * This method is used to hover over a WebElement on the Webpage
   *
   * @param by : Locator of the WebElement that needs to be hovered upon
   */
  public static void moveToElement(final By by) {
    waitForTheElementToBePresent(by);
    WebElement element = getElement(by);
    new Actions(DriverManager.getDriver()).moveToElement(element).build().perform();
    log.info("Hovered over the element");
  }

  /**
   * This method is used to get a WebElement on the page
   *
   * @param by : The locator of the WebElement that user needs to find
   * @return : WebElement on the page
   */
  public static WebElement getElement(final By by) {
    return DriverManager.getDriver().findElement(by);
  }

  /**
   * This method is used to enter set of characters and press enter key in the end.
   *
   * @param by           : Locator of the WebElement
   * @param valueToEnter : value to be entered
   */
  public static void fillTextfield(final By by, final String valueToEnter) {
    moveToElement(by);
    WebElement element = getElement(by);
    element.sendKeys(valueToEnter);
    log.info("Entered value [" + valueToEnter + "] and pressed ENTER key");
  }

  /**
   * Check if web element is present in the DOM
   *
   * @param by : Locator of the WebElement
   * @return : true if present; false if not
   */
  public static boolean isElementPresent(final By by) {
    try {
      waitForTheElementToBePresent(by);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public static boolean checkPageHeader(final String headerText) {
    return isElementPresent(By.xpath("//h1[@class='page-title']/span[.='" + headerText + "']"));
  }

  public static boolean isAlertMessagePresent(final String message) {
    return isElementPresent(By.xpath("//div[@role='alert']/div[contains(., '" + message + "')]"));
  }
}
