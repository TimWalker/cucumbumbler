package com.cucumbumbler.app;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.htmlparser.Node;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;
import org.htmlparser.util.ParserFeedback;

import gherkin.parser.Parser;
import gherkin.formatter.*;

public class Cucumbumbler
{    
	List<Feature> features = new ArrayList<Feature>();	
	
    public Boolean thereAreFeatureFilesPresent(String feature_folder) {
    	Path feature_path = Paths.get(feature_folder);
        return Files.exists(feature_path);
    }

    public void makeABook(String featurePath) 
    {
    	getFeatures(featurePath);
    	StringBuilder bookContents = parseFeatures();
    	File bookPath = new File(featurePath).getParentFile();
    	outputAsBook(bookPath + "/newBook.html", bookContents);
    }
    
    public void outputAsBook(String filePath, StringBuilder bookContents) {
    	try {
			FileUtils.writeStringToFile(new File(filePath), bookContents.toString()) ;
		} catch (IOException e) {
			System.out.println("Error writing to your new book: " + e.getMessage());
		}
	}

	public void getFeatures(String featurePath)
    {
    	@SuppressWarnings("unchecked")
		Iterator<File> it = FileUtils.iterateFiles(new File(featurePath), null, true);
        while(it.hasNext()){
        	String featureName = it.next().getPath();
        	features.add(new Feature(featureName));
        }
    }
    
    public StringBuilder parseFeatures() 
    {
    	List<String> filterList = new ArrayList<String>();
    	filterList.add("@wip");
    	StringBuilder bookContents = new StringBuilder();
    	CucumbumblerBookFormatter cucumbumblerBookFormatter = new CucumbumblerBookFormatter(bookContents);
    	FilterFormatter filterFormatter = new FilterFormatter(cucumbumblerBookFormatter, filterList);
    	Parser parser = new Parser(filterFormatter);
		for (Feature feature : features) {
			String gherkin = "";
			try {
				/* read feature file */
				gherkin = new Scanner(new File(feature.name)).useDelimiter("\\Z").next();
                /* parse cucumber */
				parser.parse(gherkin, feature.name, 0);
			} catch (FileNotFoundException e) {
	        	System.out.println("Error parsing Cucumber:   " + e.getMessage());
			}
			feature.parsed = true;
		}
		cucumbumblerBookFormatter.done();
		cucumbumblerBookFormatter.close();
		return bookContents;
    }

	public boolean validateHTML(StringBuilder bookContents) {
		try
        {
            org.htmlparser.Parser htmlparser = new org.htmlparser.Parser();
			htmlparser.setInputHTML(bookContents.toString());
			htmlparser.setEncoding("UTF-8");    
            NodeList list = htmlparser.parse (null);   
            return (list.size() > 0);
        }
        catch (ParserException pe)
        {
        	System.out.println("Error parsing generated HTML." + pe.getMessage());
        	return false;
        }
	}

	public String manualTesting(String featurePath)
	{
		getFeatures(featurePath);
    	return parseFeaturesAsHumanTester(new StandardBumbler());
	}
	
	public String manualTesting(String featurePath, Bumbler bumbler)
	{
		getFeatures(featurePath);
    	return parseFeaturesAsHumanTester(bumbler);
	}
	
	public String parseFeaturesAsHumanTester(Bumbler bumbler) {
    	List<String> filterList = new ArrayList<String>();
    	filterList.add("@wip");
    	StringBuilder results = new StringBuilder();
    	CucumbumblerBumblerFormatter cucumbumblerBumblerFormatter = new CucumbumblerBumblerFormatter(results, bumbler);
    	FilterFormatter filterFormatter = new FilterFormatter(cucumbumblerBumblerFormatter, filterList);
    	Parser parser = new Parser(filterFormatter);
		for (Feature feature : features) {
			String gherkin = "";
			try {
				gherkin = new Scanner(new File(feature.name)).useDelimiter("\\Z").next();
				parser.parse(gherkin, feature.name, 0);
			} catch (FileNotFoundException e) {
	        	System.out.println("Error parsing Cucumber:   " + e.getMessage());
			}
			feature.parsed = true;
		}
		return results.toString();
	}
}