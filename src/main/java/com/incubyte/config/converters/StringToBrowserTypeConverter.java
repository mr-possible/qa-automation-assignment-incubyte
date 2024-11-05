/* Incubyte QA Automation assignment */
package com.incubyte.config.converters;

import com.incubyte.config.enums.Browser;
import org.aeonbits.owner.Converter;

import java.lang.reflect.Method;
import java.util.Map;

public class StringToBrowserTypeConverter implements Converter<Browser> {

  @Override
  public Browser convert(Method method, String browserName) {
    Map<String, Browser> browserMap = Map.of("chrome", Browser.CHROME, "edge", Browser.EDGE);

    /**
     * If the user mistakenly passes any un-supported browser, then run tests on chrome as default
     * (to ensure not to halt the process)
     */
    return browserMap.get(browserName);
  }
}
