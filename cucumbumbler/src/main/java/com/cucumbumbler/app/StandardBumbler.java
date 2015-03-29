package com.cucumbumbler.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StandardBumbler implements Bumbler {

	public void say(String whatToSay) {
		System.out.println(whatToSay);
	}

	public String listen() {
		String input="";
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 
			while((input=br.readLine())!=null){
			}
	 
		}catch(IOException io){
			io.printStackTrace();
		}	
		return input;
	}

}
