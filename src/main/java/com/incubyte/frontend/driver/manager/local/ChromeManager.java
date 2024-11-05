/* Incubyte QA Automation assignment */
package com.incubyte.frontend.driver.manager.local;

import com.incubyte.config.factory.GlobalConfigFactory;
import com.incubyte.frontend.driver.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

@Slf4j
public final class ChromeManager {

  private ChromeManager() {
  }

  public static WebDriver getChromeDriver() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--start-maximized");
    options.addArguments("--disable-extensions");
    options.addArguments("--disable-popup-blocking");

    if (GlobalConfigFactory.getConfig().headlessEnable()) {
      options.addArguments("--headless=old");
      options.addArguments("--window-size=1920,1080");
      log.warn("Headless execution enabled!");
    }

    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver(options);
    DriverManager.setDriver(driver);

    return driver;
  }
}
