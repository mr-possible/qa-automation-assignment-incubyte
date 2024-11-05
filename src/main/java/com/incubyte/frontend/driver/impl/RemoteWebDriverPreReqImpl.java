/* Incubyte QA Automation assignment */
package com.incubyte.frontend.driver.impl;

import com.incubyte.frontend.driver.entity.WebDriverPreReq;
import com.incubyte.frontend.driver.interfaces.IWebDriver;
import com.incubyte.frontend.driver.manager.factory.RemoteDriverFactory;
import org.openqa.selenium.WebDriver;

public class RemoteWebDriverPreReqImpl implements IWebDriver {
  @Override
  public WebDriver getDriver(WebDriverPreReq preReq) {
    return RemoteDriverFactory.getDriver(preReq.getBrowserRemotePlatform(), preReq.getBrowser());
  }
}
