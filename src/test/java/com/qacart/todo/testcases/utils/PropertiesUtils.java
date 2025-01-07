package com.qacart.todo.testcases.utils;

import java.io.*;
import java.util.Properties;

public class PropertiesUtils {

    public Properties loadProperties(String filepath)
    {
        File file = new File(filepath);
        try {
            InputStream inputStream= new FileInputStream(file) ;
            Properties properties  = new Properties();
            properties.load(inputStream);
            inputStream.close();
            return properties ;
         } catch (FileNotFoundException exception)
        {
        throw new RuntimeException("NO such file");
         }
        catch (IOException exception)
    {
        throw new RuntimeException("error while loading");
    }




    }
}
