package com.qacart.todo.testcases;

import com.qacart.todo.testcases.base.BaseTest;
import com.qacart.todo.testcases.pages.LoginPage;

import com.qacart.todo.testcases.utils.ConfigUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;


@Feature("Auth Feature")

public class LoginTest extends BaseTest {


      @Story("Login with email and password")
      @Description("it will logging")
    @Test(description = "Test the login functionality using email and password")
    public void ShouldBeAbleToLoginWithValidEmailAndPassword(){

        LoginPage loginPage = new LoginPage(getDriver());
      //  loginPage.load("https://qacart-todo.herokuapp.com/login");
      //  TodoPage todoPage= loginPage.login("hanyhazem101@gmail.com","wallabyTT532");
      // boolean iswelcomeDisplayed= todoPage.IsDisplayed();

        boolean iswelcomeDisplayed=  loginPage.load()
                .login(ConfigUtils.getInstance().getemail(), ConfigUtils.getInstance().getpassword())
                .IsMessageDisplayed();

        Assert.assertTrue(iswelcomeDisplayed);

       // TodoPage todoPage= loginPage.login("hanyhazem101@gmail.com","wallabyTT532");


//        driver.findElement(By.id("email")).sendKeys("hanyhazem101@gmail.com");
//        driver.findElement(By.id("password")).sendKeys("wallabyTT532");
//        driver.findElement(By.id("submit")).click();
     //   driver.findElement(By.cssSelector("[data-testid=welcome]"));
    //    TodoPage todoPage=new TodoPage(driver);

      //  boolean iswelcomeDisplayed= driver.findElement(By.cssSelector("[data-testid=welcome]")).isDisplayed();
//        boolean iswelcomeDisplayed= todoPage.IsDisplayed();
//        Assert.assertTrue(iswelcomeDisplayed);

    }


}
