package com.Bitrix.tests;


import com.Bitrix.utilities.ConfigurationReader;
import com.Bitrix.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {

    protected Actions actions;
    protected WebDriverWait wait;
    protected WebDriver driver;


    @BeforeMethod
    public void setUpMethod(){
        driver = Driver.get();
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        actions = new Actions(driver);
        wait = new WebDriverWait(driver,10);
        driver.get(ConfigurationReader.get("url"));
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(2000);
        Driver.closeDriver();
    }

}
