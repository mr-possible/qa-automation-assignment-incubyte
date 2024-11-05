package com.incubyte.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
    plugin = {"html:target/cucumber/CucumberTestReport.html"},
    glue = {"com.incubyte"},
    features = "src/test/resources/features"
)
public class TestNGRunner extends AbstractTestNGCucumberTests {

  @Override
  @DataProvider(parallel = true)
  public Object[][] scenarios() {
    return super.scenarios();
  }
}
