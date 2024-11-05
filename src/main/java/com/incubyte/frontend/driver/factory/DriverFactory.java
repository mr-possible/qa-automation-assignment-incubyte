/* Incubyte QA Automation assignment */
package com.incubyte.frontend.driver.factory;

import com.incubyte.frontend.driver.impl.LocalWebDriverPreReqImpl;
import com.incubyte.frontend.driver.impl.RemoteWebDriverPreReqImpl;
import com.incubyte.frontend.driver.interfaces.IWebDriver;
import com.incubyte.config.enums.RunMode;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public final class DriverFactory {
  private static final Map<RunMode, Supplier<IWebDriver>> WEB = new EnumMap<>(RunMode.class);

  static {
    WEB.put(RunMode.LOCAL, LocalWebDriverPreReqImpl::new);
    WEB.put(RunMode.REMOTE, RemoteWebDriverPreReqImpl::new);
  }

  private DriverFactory() {
  }

  public static IWebDriver getDriver(RunMode runMode) {
    return WEB.get(runMode).get();
  }
}
