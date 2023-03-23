package com.run;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features= "src\\test\\resources\\features", glue = "com.steps" )
public class TestRunner extends AbstractTestNGCucumberTests {
	

}
