/* Incubyte QA Automation assignment */
package com.incubyte.config.converters;

import java.lang.reflect.Method;
import java.nio.file.Path;
import lombok.SneakyThrows;
import org.aeonbits.owner.Converter;

public class StringToPathConverter implements Converter<Path> {
  @SneakyThrows
  @Override
  public Path convert(Method method, String s) {
    return Path.of(s);
  }
}
