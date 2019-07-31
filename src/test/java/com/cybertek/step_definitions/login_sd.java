package com.cybertek.step_definitions;

import com.cybertek.pages.LoginPage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;

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
    }


}
