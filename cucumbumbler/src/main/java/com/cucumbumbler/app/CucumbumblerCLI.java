package com.cucumbumbler.app;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class CucumbumblerCLI {
 private static final Logger log = Logger.getLogger(CucumbumblerCLI.class.getName());
 private String[] args = null;
 private Options options = new Options();
 private String featureDir = "";

 public CucumbumblerCLI(String[] args) {	 
	 this.args = args;

	 options.addOption("h", "help", false, "show help.");
	 options.addOption("b", "bumble", false, "bumble features (manual testing)");
	 options.addOption("p", "publish", false, "publish a book");
	 options.addOption("f", "features", true, "path to your Cucumber features");
  }

 public void parse() {
	 CommandLineParser parser = new BasicParser();

	 CommandLine cmd = null;
	 try {
		cmd = parser.parse(options, args);

		if (cmd.hasOption("h")){
			 help();
			 return;
		}

		if (cmd.hasOption("f")) {
			featureDir = cmd.getOptionValue("f");
		} else {
			 log.log(Level.SEVERE, "You must provide a location for feature files.");
			 help();	
		}
		
		if (cmd.hasOption("b")) {
			bumble();
		}
		
		if (cmd.hasOption("p")) {
			publish();
		}

	 } 
	 catch (ParseException e) {
		 log.log(Level.SEVERE, "Sorry, I didn't understand that.", e);
		 help();
	 }
 }


 private void bumble() {
	 System.out.println("Welcome to Cucumbumbler. Bumbling");
	 Cucumbumbler cucumbumbler = new Cucumbumbler();
	 cucumbumbler.manualTesting(featureDir);	 
 }
 
 private void publish() {
	 System.out.println("Welcome to Cucumbumbler. Publishing.");
	 Cucumbumbler cucumbumbler = new Cucumbumbler();
	 cucumbumbler.makeABook(featureDir);
 }
 
 private void help() {
	 HelpFormatter formater = new HelpFormatter();
	 formater.printHelp("cucumbumbler", options);
	 System.exit(0);
 }

}
