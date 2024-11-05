/* Incubyte QA Automation assignment */
package com.incubyte.frontend.driver.manager.factory;

import com.incubyte.config.enums.Browser;
import com.incubyte.config.enums.BrowserRemotePlatform;
import org.openqa.selenium.WebDriver;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Function;

public final class RemoteDriverFactory {
  private static final Map<BrowserRemotePlatform, Function<Browser, WebDriver>> map =
      new EnumMap<>(BrowserRemotePlatform.class);

  static {
    map.put(BrowserRemotePlatform.SELENIUM_GRID, SeleniumGridFactory::getDriver);
  }

  private RemoteDriverFactory() {
  }

  public static WebDriver getDriver(BrowserRemotePlatform browserRemotePlatform, Browser browser) {
    return map.get(browserRemotePlatform).apply(browser);
  }
}
