package com.qacart.todo.testcases;

import com.qacart.todo.testcases.api.RegisterApi;
import com.qacart.todo.testcases.api.TaskApi;
import com.qacart.todo.testcases.base.BaseTest;
import com.qacart.todo.testcases.pages.LoginPage;

import com.qacart.todo.testcases.pages.NewTodoPage;
import com.qacart.todo.testcases.pages.TodoPage;
import com.qacart.todo.testcases.utils.ConfigUtils;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;


//@Feature("Todo Feature")

public class TodoTest extends BaseTest {

    // @Story("Add todo")

    @Test(description = "Should be able to add todo correctly")
  //  @Test(description = "Should be able to add todo correctly",enabled = false)
    public void ShouldBeAbleToAddNewTodo()  {
//        LoginPage loginPage = new LoginPage(driver);
//        String actualResult = loginPage.load()
//                .login(ConfigUtils.getInstance().getemail(),ConfigUtils.getInstance().getpassword())
//                .AddTask()
//                .AddNewTask("learn selenium")
//                .GetTodoText();

//        RegisterApi registerApi = new RegisterApi();
//        registerApi.register();
//
//
//        TodoPage todoPage= new TodoPage(driver);
//            todoPage.load();
//        injectCookiesToBrowser(registerApi.getRestAssuredCookie());
//        String actualResult = todoPage.load()
//                                             .AddTask()
//                                              .AddNewTask("learn selenium")
//                                               .GetTodoText();
//
//        Assert.assertEquals(actualResult,"learn selenium" );


        RegisterApi registerApi = new RegisterApi();
        registerApi.register();


        NewTodoPage newTodoPage= new NewTodoPage(getDriver());
        newTodoPage.load();
        injectCookiesToBrowser(registerApi.getRestAssuredCookie());

        String actualResult = newTodoPage
                .load()
                .AddNewTask("learn selenium")
                .GetTodoText();
        Assert.assertEquals(actualResult,"learn selenium" );


       // driver.findElement(By.cssSelector("[data-testid=add]")).click();
      //  (not correct IDK why) driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/div/button/span[1]/svg")).click();
       // (correct) driver.findElement(By.cssSelector("[data-testid=new-todo]")).sendKeys("hihany");

      //  driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/div/input")).sendKeys("learn selenium");
      //  driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/button")).click();
        //(correct)      driver.findElement(By.cssSelector("[data-testid=submit-newTask]")).click();
 //(not correct IDK why) driver.findElement(By.xpath("[@data-testid= submit-newTask]")).click();
    }

    // @Test(enabled = false)


    // @Story("Delete todo")

    @Test(description = "Sholud be able to delete todo correctly")
    public void ShouldBeAbleToDeleteTodoItem()
    {

//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.load();
//        boolean exisit =loginPage.login(ConfigUtils.getInstance().getemail(),"wallabyTT532")
//                .AddTask()
//                .AddNewTask("learn")
//                .ClickOnDeleteButton().ISnoTodoMessageDisplayed();
//
//        Assert.assertTrue(exisit);


        RegisterApi registerApi = new RegisterApi();
        registerApi.register();
        TaskApi taskApi = new TaskApi();
        taskApi.addNewTask(registerApi.getAccessToken());

        TodoPage todoPage = new TodoPage(getDriver());
        todoPage.load();
        injectCookiesToBrowser(registerApi.getRestAssuredCookie());
        boolean exisit = todoPage
                .load()
                .ClickOnDeleteButton()
                .ISnoTodoMessageDisplayed();
        Assert.assertTrue(exisit);



        //TodoPage todoPage=new TodoPage(driver);


        // driver.findElement(By.cssSelector("[data-testid=delete]")).click();
        //  todoPage.ClickOnDeleteButton();
        //  boolean exisit = todoPage.ISnoTodoMessageDisplayed();
        //  boolean exisit =driver.findElement(By.cssSelector("[data-testid=no-todos]")).isDisplayed();


    }



    @Test(enabled = false)
    public void ShouldBeAbleToSelectTodoItem()
    {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.load();
        loginPage.login(ConfigUtils.getInstance().getemail(),ConfigUtils.getInstance().getpassword())
                .MarkSelection();
        //todoPage.MarkSelection();

//        driver.findElement(By.cssSelector("[data-testid=add]")).click();
//
//       driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/div/input")).sendKeys("learn selenium");
//         driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/button")).click();
       // TodoPage todoPage=new TodoPage(driver);

       // NewTodoPage newTodoPage= todoPage.AddTask();


      //  newTodoPage.AddNewTask("learn selenium");



        //driver.findElement(By.cssSelector("[data-testid=complete-task]")).click();

    }

    @Test(enabled = false)
    public void ShouldBeAbleToCheckSelectTodoItem()
    {
        LoginPage loginPage = new LoginPage(getDriver());
        boolean selected=  loginPage.load()
                .login(ConfigUtils.getInstance().getemail(),ConfigUtils.getInstance().getpassword()) .IsMarkSelected();
        Assert.assertTrue(selected);

       // boolean selected= driver.findElement(By.cssSelector("[data-testid=complete-task]")).isSelected();
  //      TodoPage todoPage=new TodoPage(driver);
       // boolean selected= todoPage.IsMarkSelected();
        //System.out.println(selected);


    }



}
