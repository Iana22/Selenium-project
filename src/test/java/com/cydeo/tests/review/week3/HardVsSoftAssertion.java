package com.cydeo.tests.review.week3;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class HardVsSoftAssertion {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        //TC#1: Registration Form Page Testing
        // 1. Open Chrome browser
        // 2. Go to https://practice.cydeo.com/registration_form
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://practice.cydeo.com/registration_form");
    }

        @AfterMethod
        public void tearDownMethod(){
            driver.close();
        }

        @Test
        public void registraction_form_page_hardAssert_test(){
         // 3. Verify title is as expected:
         // Expected: "Registration Form"
         String expectedTitle = "Registration Form";
         String actualTitle = driver.getTitle();
         Assert.assertEquals (actualTitle, expectedTitle, "Title verification failed!");

         // 4. Select "SDET" from Job title dropdown
        Select selectJobtitle = new Select(driver.findElement(By.name("job_title")));
        //selectJobtitle.selectByVisibleText("SDET");
        selectJobtitle.selectByIndex(4); // index number starts from default 0 in dropdown options


         // 5. Verify "SDET" is selected
        String actualSelectedOption = selectJobtitle.getFirstSelectedOption().getText();
        String expectedSelectedOption = "SDET";
        Assert.assertEquals(actualSelectedOption, expectedSelectedOption);

         //other option to write above three lines
        //Assert.assertTrue(selectJobtitle.getFirstSelectedOption().getText().equals("SDET"));
    }

        @Test
        public void registraction_form_page_softAssert_test() {
            // 3. Verify title is as expected:
            // Expected: "Registration Form"
            String expectedTitle = "Registration Form";
            String actualTitle = driver.getTitle();
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertEquals(actualTitle, expectedTitle);

            // 4. Select "SDET" from Job title dropdown
            Select selectJobtitle = new Select(driver.findElement(By.name("job_title")));
            //selectJobtitle.selectByVisibleText("SDET");
            selectJobtitle.selectByIndex(4); // index number starts from default 0 in dropdown options


            // 5. Verify "SDET" is selected
            String actualSelectedOption = selectJobtitle.getFirstSelectedOption().getText();
            String expectedSelectedOption = "SDET";
            softAssert.assertEquals(actualSelectedOption, expectedSelectedOption);

            //if you don't use assertAll --> softAssert will not work
            // and assert checks will not be performed
            softAssert.assertAll();


        }
    }


