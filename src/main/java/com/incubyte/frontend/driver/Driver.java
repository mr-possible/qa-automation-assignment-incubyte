/* Incubyte QA Automation assignment */
package com.incubyte.frontend.driver;

import com.incubyte.frontend.driver.entity.WebDriverPreReq;
import com.incubyte.frontend.driver.factory.DriverFactory;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;

import static com.incubyte.config.factory.GlobalConfigFactory.getConfig;

@Slf4j
public final class Driver {

  private Driver() {
  }

  public static void initialiseDriver() {
    WebDriverPreReq preReqs = new WebDriverPreReq(
        getConfig().runMode(), getConfig().browser(), getConfig().browserRemotePlatform());
    WebDriver driver = DriverFactory.getDriver(getConfig().runMode()).getDriver(preReqs);
    DriverManager.setDriver(driver);
  }

  public static void quitDriver() {
    DriverManager.getDriver().quit();
  }
}
