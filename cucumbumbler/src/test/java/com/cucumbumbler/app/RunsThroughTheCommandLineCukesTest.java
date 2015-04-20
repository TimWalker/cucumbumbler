package com.cucumbumbler.app;

import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		glue = "com.cucumbumbler.steps",
		features = "src/test/resources/com/cucumbumbler/app",
		tags = "~@wip @runsthroughthecommandline",
		format = "pretty"
)
public class RunsThroughTheCommandLineCukesTest {
}