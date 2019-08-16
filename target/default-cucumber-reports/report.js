$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("/Users/syd/Downloads/cucumber_demo/src/test/resources/features/dbtesting");
formatter.feature({
  "name": "testing the database",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "checking data base",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@db"
    }
  ]
});
formatter.step({
  "name": "user connect to the data base",
  "keyword": "Given "
});
formatter.match({
  "location": "db_step_definition.user_connect_to_the_data_base()"
});
formatter.result({
  "error_message": "org.postgresql.util.PSQLException: An error occurred while setting up the SSL connection.\n\tat org.postgresql.core.v3.ConnectionFactoryImpl.enableSSL(ConnectionFactoryImpl.java:445)\n\tat org.postgresql.core.v3.ConnectionFactoryImpl.tryConnect(ConnectionFactoryImpl.java:94)\n\tat org.postgresql.core.v3.ConnectionFactoryImpl.openConnectionImpl(ConnectionFactoryImpl.java:192)\n\tat org.postgresql.core.ConnectionFactory.openConnection(ConnectionFactory.java:49)\n\tat org.postgresql.jdbc.PgConnection.\u003cinit\u003e(PgConnection.java:195)\n\tat org.postgresql.Driver.makeConnection(Driver.java:458)\n\tat org.postgresql.Driver.connect(Driver.java:260)\n\tat java.sql.DriverManager.getConnection(DriverManager.java:664)\n\tat java.sql.DriverManager.getConnection(DriverManager.java:247)\n\tat com.cybertek.step_definitions.db_step_definition.user_connect_to_the_data_base(db_step_definition.java:24)\n\tat ✽.user connect to the data base(/Users/syd/Downloads/cucumber_demo/src/test/resources/features/dbtesting:4)\n",
  "status": "failed"
});
formatter.step({
  "name": "user get employee names from employee table",
  "keyword": "When "
});
formatter.match({
  "location": "db_step_definition.user_get_employee_names_from_employee_table()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "user log in to Vytrack with valid credentials",
  "keyword": "Then "
});
formatter.match({
  "location": "db_step_definition.user_log_in_to_Vytrack_with_valid_credentials()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "user edit user information with employee name",
  "keyword": "And "
});
formatter.match({
  "location": "db_step_definition.user_edit_user_information_with_employee_name()"
});
formatter.result({
  "status": "skipped"
});
});