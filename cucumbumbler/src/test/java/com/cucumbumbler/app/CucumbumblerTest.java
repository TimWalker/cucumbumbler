package com.cucumbumbler.app;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.apache.commons.io.FileUtils;

/**
 * Unit test for simple App.
 */
public class CucumbumblerTest extends TestCase {

	String FEATURE_DIR = "/tmp/cucumbumbler/features";

    public void testThatThereAreFeatureFilesPresentIsFalseWhenEmpty()
    {
        //Setup
        try {
			FileUtils.deleteDirectory(new File(FEATURE_DIR));
		} catch (IOException e) {
			System.out.println("Exception deleting cucumber features directory: " + e.getMessage());
		}

        Cucumbumbler cucumbumbler = new Cucumbumbler();
        Boolean thereAreFeatureFilesPresent = cucumbumbler.thereAreFeatureFilesPresent(FEATURE_DIR);
        assertFalse("Should be false when there are no feature files present.", thereAreFeatureFilesPresent);
    }
  
    public void testThatThereAreFeatureFilesPresentIsTrueWhenNotEmpty()
    {
        //Setup
        try {
			FileUtils.deleteDirectory(new File(FEATURE_DIR));
			FileUtils.forceMkdir(new File(FEATURE_DIR));
		} catch (IOException e) {
			System.out.println("Exception adding or deleting cucumber features directory: " + e.getMessage());
		}
        Cucumbumbler cucumbumbler = new Cucumbumbler();
        Boolean thereAreFeatureFilesPresent = cucumbumbler.thereAreFeatureFilesPresent(FEATURE_DIR);
        assertTrue("Should be true when there are feature files present.", thereAreFeatureFilesPresent);
    }
    
    public void testItShouldGetFeaturesFilesAtADirectory() {
    	deployTestFeatures(FEATURE_DIR);
        Cucumbumbler cucumbumbler = new Cucumbumbler();
        cucumbumbler.getFeatures(FEATURE_DIR);
        assertTrue("there should be an array of features: ", cucumbumbler.features.size() != 0);
    }

    public void testItShouldParseItsFeatures() {
    	deployTestFeatures(FEATURE_DIR);
        Cucumbumbler cucumbumbler = new Cucumbumbler();
        cucumbumbler.getFeatures(FEATURE_DIR);
        cucumbumbler.parseFeatures();
        for (Feature feature : cucumbumbler.features) {
        	assertTrue("feature should be marked as parsed: ", feature.parsed);
        }
    }
    //todo: refactor duplication
    private void deployTestFeatures(String feature_path) {
    	String srcDir = "src/test/resources/com/cucumbumbler/test_features";
    	String dstDir = feature_path;
    	try {
    		FileUtils.copyDirectory(new File(srcDir), new File(dstDir));
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }
}
