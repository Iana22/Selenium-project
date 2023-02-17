package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_Registration_Form {
    //TC#1: Registration form confirmation
    //1. Open browser
    //2. Go to website: https://practice.cydeo.com/registration_form
    @Test
    public void registration_form() {
        //Driver.getDriver() --> will return "driver
        Driver.getDriver().get(ConfigurationReader.getProperty("registration.form.url"));

        //3. Enter first name
        WebElement inputFirstName = Driver.getDriver().findElement(By.xpath
                ("//input[@name='firstname']"));
        inputFirstName.sendKeys("Jane");

        //4. Enter last name
        WebElement inputLastName = Driver.getDriver().findElement(By.xpath
                ("//input[@name='lastname']"));
        inputLastName.sendKeys("Doe");

        //5. Enter username
        WebElement inputUsername = Driver.getDriver().findElement(By.xpath
                ("//input[@name='username']"));
        inputUsername.sendKeys("janedoe58");

        //6. Enter email address
        WebElement inputEmailAddress = Driver.getDriver().findElement(By.xpath
                ("//input[@name='email']"));
        inputEmailAddress.sendKeys("janedoe58@gmail.com");

        //7. Enter password
        WebElement inputPassword = Driver.getDriver().findElement(By.xpath
                ("//input[@name='password']"));
        inputPassword.sendKeys("Jane_1230");

        //8. Enter phone number
        WebElement inputPhone = Driver.getDriver().findElement(By.xpath
                ("//input[@name='phone']"));
        inputPhone.sendKeys("236-115-2635");

        //9. Select a gender from radio buttons
        WebElement radioBtnFemale = Driver.getDriver().findElement(By.xpath
                ("//input[@value ='female']"));
        radioBtnFemale.click();

        //10.Enter date of birth
        WebElement inputBirthday = Driver.getDriver().findElement(By.xpath
                ("//input[@name ='birthday']"));
        inputBirthday.sendKeys("11/22/2023");

        //11.Select Department/Office
        Select departmentDropdown = new Select(Driver.getDriver().findElement(By.name
                ("department")));
        departmentDropdown.selectByVisibleText("Department of Engineering");
        //departmentDropdown.selectByValue("DE");

        //12.Select Job Title
        Select jobTitleDropdown = new Select(Driver.getDriver().findElement(By.name
                ("job_title")));
        jobTitleDropdown.selectByVisibleText("SDET");

        //13.Select programming language from checkboxes
        WebElement javaCheckbox = Driver.getDriver().findElement(By.xpath
                ("//input[@value='java']"));
        javaCheckbox.click();

        //14.Click to sign up button
        WebElement signUpButton = Driver.getDriver().findElement(By.id("wooden_spoon"));
        signUpButton.click();

        //15.Verify success message “You’ve successfully completed registration.” is
        WebElement successMsg = Driver.getDriver().findElement(By.xpath("//div[@role = 'alert']"));
        Assert.assertTrue(successMsg.isDisplayed());

        //driver.quit();
        //Driver.getDriver().quit(); --> we don't use this method anymore. Because we want to assign the value back to null
        // So if we have another test, our code can continue executing.
        Driver.closeDriver();

    }
}