package com.cucumbumbler.steps;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;

import org.apache.commons.io.FileUtils;

import com.cucumbumbler.app.Cucumbumbler;
import com.cucumbumbler.app.CucumbumblerCommandRunner;
import com.cucumbumbler.app.FakeBumbler;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.PendingException;
import cucumber.deps.com.thoughtworks.xstream.io.path.Path;

public class CucumbumblerSteps {
	
	String featurePath = "/tmp/cucumbumbler/features/";
	String resultFilePath = "/tmp/cucumbumbler/cucumbumbler_test_results.txt";
	
    @Given("^there are feature files present$")
    public void there_are_feature_files_present() throws Throwable {
    	cleanResults();
    	deployTestFeatures(featurePath);
    	Cucumbumbler cucumbumbler = new Cucumbumbler();
        Boolean thereAreFeatureFilesPresent = cucumbumbler.thereAreFeatureFilesPresent(featurePath);
        assertTrue("There should be feature files present.", thereAreFeatureFilesPresent);
    }
    
	@When("^I run \"(.*?)\"$")
    public void i_run(String command) throws Throwable {
		if (command.equals("make a book")) {
			makeABook();
		} else if (command.equals("manual testing")){
			manualTesting();
		} else {
	        throw new PendingException();	
		}	
    }
	
    @Then("^an HTML book is generated$")
    public void an_HTML_book_is_generated() throws Throwable {
    	File file = new File("/tmp/cucumbumbler/newBook.html");
    	assertTrue("A book was created: ", file.isFile());
    }

    @Then("^Cucumbumbler generates test results from the manual human interaction$")
    public void cucumbumbler_generates_test_results_from_the_manual_human_interaction() throws Throwable {
    	File file = new File(resultFilePath);
    	assertTrue("Cucumber Results were created: ", file.exists());
    }

    //instructional 
    @Given("^something$")
    public void something() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^an action is performed$")
    public void an_action_is_performed() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^something should be asserted$")
    public void something_should_be_asserted() throws Throwable {
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
    
    private void cleanResults()
    {
    	File file = new File(resultFilePath);
    	if (file.exists()) {
    		file.delete();
    	}
    }
   
    private void manualTesting()
    {
    	cleanResults();
    	String results = CucumbumblerCommandRunner.runCommand("./cucumbumbler --bumble -f " + featurePath);
       	try {
			PrintWriter out = new PrintWriter(resultFilePath);
			out.println(results);
			out.flush();
			out.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error with results file in manual testing: " + e.getMessage());
		}
    }
}
