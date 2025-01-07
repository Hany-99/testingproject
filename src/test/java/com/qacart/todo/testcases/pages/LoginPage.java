package com.qacart.todo.testcases.pages;

import com.qacart.todo.testcases.base.BasePage;
import com.qacart.todo.testcases.utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

//   @FindBy(css = "[data-testid=\"welcome\"]")
//    WebElement emailInput;
public LoginPage(WebDriver driver) {
    super(driver);
}




    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "submit")
    private WebElement submit;

@Step
    public TodoPage login(String email, String passwrod)
    {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(passwrod);
        submit.click();

        return new TodoPage(driver);
    }

    @Step("load the login page")
    public LoginPage load( )
    {
        driver.get(ConfigUtils.getInstance().getUrl());
      //  driver.get("url");
        return this;
    }

}
