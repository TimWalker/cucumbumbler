package com.cucumbumbler.app;

import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    format = {"pretty"},
    features="src/test/resources"
)
public class RunCukesTest {
}