package com.qacart.todo.testcases.base;

import com.qacart.todo.testcases.factory.DriverFactory;
import com.qacart.todo.testcases.utils.CookiesUtils;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.restassured.http.Cookie;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class BaseTest {
   //protected WebDriver driver;
    protected ThreadLocal<WebDriver>  driver = new ThreadLocal<>();

    public WebDriver getDriver()
    {
        return this.driver.get();
    }

    public void setDriver(WebDriver driver)
    {
        this.driver.set(driver);
    }

  //  public WebDriver driver;
    @BeforeMethod
    public void setup()
    {
       WebDriver driver=new DriverFactory().initializeDriver();
        setDriver(driver);
       // driver=new DriverFactory().initializeDriver();
    }

    @AfterMethod
    public void teardown(ITestResult result)
    {
        String testCaseName=result.getMethod().getMethodName();
        File destfile= new File("target" + File.separator + "screenShoots"+ File.separator + testCaseName + ".png");

       takeScreenshot(destfile);
        getDriver().quit();
      //  driver.quit();
    }


    public void takeScreenshot(File destFile)
    {
        File file = ( (TakesScreenshot) getDriver() ) . getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(file, destFile );
            InputStream is = new FileInputStream(destFile);
            Allure.addAttachment("screenshot",is);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Step
    public void injectCookiesToBrowser(List<Cookie> restAssueredCookies)
    {
        List<org.openqa.selenium.Cookie> seleniumCookies= CookiesUtils.convertRestAssueredCookiesToSeleniumCookies(restAssueredCookies);
        for (org.openqa.selenium.Cookie cookie : seleniumCookies  )
        {
           // driver.manage().addCookie(cookie);
            getDriver().manage().addCookie(cookie);
        }
    }


}
