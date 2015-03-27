@wip
Feature: Introduction
	Cucumbumbler is a Cucumber Bumbler. By that we mean it Bumbles Cucumbers. 
	
	To Bumble your Cucumber means you want to manage Cucumber to provide full application
	life cycle Specifications, including the aggregation of them, to specify all aspects of
	the system, for example, in all the testing quadrants, including: 
	   manual testing, functional, non-functional and integration with static code analysis
	
	Background: What are Cucumber Feature Files?   
		Cucumber feature files are executable specifations used in a software
		development process known as "specification by example". It's also called "BDD Behavior Driven Development".
		They are plain text files containing Gherkin, a language for BDD. This documentation itself is written entirely
		using Cucumber gherkin. For example:
		 
		Given a team is using 'specification by example'
		When they apply it regularly in their test-first practices
		Then a very powerful single source-of-truth emerges that is both a specification and automated behavior verification		
	
	Scenario: I use Cucumber features to create a living system "book"
       	In order to create a single source-of-truth about my product
  		As a system developing a product
  		I want to manage all my quadrant tests

    	As a process implementing software (or hardware) in any industry
    	I'd like to organize a single source-of-truth in a "book" format using executable specifications
    	So that I have a single, transparent, reference to the software endeavor

    	Given there are feature files present in "/tmp/cucumbumbler/features/";
    	When I run "make a book"
    	Then an HTML book is generated that has test results

	Scenario: Run a manual test
  		As a process implementing software (or hardware) in any industry
  		I'd like to be able to run manual and exploratory tests against the system
  		So that I can perform the highest ROI kinds of manual testing and augment automation

    	Given there are feature files present in "/tmp/cucumbumbler/features/";
    	When I run "manual testing"
    	Then Cucumbumbler interacts with a human to manually run tests
     