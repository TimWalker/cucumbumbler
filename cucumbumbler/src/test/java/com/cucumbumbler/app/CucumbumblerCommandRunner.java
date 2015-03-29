package com.cucumbumbler.app;

import gherkin.deps.net.iharder.Base64.OutputStream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CucumbumblerCommandRunner {
	
	public static String runCommand(String commandToRun) {
		
		StringBuffer results = new StringBuffer(); 
		String s = null;
	 
		try {
         
			System.out.println("Running: " + commandToRun);
			
			Process p = Runtime.getRuntime().exec(commandToRun);
         
			java.io.OutputStream stdOut = p.getOutputStream();
			
			BufferedReader stdInput = new BufferedReader(new
					InputStreamReader(p.getInputStream()));

			BufferedReader stdError = new BufferedReader(new
					InputStreamReader(p.getErrorStream()));

			System.out.println("Here is the standard output of the command:\n");
			while ((s = stdInput.readLine()) != null) {
				stdOut.write('Y');
				stdOut.write('\n');
				stdOut.flush();
				System.out.println(s);
				results.append(s);
			}
         
			// read any errors from the attempted command
			System.out.println("Here is the standard error of the command (if any):\n");
			while ((s = stdError.readLine()) != null) {
				System.out.println(s);
				results.append(s);
			}
  		}
		catch (IOException e) {
			System.out.println("exception happened - here's what I know: ");
			e.printStackTrace();
			System.exit(-1);
		}
		return results.toString();
	}
	
}
