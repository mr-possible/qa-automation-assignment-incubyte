/* Incubyte QA Automation assignment */
package com.incubyte.config.converters;

import com.incubyte.config.enums.BrowserRemotePlatform;
import org.aeonbits.owner.Converter;

import java.lang.reflect.Method;

public class StringToBrowserRemotePlatformConverter implements Converter<BrowserRemotePlatform> {
  @Override
  public BrowserRemotePlatform convert(Method method, String browserRemotePlatform) {
    return BrowserRemotePlatform.valueOf(browserRemotePlatform.toUpperCase());
  }
}
