# CREATED FEATURES WITH GHERKIN LANGUAGE

@wip
Feature:  login test

  Background:  user on the log in page
    Given  OPEN THE LOG IN PAGE


  Scenario: login as a driver
    Then user log in with username and password
    Then user should be on the home page

  Scenario: log in as a storeManager
    Then manager log in with username and password
    Then manager should be on the home page



  Scenario Outline: log in as different user
    Given user on the log in page
    When user enters valid "<username>" and "<password>"
    Then login should be successful as a "<person>"
    Examples:
      | username | password | person|
      | user189 | UserUser123 | driver |
      | storemanager222 | UserUser123 | stor_manager |
      | salesmanager285 | UserUser123 | sale_manager |



#  create it as Scenario outline;
#  add the keywords
#  add Examples which includes keyword and its input value

#    ---everytime we run a scenario outline, each line of input(example table) replaces the key word, runs as a new scenario



  Scenario:  Search funtionality for google
    Given User on the search page
    When  User enters valid "<input>"
    Then  Title should contain the "<input>"

    |macbook|
    |cucumber|
    |selenium|
    |cherry  |
    |dashbord|





