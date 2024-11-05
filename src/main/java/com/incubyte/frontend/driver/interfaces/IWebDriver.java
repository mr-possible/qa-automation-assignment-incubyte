/* Incubyte QA Automation assignment */
package com.incubyte.frontend.driver.interfaces;

import com.incubyte.frontend.driver.entity.WebDriverPreReq;
import org.openqa.selenium.WebDriver;

public interface IWebDriver {
  WebDriver getDriver(WebDriverPreReq preReq);
}
