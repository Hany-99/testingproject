package com.qacart.todo.testcases.utils;

import com.github.javafaker.Faker;
import com.qacart.todo.testcases.objects.User;

public class UserUtils {

    public  static User generateUser()
    {
        String firstName= new Faker().name().firstName();
        String lastName= new Faker().name().lastName();
        String email= new Faker().internet().emailAddress();
        String password= new Faker().internet().password();
        User user = new User(email, password, firstName, lastName);
        return user;
    }

}
