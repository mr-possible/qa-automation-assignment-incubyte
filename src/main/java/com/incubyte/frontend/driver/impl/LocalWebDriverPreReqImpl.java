/* Incubyte QA Automation assignment */
package com.incubyte.frontend.driver.impl;

import com.incubyte.frontend.driver.entity.WebDriverPreReq;
import com.incubyte.frontend.driver.interfaces.IWebDriver;
import com.incubyte.frontend.driver.manager.factory.LocalDriverFactory;
import org.openqa.selenium.WebDriver;

public class LocalWebDriverPreReqImpl implements IWebDriver {
  @Override
  public WebDriver getDriver(WebDriverPreReq preReq) {
    return LocalDriverFactory.getDriver(preReq.getBrowser());
  }
}
