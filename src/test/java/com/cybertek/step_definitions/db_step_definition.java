package com.cybertek.step_definitions;

import com.cybertek.pages.LoginPage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class db_step_definition {

    Connection connection;
    Statement statement;
    ResultSet resultSet;

    @Given("user connect to the data base")
    public void user_connect_to_the_data_base() throws SQLException {
        //creating a connection to the database using jdbc

        connection = DriverManager.getConnection("jdbc:postgresql://room-reservation-qa.cxvqfpt4mc2y.us-east-1.rds.amazonaws.com:5432/hr",
                "hr",
                "hr");

        //to create statement and allow scroll back and forward (TYPE_SCROLL_INSENSITIVE)
        // then from statement we will create result set that will receive data based on query
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

    }

    @When("user get employee names from employee table")
    public void user_get_employee_names_from_employee_table() throws SQLException {

        //write SQL query
        String sql="select FirstName from employees";

        //we are running query (command)
        resultSet = statement.executeQuery(sql);

        //information about the data base -->meta data

        ResultSetMetaData mt=resultSet.getMetaData(); //getting resultset related information
        System.out.println(mt.toString());

        //get column count
        int count = mt.getColumnCount();
        System.out.println(count);


        //create a list which will hold column names
        List<String> columns = new ArrayList<>();

        //to loop through columns
        for(int i =1; i<=count;i++) {
            //we are adding columns one my one based on the index of column, starting from 1
            columns.add(mt.getColumnName(i));
        }

    }

    @Then("user log in to Vytrack with valid credentials")
    public void user_log_in_to_Vytrack_with_valid_credentials() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        LoginPage loginPage= new LoginPage();
        loginPage.login(ConfigurationReader.getProperty("driver_username"), ConfigurationReader.getProperty("driver_password"));

    }

    @Then("user edit user information with employee name")
    public void user_edit_user_information_with_employee_name() {
        System.out.println("user on the homepage");
    }

}
