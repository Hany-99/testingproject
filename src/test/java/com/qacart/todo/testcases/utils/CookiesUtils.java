package com.qacart.todo.testcases.utils;

import io.restassured.http.Cookie;
import io.restassured.http.Cookies;

import java.util.ArrayList;
import java.util.List;

public class CookiesUtils {

    public static List<org.openqa.selenium.Cookie> convertRestAssueredCookiesToSeleniumCookies(List<Cookie> restAssueredCookies)
    {
        List<org.openqa.selenium.Cookie> seleniumCookies = new ArrayList<>();
        for (Cookie cookie : restAssueredCookies)
        {
            org.openqa.selenium.Cookie seleniumCookie= new org.openqa.selenium.Cookie(cookie.getName(), cookie.getValue());

            seleniumCookies.add(seleniumCookie);
        }
        return seleniumCookies;

    }

}
