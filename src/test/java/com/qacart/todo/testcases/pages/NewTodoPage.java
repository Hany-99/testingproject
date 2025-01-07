package com.qacart.todo.testcases.pages;

import com.qacart.todo.testcases.base.BasePage;
import com.qacart.todo.testcases.config.EndPoint;
import com.qacart.todo.testcases.utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewTodoPage extends BasePage {

    public NewTodoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[data-testid=new-todo]")
    private WebElement newTodoInput;

    @FindBy(css = "[data-testid=submit-newTask]")
    private WebElement newTodoSubmit;

    @Step
    public TodoPage AddNewTask(String item)
    {
        newTodoInput.sendKeys(item);
        newTodoSubmit.click();

        return new TodoPage(driver);
    }

//    public NewTodoPage load()
//    {
//        driver.get(ConfigUtils.getInstance().getUrl() + "/todo/new");
//        return new NewTodoPage(driver);
//       // return this;
//    }

    @Step("newTodo page load")
    public NewTodoPage load ()
    {
        driver.get(ConfigUtils.getInstance().getUrl() + EndPoint.NEW_TO_DO_PAGE_END_POINT);
       // driver.get("https://qacart-todo.herokuapp.com/todo/new") ;
        return this;
        //        return new NewTodoPage(driver);
    }

}
