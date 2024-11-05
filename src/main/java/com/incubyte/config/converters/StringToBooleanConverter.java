/* Incubyte QA Automation assignment */
package com.incubyte.config.converters;

import java.lang.reflect.Method;
import org.aeonbits.owner.Converter;

public class StringToBooleanConverter implements Converter<Boolean> {

  @Override
  public Boolean convert(Method method, String s) {
    return Boolean.valueOf(s);
  }
}
