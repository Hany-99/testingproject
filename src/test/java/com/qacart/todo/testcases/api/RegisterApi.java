package com.qacart.todo.testcases.api;
import com.qacart.todo.testcases.config.EndPoint;
import com.qacart.todo.testcases.objects.User;

import com.qacart.todo.testcases.utils.ConfigUtils;
import com.qacart.todo.testcases.utils.UserUtils;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;

public class RegisterApi {


     private static List<Cookie> restAssuredCookie;
    private String accessToken;
    private String userID;
    private String firstName;
    public String getUserID() {
        return this.userID;
    }

    public String getFirstName() {
        return this.firstName;
    }


    public List <Cookie> getRestAssuredCookie() {
        return this.restAssuredCookie;
    }

    public String getAccessToken() {
        return this.accessToken;
    }





    public void register()
    {
        User user= UserUtils.generateUser();

        Response response =
                given()
                       // .baseUri("https://qacart-todo.herokuapp.com")
                        .baseUri(ConfigUtils.getInstance().getUrl())
                        .header("Content-Type", "application/json")
                        .body(user)
                        .log().all()
                .when()
                        .post(EndPoint.REGISTER_API_END_POINT)
                 .then()
                        .log().all()
                        .extract().response();

        if (response.statusCode()!= 201)
        {
             throw new RuntimeException("something went wrong with the request");
        }
             restAssuredCookie = response.detailedCookies().asList();
            accessToken=response.path("access_token");

          userID =response.path("userID");

          firstName=response.path("firstName");


    }

}
