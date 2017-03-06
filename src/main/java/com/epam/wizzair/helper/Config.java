package com.epam.wizzair.helper;

import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Aliaksandr_Krutsko on 3/6/2017.
 */
public class Config {


    private static Properties config = new Properties();

    private static InputStream is = Config.class.getResourceAsStream("/config.properties");

    static {

        try{
            config.load(is);

        } catch (Exception e){
            System.out.println("Error reading from property file");

        }
    }


    public static String url() {
        return config.getProperty("url");
    }

    public static String browser() {
        return config.getProperty("browser");

    }


    public static String geckodriver() {return config.getProperty("geckodriver");}
    public static String chromedriver() {return config.getProperty("chromedriver");}







}
