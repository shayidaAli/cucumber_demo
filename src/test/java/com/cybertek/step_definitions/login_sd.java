package com.cybertek.step_definitions;

import com.cybertek.pages.LoginPage;
import com.cybertek.pages.googleSearchPage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import java.util.concurrent.TimeUnit;

//STEP DEFINITIONS FOR LOGIN.FEATURE FILE

public class login_sd {

//Back Ground runs for each and every scenario.
    @Given("OPEN THE LOG IN PAGE")
    public void open_THE_LOG_IN_PAGE() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

//scenario 1: log in as driver
    @Then("user log in with username and password")
    public void user_log_in_with_username_and_password() {
        LoginPage loginPage= new LoginPage();
        loginPage.login(ConfigurationReader.getProperty("driver_username"), ConfigurationReader.getProperty("driver_password"));
    }

    @Then("user should be on the home page")
    public void user_on_the_home_page() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertEquals("Dashboard", Driver.getDriver().getTitle());
        Driver.closeDriver();
    }



//scenario 2: log in as store manager
    @Then("manager log in with username and password")
    public void manager_log_in_with_username_and_password() {
        LoginPage loginPage= new LoginPage();
        loginPage.login(ConfigurationReader.getProperty("StoreManager_username"), ConfigurationReader.getProperty("StoreManager_password"));
    }

    @Then("manager should be on the home page")
    public void manager_should_be_on_the_home_page() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertEquals("Dashboard", Driver.getDriver().getTitle());
        Driver.closeDriver();

    }


//scenario outline: LOG IN FOR DIFFERENT USERS
    @Given("user on the log in page")
    public void usen_on_the_log_in_page() {
    Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }


    @When("user enters valid {string} and {string}")
    public void user_enters_valid_and(String USERNAME, String PASSWORD) {
        LoginPage loginPage= new LoginPage();
        loginPage.login(USERNAME, PASSWORD);
    }

    @Then("login should be successful as a {string}")
    public void login_should_be_succesiful_as_a(String string) throws InterruptedException {
        Thread.sleep(3000);
        Driver.getDriver().manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        Assert.assertEquals("Dashboard", Driver.getDriver().getTitle());
        System.out.println("user log in as a "+ string);
        Driver.closeDriver();
    }



// scenario outline for google search functionality

    @Given("user on the search page")
    public void user_on_the_search_page() {
        Driver.getDriver().get("https://www.google.com/");
    }

    @When("user enters valid {string}")
    public void user_enters_valid(String INPUT) {
        googleSearchPage googleSearch=  new googleSearchPage();
        googleSearch.searchBox.sendKeys(INPUT);
        googleSearch.searchBox.sendKeys(Keys.ENTER);
    }

    @Then("title should contain the {string}")
    public void title_should_contain_the(String string) throws InterruptedException {
        Thread.sleep(3000);
        Driver.getDriver().manage().timeouts().implicitlyWait(7,TimeUnit.SECONDS);

        String title = Driver.getDriver().getTitle();
        Assert.assertTrue(title.contains(string));
    }



}
