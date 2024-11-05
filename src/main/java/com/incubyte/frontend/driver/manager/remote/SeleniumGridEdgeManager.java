/* Incubyte QA Automation assignment */
package com.incubyte.frontend.driver.manager.remote;

import com.incubyte.config.factory.GlobalConfigFactory;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

@Slf4j
public final class SeleniumGridEdgeManager {

  private SeleniumGridEdgeManager() {
  }

  public static WebDriver getDriver() {
    EdgeOptions edgeOptions = new EdgeOptions();
    edgeOptions.addArguments("start-maximized");
    edgeOptions.addArguments("--disable-popup-blocking");
    edgeOptions.addArguments("--disable-extensions");
    if (GlobalConfigFactory.getConfig().headlessEnable()) {
      log.warn("Headless execution enabled!");
      edgeOptions.addArguments("headless");
      edgeOptions.addArguments("--start-fullscreen");
      edgeOptions.addArguments("--window-size=1920,1080");
    }
    return new RemoteWebDriver(GlobalConfigFactory.getConfig().seleniumGridURL(), edgeOptions);
  }
}
