package com.cucumbumbler.app;

import gherkin.formatter.Formatter;
import gherkin.formatter.Reporter;
import gherkin.formatter.model.Background;
import gherkin.formatter.model.Examples;
import gherkin.formatter.model.Feature;
import gherkin.formatter.model.Match;
import gherkin.formatter.model.Result;
import gherkin.formatter.model.Scenario;
import gherkin.formatter.model.ScenarioOutline;
import gherkin.formatter.model.Step;

import java.io.IOException;
import java.util.List;

public class CucumbumblerBumblerFormatter implements Reporter, Formatter {
	
	private Appendable bumblerOut;
	private Bumbler bumbler;
	
	public CucumbumblerBumblerFormatter(Appendable bumblerResults, Bumbler bumbler) {
		this.bumbler = bumbler;
		this.bumblerOut = bumblerResults;
	}
		
	private void bumble (String whatToBumble) {
		bumbler.say(whatToBumble);
	}
	
	private void bumbler (String whatToBumble) {
		bumble(whatToBumble);
		captureListen(bumbler.listen());		
	}

	private void captureListen(String listen) {
		try {
			bumblerOut.append(listen);
		} catch (IOException e) {
			;
		}	
	}
	
	public void scenario(Scenario scenario) {
		bumble(scenario.getName());
		bumble(scenario.getDescription());
	}
	
	public void examples(Examples examples) {
		bumble(examples.getDescription());
	}
	
	public void feature(Feature feature) {
		bumble(feature.getName());
		bumble(feature.getDescription());
	}
	
	public void background(Background background) {
		bumble(background.getKeyword());
		bumble(background.getName());		
	}
	
	public void scenarioOutline(ScenarioOutline scenarioOutline) {
		bumble(scenarioOutline.getDescription());
	}
	
	public void step(Step step) {
		bumbler(step.getKeyword() + step.getName());
	}
	
	public void syntaxError(String state, String event, List<String> legalEvents, String uri, Integer line)  {
		bumble(event.toString());
	}
	
	public void close() {
		;
	}
	
	public void done() {
		;
	}
	
	public void eof() {
		;
	}
	
	public void uri(String uri) {
		;
	}

	@Override
	public void startOfScenarioLifeCycle(Scenario scenario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void endOfScenarioLifeCycle(Scenario scenario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void before(Match match, Result result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void result(Result result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void after(Match match, Result result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void match(Match match) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void embedding(String mimeType, byte[] data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write(String text) {
		// TODO Auto-generated method stub
		
	}

}
