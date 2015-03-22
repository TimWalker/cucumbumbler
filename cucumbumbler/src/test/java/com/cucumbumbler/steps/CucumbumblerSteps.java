package com.cucumbumbler.steps;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.cucumbumbler.app.Cucumbumbler;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.PendingException;

public class CucumbumblerSteps {
	
	String featurePath = "";

    @Given("^there are feature files present in \"(.*?)\";$")
    public void there_are_feature_files_present_in(String featurePath) throws Throwable {
    	this.featurePath = featurePath;
    	deployTestFeatures(featurePath);
    	Cucumbumbler cucumbumbler = new Cucumbumbler();
        Boolean thereAreFeatureFilesPresent = cucumbumbler.thereAreFeatureFilesPresent(featurePath);
        assertTrue("There should be feature files present.", thereAreFeatureFilesPresent);
    }
    
	@When("^I run \"(.*?)\"$")
    public void i_run(String command) throws Throwable {
		if (command.equals("make a book")) {
			makeABook();
		} else {
	        throw new PendingException();	
		}
	
    }
	
    @Then("^an HTML book is generated$")
    public void an_HTML_book_is_generated() throws Throwable {
    	File file = new File("/tmp/cucumbumbler/newBook.html");
    	assertTrue("A book was created: ", file.isFile());
    }

    @Then("^Cucumbumbler interacts with a human to manually run tests$")
    public void cucumbumbler_interacts_with_a_human_to_manually_run_tests() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    private void deployTestFeatures(String feature_path) {
    	String srcDir = "src/test/resources/com/cucumbumbler/test_features";
    	String dstDir = feature_path;
    	try {
    		FileUtils.copyDirectory(new File(srcDir), new File(dstDir));
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }

    private void makeABook()
    {
    	Cucumbumbler cucumbumbler = new Cucumbumbler();
    	cucumbumbler.makeABook(featurePath);
    }
}
