package com.cydeo.tests.base;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

//this class is parent for all Test classes
//abstract because we are not creating objects
// you can update this class based on what you are keep writing in your most Test Classes
//instead writing all test classes you can just write in this class
//and you can extend this class from any Test class
public abstract class TestBase {
    protected WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDownMethod() {

        driver.close();
    }
}