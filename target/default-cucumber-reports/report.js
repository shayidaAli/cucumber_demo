$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/login.feature");
formatter.feature({
  "name": "login test",
  "description": "",
  "keyword": "Feature"
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
  "keyword": "Scenario"
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
  "keyword": "Scenario"
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
});