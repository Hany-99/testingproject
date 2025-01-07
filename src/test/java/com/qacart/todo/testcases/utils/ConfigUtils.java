package com.qacart.todo.testcases.utils;

import java.security.PublicKey;
import java.util.Properties;

public  class ConfigUtils {
    private  Properties properties;
    private static ConfigUtils configUtils;
  private  ConfigUtils () {

      String env=System.getProperty("env","local");

      switch (env){
          case "local":
              properties =new PropertiesUtils().loadProperties("src/test/java/com/qacart/todo/testcases/config/local.properties");
              break;
          case "production":
              properties =new PropertiesUtils().loadProperties("src/test/java/com/qacart/todo/testcases/config/production.properties");
              break;


          default: throw new RuntimeException("Environment is not supported");
  }
     // properties=new PropertiesUtils().loadProperties("src/test/java/com/qacart/todo/testcases/config/local.properties");





  }

    public static ConfigUtils  getInstance()
    {
    if (configUtils==null)
    {
        configUtils= new ConfigUtils();
    }

    return configUtils;
    }

    public  String getUrl()
    {
        String url = properties.getProperty("url");
        if (url!=null)
        {
            return url;
        }
        throw new RuntimeException("could not find url in property file");

    }

    public  String getemail()
    {
        String email = properties.getProperty("email");
        if (email!=null)
        {
            return email;
        }
        throw new RuntimeException("could not find email in property file");

    }

    public  String getpassword()
    {
        String password = properties.getProperty("password");
        if (password!=null)
        {
            return password;
        }

        throw new RuntimeException("could not find password in property file");
    }


}
