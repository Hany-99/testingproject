package com.qacart.todo.testcases.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DriverFactory {

    private WebDriver driver;
    public WebDriver initializeDriver()
    {
        String browser=System.getProperty("browser","CHROME");

        switch (browser)
        {
            case "CHROME": WebDriverManager.chromedriver().setup();
            driver =new ChromeDriver();
            break;
            case "FIREFOX": WebDriverManager.firefoxdriver().setup();
                driver =new FirefoxDriver();
                break;
            case "SAFARI": WebDriverManager.safaridriver().setup();
                driver =new SafariDriver();
                break;

            default: throw  new RuntimeException("the browser is not supported");
        }

       driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        return driver;

    }
}
