package com.qacart.todo.testcases.api;

import com.qacart.todo.testcases.config.EndPoint;
import com.qacart.todo.testcases.objects.Task;
import com.qacart.todo.testcases.utils.ConfigUtils;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class TaskApi {

    Task task = new Task(false, "learnSelenium");


    public void addNewTask(String token)
    {
        Response response=
               given()
                       .baseUri(ConfigUtils.getInstance().getUrl())
                       .header("Content-Type", "application/json")
                       .body(task)
                       .auth().oauth2(token)
               .when()
                       .post(EndPoint.TASK_API_END_POINT)
               .then()
                       .log().all().extract().response();

        if(response.statusCode()!=201) throw new RuntimeException("something went wrong in adding the todo task");

    }


}
