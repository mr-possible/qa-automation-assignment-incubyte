/* Incubyte QA Automation assignment */
package com.incubyte.frontend.driver.manager.factory;

import com.incubyte.frontend.driver.manager.remote.SeleniumGridChromeManager;
import com.incubyte.frontend.driver.manager.remote.SeleniumGridEdgeManager;
import com.incubyte.config.enums.Browser;
import org.openqa.selenium.WebDriver;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public final class SeleniumGridFactory {
  private static final Map<Browser, Supplier<WebDriver>> map = new EnumMap<>(Browser.class);

  static {
    map.put(Browser.CHROME, SeleniumGridChromeManager::getDriver);
    map.put(Browser.EDGE, SeleniumGridEdgeManager::getDriver);
  }

  private SeleniumGridFactory() {
  }

  public static WebDriver getDriver(Browser browser) {
    return map.get(browser).get();
  }
}
