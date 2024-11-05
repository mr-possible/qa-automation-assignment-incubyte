/* Incubyte QA Automation assignment */
package com.incubyte.frontend.driver.entity;

import com.incubyte.config.enums.Browser;
import com.incubyte.config.enums.BrowserRemotePlatform;
import com.incubyte.config.enums.RunMode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class WebDriverPreReq {
  private RunMode runMode;
  private Browser browser;
  private BrowserRemotePlatform browserRemotePlatform;
}
