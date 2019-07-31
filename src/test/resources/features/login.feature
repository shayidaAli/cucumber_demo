Feature:  login test

  Background:  user on the log in page
    Given  OPEN THE LOG IN PAGE



  Scenario: login as a driver
    Then user log in with username and password
    Then user should be on the home page

  Scenario: log in as a storeManager
    Then manager log in with username and password
    Then manager should be on the home page


