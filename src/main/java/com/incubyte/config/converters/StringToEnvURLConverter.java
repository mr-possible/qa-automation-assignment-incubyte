/* Incubyte QA Automation assignment */
package com.incubyte.config.converters;

import java.lang.reflect.Method;
import java.net.URL;
import lombok.SneakyThrows;
import org.aeonbits.owner.Converter;

public class StringToEnvURLConverter implements Converter<URL> {

  @SneakyThrows
  @Override
  public URL convert(Method method, String s) {
    return new URL(System.getProperty("env"));
  }
}
