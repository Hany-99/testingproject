package com.qacart.todo.testcases.pages;

import com.qacart.todo.testcases.base.BasePage;
import com.qacart.todo.testcases.config.EndPoint;
import com.qacart.todo.testcases.utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TodoPage extends BasePage {

    public TodoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[data-testid=welcome]")
    private WebElement welcomeMessage;

    @FindBy(css = "[data-testid=add]")
    private WebElement addButtom;



    @FindBy(css = "[data-testid=todo-item]")
    private WebElement todoItem;

    @FindBy(css = "[data-testid=complete-task]")
    private WebElement selcet;

    @FindBy(css = "[data-testid=delete]")
    private WebElement deleteButtom;

    @FindBy(css = "[data-testid=no-todos]")
    private WebElement noTodoMessage;

    @Step
    public boolean IsMessageDisplayed()
    {

        return welcomeMessage.isDisplayed();
    }

    @Step
    public NewTodoPage AddTask()
    {
        addButtom.click();
        return new NewTodoPage(driver);
    }

    @Step("todo Page load")
    public TodoPage load ()
    {
        driver.get(ConfigUtils.getInstance().getUrl()+ EndPoint.TO_DO_PAGE_END_POINT);
       return this;
    }

    @Step
    public String GetTodoText( )
    {

        return todoItem.getText() ;
    }

    @Step
    public void MarkSelection( )
    {

        selcet.click();
    }

    @Step
    public boolean IsMarkSelected( )
    {

        return selcet.isSelected();
    }

    @Step
    public TodoPage ClickOnDeleteButton( )
    {
         deleteButtom.click();
         return this;
    }

    @Step
    public boolean ISnoTodoMessageDisplayed( )
    {

        return noTodoMessage.isDisplayed();
    }

}
