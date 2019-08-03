package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



//TO LOCTE THE ELEMENTS ON THIS WEB PAGE USEING PAGE FACTORY

public class googleSearchPage {

    public googleSearchPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // Webelement element= driver.findElement(By.id/xpath/css/className...

    @FindBy(id = "fakebox-input")
    public WebElement searchBox;

}
