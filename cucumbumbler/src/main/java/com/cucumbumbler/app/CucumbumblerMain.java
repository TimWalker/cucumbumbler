package com.cucumbumbler.app;

public class CucumbumblerMain {	
	public static void main(String[] args) {
		System.out.println("Welcome to Cucumbumbler!");
		Cucumbumbler cucumbumbler = new Cucumbumbler();
		cucumbumbler.makeABook("/tmp/cucumbumbler/features/");
		cucumbumbler.manualTesting("/tmp/cucumbumbler/features/");
	}
}
