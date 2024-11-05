/* Incubyte QA Automation assignment */
package com.incubyte.config.converters;

import java.lang.reflect.Method;
import java.net.URI;
import lombok.SneakyThrows;
import org.aeonbits.owner.Converter;

public class StringToEnvURIConverter implements Converter<URI> {

  @SneakyThrows
  @Override
  public URI convert(Method method, String s) {
    return new URI(String.format(s, System.getProperty("env")));
  }
}
