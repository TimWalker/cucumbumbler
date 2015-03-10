package com.cucumbumbler.app;

import static org.junit.Assert.assertTrue;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.PendingException;

public class CucumbumblerSteps {

    @Given("^there are feature files present$")
    public void there_are_feature_files_present() throws Throwable {
        Cucumbumbler cucumbumbler = new Cucumbumbler();
        Boolean thereAreFeatureFilesPresent = cucumbumbler.thereAreFeatureFilesPresent();
        assertTrue("There are feature files present.", thereAreFeatureFilesPresent);
    }

    @When("^I run \"(.*?)\"$")
    public void i_run(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^an HTML book is generated that has test results$")
    public void an_HTML_book_is_generated_that_has_test_results() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^Cucumbumbler interacts with a human to manually run tests$")
    public void cucumbumbler_interacts_with_a_human_to_manually_run_tests() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

}
