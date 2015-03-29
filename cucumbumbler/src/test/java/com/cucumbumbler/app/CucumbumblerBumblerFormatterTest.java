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
public class CucumbumblerBumblerFormatterTest extends TestCase {

	List<String> filterList;
	StringBuilder bumblerResults = new StringBuilder();
	CucumbumblerBumblerFormatter cucumbumblerBumblerFormatter;
	FilterFormatter filterFormatter;
	Parser parser;	
	
	public void setUp()
	{
		filterList = new ArrayList<String>();
		filterList.add("@wip");
		bumblerResults = new StringBuilder();
		
		cucumbumblerBumblerFormatter = new CucumbumblerBumblerFormatter(bumblerResults, new FakeBumbler());
    	filterFormatter = new FilterFormatter(cucumbumblerBumblerFormatter, filterList);
    	parser = new Parser(filterFormatter);	
	}
	
	public void testTheBumblerFormatterShouldReturnTheExpectedResultsFromABumbler()
    {   
    	String expected="YYY";
    	String gherkin = "@wip \n"
    			+ "Feature: This is a test feature.\n"
    			+ "Background: This is a test background.\n"
    			+ "Scenario: This is a test scenario.\n"
    			+ "Hello, I am a test scenario\n"
    			+ "Given this is Given step\n"
				+ "When this is a When step\n"
				+ "Then this is a Then step\n";
 		parser.parse(gherkin, "", 0);
 		assertTrue("Bumbler Formatter should produce the expected results ", bumblerResults.toString().equals(expected));
    }
	
}