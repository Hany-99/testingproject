import com.qacart.todo.testcases.api.RegisterApi;
import com.qacart.todo.testcases.objects.User;
import com.qacart.todo.testcases.utils.ConfigUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.response.Response;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class hTest {
    public static void main(String[] args) throws InterruptedException
    //public static void main(String[] args)
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(ConfigUtils.getInstance().getUrl());

         RegisterApi registerApi=new RegisterApi();
         registerApi.register();
        List<io.restassured.http.Cookie> restAssuerdCookies=registerApi.getRestAssuredCookie();

        for (io.restassured.http.Cookie cookie: restAssuerdCookies)
        {
            Cookie seleniumCookie= new Cookie(cookie.getName(),cookie.getValue());
            driver.manage().addCookie(seleniumCookie);
        }



                 driver.quit();
//        String srl= ConfigUtils.getInstance().getUrl();
//        String drl= ConfigUtils.getInstance().getemail();
//        String erl= ConfigUtils.getInstance().getpassword();
//        System.out.println(srl);
//        System.out.println(drl);
//        System.out.println(erl);
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver= new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get(ConfigUtils.getInstance().getUrl());

     //   driver.get("https://qacart-todo.herokuapp.com/login");


     //   driver.quit();
//
//
//        driver.quit();
//       RegisterApi registerApi =  new RegisterApi();
//        registerApi.register();
//        System.out.println(registerApi.getAccessToken());
//        System.out.println(registerApi.getUserID());
//        System.out.println(registerApi.getFirstName());
//        System.out.println(registerApi.getRestAssuredCookie());
//        String responseBody= "{\n" +
//                "\n" +
//                "    \"email\" : \"mosalahhah@yahoo.com\",\n" +
//                "    \"firstName\" :  \"sady\"  ,\n" +
//                "    \"lastName\" :  \"shamy\" ,\n" +
//                "    \"password\" :  \"wallabyTT@3\"\n" +
//                "\n" +
//                "}";
//        User user=new User("mosalahhahaa@yahoo.com","wallabyTT@3",  "sady","shamy");
//
//  Response response =      given()
//                .baseUri("https://qacart-todo.herokuapp.com")
//                .header("Content-Type","application/json")
//                .body(user)
//        .when()
//                .post("/api/v1/users/register")
//        .then()
//                .extract()
//                .response();
    // .log().all();



//        System.out.println(response.body().prettyPrint());
//        String acess=(response.path("access_token"));
//        System.out.println(acess);


}

    //    @Test
//    public void hi(  )
//    {
//
//        System.out.println( "Hello !" );
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.quit();
//
//        System.out.println( "shit !" );
//    }


//    public static void main( String[] args )
//    {
//
//        System.out.println( "Hello !" );
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.quit();
//
//        System.out.println( "shit !" );
//    }
}
