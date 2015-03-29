package com.cucumbumbler.app;

import java.util.Scanner;

public class StandardBumbler implements Bumbler {

	public void say(String whatToSay) {
		System.out.println(whatToSay);
	}

	public String listen() {
		Scanner in = new Scanner(System.in);
	    String response = in.next();
	    return response;
	}

}
