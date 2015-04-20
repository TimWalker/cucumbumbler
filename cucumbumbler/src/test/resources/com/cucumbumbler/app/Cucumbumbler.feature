Feature: Cucumbumbler main functionality
  In order to create a single source-of-truth about my product
  As a system developing a product
  I want to manage all my quadrant tests

  Scenario: Generate a book
  	As a process implementing software (or hardware) in any industry
  	I'd like to organize a single source-of-truth in a "book" format using executable specifications
  	So that I have a single, transparent, reference to the software endeavor

  	Given there are feature files present
  	When I run "make a book"
  	Then an HTML book is generated

  @runsthroughthecommandline
  @wip
  Scenario: Run a manual test
     As a process implementing software (or hardware) in any industry
     I'd like to be able to run manual and exploratory tests against the system
     So that I can perform the highest ROI kinds of manual testing and augment automation

     Given there are feature files present
     When I run "manual testing"
     Then Cucumbumbler generates test results from the manual human interaction 
