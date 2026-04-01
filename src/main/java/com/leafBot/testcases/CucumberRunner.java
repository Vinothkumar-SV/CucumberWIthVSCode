package com.leafBot.testcases;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/main/java/features", glue = "src/main/java/com/leafBot/testcases/steps", monochrome = true)
public class CucumberRunner extends AbstractTestNGCucumberTests {

}
