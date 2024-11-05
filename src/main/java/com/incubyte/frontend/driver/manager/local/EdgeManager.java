/* Incubyte QA Automation assignment */
package com.incubyte.frontend.driver.manager.local;

import com.incubyte.config.factory.GlobalConfigFactory;
import com.incubyte.frontend.driver.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

@Slf4j
public final class EdgeManager {

  private EdgeManager() {
  }

  public static WebDriver getEdgeDriver() {
    EdgeOptions edgeOptions = new EdgeOptions();
    edgeOptions.addArguments("start-maximized", "disable-extensions", "disable-popup-blocking");
    if (GlobalConfigFactory.getConfig().headlessEnable()) {
      log.warn("Headless execution enabled!");
      edgeOptions.addArguments("headless");
      edgeOptions.addArguments("--start-fullscreen");
      edgeOptions.addArguments("--window-size=1920,1080");
    }
    WebDriverManager.edgedriver().setup();
    WebDriver driver = new EdgeDriver(edgeOptions);
    DriverManager.setDriver(driver);
    return driver;
  }
}
