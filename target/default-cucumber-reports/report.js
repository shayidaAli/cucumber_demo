$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("/Users/syd/Downloads/cucumber_demo/src/test/resources/features/table.feature");
formatter.feature({
  "name": "Cucumber can convert a Gherkin data table to a list of a type you specify.",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "update username based on the DBase",
  "description": "    Given: connect to the database with java\n    When: retrieving 20 names from employees table with sq\n    Then: save names as a name list\n    And: using name list to update username for user in the UI",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@db"
    }
  ]
});
});