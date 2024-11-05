/* Incubyte QA Automation assignment */
package com.incubyte.frontend.driver.manager.remote;

import com.incubyte.config.factory.GlobalConfigFactory;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

@Slf4j
public final class SeleniumGridChromeManager {

  private SeleniumGridChromeManager() {
  }

  public static WebDriver getDriver() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("start-maximized");
    options.addArguments("--disable-popup-blocking");
    options.addArguments("--disable-extensions");

    if (GlobalConfigFactory.getConfig().headlessEnable()) {
      log.warn("Headless execution enabled!");
      options.addArguments("headless");
      options.addArguments("--start-fullscreen");
      options.addArguments("--window-size=1920,1080");
    }
    return new RemoteWebDriver(GlobalConfigFactory.getConfig().seleniumGridURL(), options);
  }
}
