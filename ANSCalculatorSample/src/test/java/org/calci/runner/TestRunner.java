package org.calci.runner;

import org.calci.helper.BaseClass;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\java\\org\\calci\\feature", glue="org.calci.stepdefnition")
public class TestRunner extends BaseClass{

	@BeforeClass
	public static void browserLaunch() throws Exception {
		browser_LaunchIgnoreCase("chrome");
	}
	
	@AfterClass
	public static void browserQuit() {
		browserQuit();
	}
}
