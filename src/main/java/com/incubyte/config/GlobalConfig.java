/* Incubyte QA Automation assignment */
package com.incubyte.config;

import com.incubyte.config.converters.*;
import com.incubyte.config.enums.Browser;
import com.incubyte.config.enums.BrowserRemotePlatform;
import com.incubyte.config.enums.RunMode;
import org.aeonbits.owner.Config;

import java.net.URI;
import java.net.URL;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
    "system:properties",
    "system:env",
    "file:${user.dir}/config.properties",
    "file:${user.dir}/src/test/resources/config.properties"
})
public interface GlobalConfig extends Config {
  @Key("run.mode")
  @ConverterClass(StringToRunModeConverter.class)
  RunMode runMode();

  @Key("headless.enable")
  @ConverterClass(StringToBooleanConverter.class)
  Boolean headlessEnable();

  @Key("web.app.url")
  @ConverterClass(StringToEnvURLConverter.class)
  URL appURL();

  @Key("web.browser")
  @DefaultValue("CHROME")
  @ConverterClass(StringToBrowserTypeConverter.class)
  Browser browser();

  @Key("web.browser.remote.platform")
  @ConverterClass(StringToBrowserRemotePlatformConverter.class)
  BrowserRemotePlatform browserRemotePlatform();

  @Key("api.baseuri")
  @ConverterClass(StringToEnvURIConverter.class)
  URI baseUri();

  @Key("api.request.json.folder.path")
  @ConverterClass(StringToPathConverter.class)
  String requestJsonFolderPath();

  @Key("wait.least")
  int leastwait();

  @Key("wait.long")
  int longWait();

  @Key("wait.longest")
  int longestWait();

  @Key("db.name")
  String dbName();

  @Key("db.url")
  String dbURL();

  @Key("db.username")
  String dbUsername();

  @Key("db.password")
  String dbPassword();

  @Key("grid.enable")
  boolean isGridEnabled();

  @Key("grid.url")
  @ConverterClass(StringToURLConverter.class)
  URL seleniumGridURL();

  @Key("grid.host")
  String gridHost();

  @Key("screenshot.enable")
  boolean takeScreenshot();
}
