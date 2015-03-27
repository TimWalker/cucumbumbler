package com.cucumbumbler.app;

import static org.junit.Assert.assertTrue;
import gherkin.formatter.FilterFormatter;
import gherkin.parser.Parser;

import java.awt.print.Book;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.apache.commons.io.FileUtils;

/**
 * Unit test for main cucumbumblerBookFormatter class.
 */
public class CucumbumblerBookFormatterTest extends TestCase {

	List<String> filterList;
	StringBuilder bookContents = new StringBuilder();
	CucumbumblerBookFormatter cucumbumblerBookFormatter;
	FilterFormatter filterFormatter;
	Parser parser;	
	
	public void setUp()
	{
		filterList = new ArrayList<String>();
		filterList.add("@wip");
		bookContents = new StringBuilder();
		cucumbumblerBookFormatter = new CucumbumblerBookFormatter(bookContents);
    	filterFormatter = new FilterFormatter(cucumbumblerBookFormatter, filterList);
    	parser = new Parser(filterFormatter);	
	}
	
	public void testCucumberFeaturesCreateTheRightHTMLTag()
    {   
    	String expected="<H1>This is a test feature.</H1>";
    	String gherkin = "@wip \n"
    			+ "Feature: This is a test feature.\n"
    			+ "Scenario: This is a test scenario.";
 		parser.parse(gherkin, "", 0);
 		closeParser();
        assertTrue("Book Formatter should convert Features to HTML H1", bookContents.toString().indexOf(expected) > 0);

    }
	
	public void testCucumberBackgroundCreateTheRightHTMLTag()
    {   
    	String expected="<H2>This is a test background.</H2>";
    	String gherkin = "@wip \n"
    			+ "Feature: This is a test feature.\n"
    			+ "Background: This is a test background.\n"
    			+ "Scenario: This is a test scenario.";
 		parser.parse(gherkin, "", 0);
 		closeParser();
        assertTrue("Book Formatter should convert Background to HTML H2", bookContents.toString().indexOf(expected) > 0);
    }
	
	public void testCucumberScenariosCreateTheRightHTMLTag()
    {   
    	String expected="<H3>This is a test scenario.</H3>";
    	String gherkin = "@wip \n"
    			+ "Feature: This is a test feature\n"
    			+ "Scenario: This is a test scenario.";
 		parser.parse(gherkin, "", 0);
 		closeParser();
        assertTrue("Book Formatter should convert Scenarios to HTML H3", bookContents.toString().indexOf(expected) > 0);

    }
	
	public void testCucumberStepsCreateTheRightHTMLTag()
    {   
    	String expected="<pre>this is a test step.<pre>";
    	String gherkin = "@wip \n"
    			+ "Feature: This is a test feature.\n"
    			+ "Background: This is a test background.\n"
    			+ "Scenario: This is a test scenario.\n"
    			+ "    Hello, I am a test scenario\n\n"
    			+ "Given this is a test step.";
 		parser.parse(gherkin, "", 0);
 		closeParser();
 		assertTrue("Book Formatter should convert Given/When/Then to HTML pre", bookContents.toString().indexOf(expected) > 0);
    }
	
	private void closeParser() {
		cucumbumblerBookFormatter.done();
		cucumbumblerBookFormatter.close();
	}
}