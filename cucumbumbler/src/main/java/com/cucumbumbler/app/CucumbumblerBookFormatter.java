package com.cucumbumbler.app;

//import gherkin.deps.com.google.gson.Gson;
//import gherkin.deps.com.google.gson.GsonBuilder;
//import gherkin.deps.net.iharder.Base64;
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

public class CucumbumblerBookFormatter implements Reporter, Formatter {
	private Appendable out;
	
	public void openBook() {
		try {
			out.append("<html>");
		} catch (IOException e) {
		}
	}
	
	public void closeBook() {
			try {
			out.append("</html>");
		} catch (IOException e) {
		}
	}
	
	public CucumbumblerBookFormatter(Appendable out) {
		this.out = out;
		openBook();
	}
		
	public void to_tag(String tag, String text) {
		String startTag = "";
		String endTag = "";
		if (tag.equals("featureDesc")){
			startTag = "<H3>";
			endTag = "</H3>";
		}
		else if (tag.equals("featureName")){
			startTag = "<H1>";
			endTag = "</H1>";
		}
		else if (tag.equals("backgroundName")){
			startTag = "<H2>";
			endTag = "</H2>";
		}
		else if (tag.equals("scenarioName")){
			startTag = "<H3>";
			endTag = "</H3>";
		}
		else if (tag.equals("scenarioDesc")){
			startTag = "<div>";
			endTag = "</div>";
		}
		else if (tag.equals("scenarioOutline")){
			startTag = "<b>";
			endTag = "</b>";
		}
		else if (tag.equals("examples")){
			startTag = "<H5>";
			endTag = "</H6>";
		}
		else if (tag.equals("stepKeyword")){
			startTag = "<pre>";
			endTag = "</pre>";
		}
		else if (tag.equals("stepName")){
			startTag = "<pre>";
			endTag = "<pre>";
		}
		else {
			startTag = "<p>";
			endTag = "</p>";
		}
		buildBook(startTag + text + endTag);
	}

	private void buildBook(String text) {
		try {
			out.append(text);
		} catch (IOException e) {
		}
	}
	
	public void scenario(Scenario scenario) {
		to_tag("scenarioName", scenario.getName());
		to_tag("scenarioDesc", scenario.getDescription());
	}
	
	public void close() {
		;
	}
	
	public void done() {
		closeBook();
	}
	
	public void eof() {
		;
	}
	
	public void examples(Examples examples) {
		to_tag("examples", examples.getDescription());
	}
	
	public void feature(Feature feature) {
		to_tag("featureName", feature.getName());
		to_tag("featureDesc", feature.getDescription());
	}
	
	public void background(Background background) {
		to_tag("backgroundKeyword", background.getKeyword());
		to_tag("backgroundName", background.getName());		
	}
	
	public void scenarioOutline(ScenarioOutline scenarioOutline) {
		to_tag("scenario", scenarioOutline.getDescription());
	}
	
	public void step(Step step) {
		to_tag("stepKeyword", step.getKeyword());
		to_tag("stepName", step.getName());
	}
	
	public void syntaxError(String state, String event, List<String> legalEvents, String uri, Integer line)  {
		to_tag("error", event.toString());
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
