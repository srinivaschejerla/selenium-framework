package com.seleniumframework.tests;

import com.seleniumframework.webpages.DeveloperApplyPage;
import com.seleniumframework.webpages.DeveloperPortalPage;
import com.seleniumframework.webpages.HomePage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ApplyAsDeveloperTest {
   WebDriver driver;

   @Before
   public void setup(){
       // use Chrome Driver
       
       // change the chromedriver path as per your local path
       System.setProperty("webdriver.chrome.driver", "C:\\Softs\\chromedriver_win32\\chromedriver.exe");
       
       driver = new ChromeDriver();
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
   }

   @Test
   public void applyAsDeveloper() {
       //Create object of HomePage Class
       HomePage home = new HomePage(driver);
       home.clickOnDeveloperApplyButton();

       //Create object of DeveloperPortalPage
       DeveloperPortalPage devportal= new DeveloperPortalPage(driver);

       //Check if page is opened
       Assert.assertTrue(devportal.isPageOpened());

       //Click on Join Toptal
       devportal.clikOnJoin();

       //Create object of DeveloperApplyPage
       DeveloperApplyPage applyPage =new DeveloperApplyPage(driver);

       //Check if page is opened
       Assert.assertTrue(applyPage.isPageOpened());

       //Fill up data
       applyPage.setDeveloper_email("dejan@toptal.com");
       applyPage.setDeveloper_full_name("Dejan Zivanovic Automated Test");
       applyPage.setDeveloper_password("password123");
       applyPage.setDeveloper_password_confirmation("password123");
       applyPage.setDeveloper_skype("automated_test_skype");

       //Click on join
       //applyPage.clickOnJoin(); 
   }

    @After
    public void close(){
          driver.close();
       }
   }
