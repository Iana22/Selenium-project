package com.cydeo.tests.day07__webtables_utilities_javafaker;

import com.cydeo.tests.base.TestBase;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.CRM_Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class T4_CRM_Login_Task extends TestBase{

    //TC #4: Login scenario
    //1. Create new test and make setups
    //2. Go to: http://login1.nextbasecrm.com/

    @Test
    public void test1_crm_login() {

        driver.get("http://login1.nextbasecrm.com/");

        //3. Enter valid username
        WebElement inputUserName = driver.findElement(By.xpath("//input[@name ='USER_LOGIN']"));
        inputUserName.sendKeys("helpdesk1@cydeo.com");

        //4. Enter valid password
        WebElement inputPassword = driver.findElement(By.xpath("//input[@name = 'USER_PASSWORD']"));
        inputPassword.sendKeys("UserUser");


        //5. Click to `Log In` button
        WebElement logInBtn = driver.findElement(By.xpath("//input[@class='login-btn']"));
        logInBtn.click();

        //6. Verify title is as expected:
        //Expected: Portal

        BrowserUtils.sleep(3);
        BrowserUtils.verifyTitle(driver, "Portal");
        //USERNAME PASSWORD
        //helpdesk1@cydeo.com UserUser
        //helpdesk2@cydeo.com UserUse
    }

    @Test
    public void test2_crm_login() {

        //Logging in using the utility method we created in CRM_Utilities class
        CRM_Utilities.login_crm(driver);

        //6. Verify title is as expected:
        // Expected: Portal
        // We are waiting 3 secs for title to be loaded to "(2) Portal"
        BrowserUtils.sleep(3);
        BrowserUtils.verifyTitle(driver, "(2) Portal");

    }

    @Test
    public void test3_crm_login() {

        //Logging in using the utility method we created in CRM_Utilities class
        //CRM_Utilities.login_crm(driver, "helpdesk1@cydeo.com", "UserUser");
        CRM_Utilities.login_crm(driver, "helpdesk2@cydeo.com", "UserUser");

        //6. Verify title is as expected:
        // Expected: Portal
        // We are waiting 3 secs for title to be loaded to "(2) Portal"
        BrowserUtils.sleep(3);
        BrowserUtils.verifyTitle(driver, "(2) Portal");
    }
}