/* Incubyte QA Automation assignment */
package com.incubyte.frontend.driver.manager.factory;

import com.incubyte.frontend.driver.manager.local.ChromeManager;
import com.incubyte.frontend.driver.manager.local.EdgeManager;
import com.incubyte.config.enums.Browser;
import org.openqa.selenium.WebDriver;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public final class LocalDriverFactory {
  private static final Map<Browser, Supplier<WebDriver>> map = new EnumMap<>(Browser.class);

  static {
    map.put(Browser.CHROME, ChromeManager::getChromeDriver);
    map.put(Browser.EDGE, EdgeManager::getEdgeDriver);
  }

  private LocalDriverFactory() {
  }

  public static WebDriver getDriver(Browser browser) {
    return map.get(browser).get();
  }
}
