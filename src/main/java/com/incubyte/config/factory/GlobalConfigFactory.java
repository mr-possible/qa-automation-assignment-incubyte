/* Incubyte QA Automation assignment */
package com.incubyte.config.factory;

import com.incubyte.config.GlobalConfig;
import org.aeonbits.owner.ConfigCache;

public final class GlobalConfigFactory {
  private GlobalConfigFactory() {
  }

  public static GlobalConfig getConfig() {
    return ConfigCache.getOrCreate(GlobalConfig.class);
  }
}
