package com.cucumbumbler.app;

public class FakeBumbler implements Bumbler {
    String said = "";

   	public void say(String whatToSay) {
   		said = whatToSay;
   	}
   
    public String listen() {
   	    return "Y";
	}  

}
