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
	
	public void testCucumberScenariosCreateTheRightHTMLTag()
    {   
    	String gherkin = "@wip \n"
    			+ "Feature: \n"
    			+ "Scenario: This is a test scenario.";
    	String expected="<H3>This is a test scenario.</H3>";
 		parser.parse(gherkin, "", 0);
        assertTrue("Book Formatter should convert Scenarios in to HTML H2s", bookContents.toString().indexOf(expected) > 0);

    }
}