package com.cucumbumbler.app;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;

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
    	parseFeatures();
    	//outputAsBook();
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
    
    public void parseFeatures() 
    {
    	List filterList = new ArrayList();
    	filterList.add("@wip");
    	StringBuilder json = new StringBuilder();
    	CucumbumblerBookFormatter cucumbumblerBookFormatter = new CucumbumblerBookFormatter(json);
    	FilterFormatter filterFormatter = new FilterFormatter(cucumbumblerBookFormatter, filterList);
    	Parser parser = new Parser(filterFormatter);
		for (Feature feature : features) {
			String gherkin = "";
			try {
				System.out.println("Parsing: " + feature.name);
				gherkin = new Scanner(new File(feature.name)).useDelimiter("\\Z").next();
				System.out.println("----> gherkin: \n" + gherkin);
				parser.parse(gherkin, feature.name, 0);
				System.out.println("** Parsed **" + feature.name);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			feature.parsed = true;
		}
		cucumbumblerBookFormatter.done();
		cucumbumblerBookFormatter.close();
		System.out.println("---> json: " + json);
    }
}