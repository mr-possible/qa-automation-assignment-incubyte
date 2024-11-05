/* Incubyte QA Automation assignment */
package com.incubyte.hooks;

import com.incubyte.frontend.driver.Driver;
import com.incubyte.frontend.driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.RemoteWebDriver;

@Slf4j
public class SetupHooks {

  @Before
  public void beforeScenario(Scenario scenario) {
    log.info("Starting scenario => {}", scenario.getName());
    Driver.initialiseDriver();
  }

  @After
  public void afterScenario(Scenario scenario) {
    Driver.quitDriver();
    log.info("Finished scenario => {}", scenario.getName());
  }

  @AfterStep
  public void afterStep(Scenario scenario) {
    RemoteWebDriver rwd = (RemoteWebDriver) DriverManager.getDriver();
    byte[] screenshot = rwd.getScreenshotAs(OutputType.BYTES);
    scenario.attach(screenshot, "image/png", "");
  }
}
