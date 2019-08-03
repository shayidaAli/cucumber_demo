$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/login.feature");
formatter.feature({
  "name": "login test",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@wip"
    }
  ]
});
formatter.background({
  "name": "user on the log in page",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "OPEN THE LOG IN PAGE",
  "keyword": "Given "
});
formatter.match({
  "location": "login_sd.open_THE_LOG_IN_PAGE()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "login as a driver",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@wip"
    }
  ]
});
formatter.step({
  "name": "user log in with username and password",
  "keyword": "Then "
});
formatter.match({
  "location": "login_sd.user_log_in_with_username_and_password()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user should be on the home page",
  "keyword": "Then "
});
formatter.match({
  "location": "login_sd.user_on_the_home_page()"
});
formatter.result({
  "status": "passed"
});
formatter.background({
  "name": "user on the log in page",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "OPEN THE LOG IN PAGE",
  "keyword": "Given "
});
formatter.match({
  "location": "login_sd.open_THE_LOG_IN_PAGE()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "log in as a storeManager",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@wip"
    }
  ]
});
formatter.step({
  "name": "manager log in with username and password",
  "keyword": "Then "
});
formatter.match({
  "location": "login_sd.manager_log_in_with_username_and_password()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "manager should be on the home page",
  "keyword": "Then "
});
formatter.match({
  "location": "login_sd.manager_should_be_on_the_home_page()"
});
formatter.result({
  "status": "passed"
});
formatter.scenarioOutline({
  "name": "log in as different user",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "user on the log in page",
  "keyword": "Given "
});
formatter.step({
  "name": "user enters valid \"\u003cusername\u003e\" and \"\u003cpassword\u003e\"",
  "keyword": "When "
});
formatter.step({
  "name": "login should be successful as a \"\u003cperson\u003e\"",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "username",
        "password",
        "person"
      ]
    },
    {
      "cells": [
        "user189",
        "UserUser123",
        "driver"
      ]
    },
    {
      "cells": [
        "storemanager222",
        "UserUser123",
        "stor_manager"
      ]
    },
    {
      "cells": [
        "salesmanager285",
        "UserUser123",
        "sale_manager"
      ]
    }
  ]
});
formatter.background({
  "name": "user on the log in page",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "OPEN THE LOG IN PAGE",
  "keyword": "Given "
});
formatter.match({
  "location": "login_sd.open_THE_LOG_IN_PAGE()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "log in as different user",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@wip"
    }
  ]
});
formatter.step({
  "name": "user on the log in page",
  "keyword": "Given "
});
formatter.match({
  "location": "login_sd.usen_on_the_log_in_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user enters valid \"user189\" and \"UserUser123\"",
  "keyword": "When "
});
formatter.match({
  "location": "login_sd.user_enters_valid_and(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "login should be successful as a \"driver\"",
  "keyword": "Then "
});
formatter.match({
  "location": "login_sd.login_should_be_succesiful_as_a(String)"
});
formatter.result({
  "status": "passed"
});
formatter.background({
  "name": "user on the log in page",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "OPEN THE LOG IN PAGE",
  "keyword": "Given "
});
formatter.match({
  "location": "login_sd.open_THE_LOG_IN_PAGE()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "log in as different user",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@wip"
    }
  ]
});
formatter.step({
  "name": "user on the log in page",
  "keyword": "Given "
});
formatter.match({
  "location": "login_sd.usen_on_the_log_in_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user enters valid \"storemanager222\" and \"UserUser123\"",
  "keyword": "When "
});
formatter.match({
  "location": "login_sd.user_enters_valid_and(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "login should be successful as a \"stor_manager\"",
  "keyword": "Then "
});
formatter.match({
  "location": "login_sd.login_should_be_succesiful_as_a(String)"
});
formatter.result({
  "status": "passed"
});
formatter.background({
  "name": "user on the log in page",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "OPEN THE LOG IN PAGE",
  "keyword": "Given "
});
formatter.match({
  "location": "login_sd.open_THE_LOG_IN_PAGE()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "log in as different user",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@wip"
    }
  ]
});
formatter.step({
  "name": "user on the log in page",
  "keyword": "Given "
});
formatter.match({
  "location": "login_sd.usen_on_the_log_in_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user enters valid \"salesmanager285\" and \"UserUser123\"",
  "keyword": "When "
});
formatter.match({
  "location": "login_sd.user_enters_valid_and(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "login should be successful as a \"sale_manager\"",
  "keyword": "Then "
});
formatter.match({
  "location": "login_sd.login_should_be_succesiful_as_a(String)"
});
formatter.result({
  "error_message": "org.junit.ComparisonFailure: expected:\u003c[Dashboard]\u003e but was:\u003c[Loading...]\u003e\n\tat org.junit.Assert.assertEquals(Assert.java:115)\n\tat org.junit.Assert.assertEquals(Assert.java:144)\n\tat com.cybertek.step_definitions.login_sd.login_should_be_succesiful_as_a(login_sd.java:65)\n\tat ✽.login should be successful as a \"sale_manager\"(src/test/resources/features/login.feature:22)\n",
  "status": "failed"
});
});