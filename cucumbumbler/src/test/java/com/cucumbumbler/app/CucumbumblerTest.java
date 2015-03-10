package com.cucumbumbler.app;

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

    public void testThatThereAreFeatureFilesPresentWhenEmpty()
    {
        //Setup
        try {
			FileUtils.deleteDirectory(new File("/tmp/cucumbumbler/testfeatures"));
		} catch (IOException e) {
			System.out.println("Exception deleting cucumber features directory: " + e.getMessage());
		}

        Cucumbumbler cucumbumbler = new Cucumbumbler();

    }

}
