package com.cucumbumbler.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StandardBumbler implements Bumbler {

	public void say(String whatToSay) {
		System.out.println(whatToSay);
	}

	public String listen() {
		return System.console().readLine();
	}

}
