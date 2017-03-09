package com.epam.wizzair.driver;
import com.epam.wizzair.helper.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DriverSingleton {



    private static String driverType = Config.browser();

    private static WebDriver driver = null;

    private DriverSingleton() {

    }

    public static void setDriver(String driverType) {

        DriverSingleton.driverType = driverType;
    }


    public static WebDriver getDriver() {
        if (driver == null) {
            switch (driverType.toUpperCase()) {
                case "FIREFOX":
                    System.setProperty("webdriver.gecko.driver", Config.geckodriver());
                    driver = new FirefoxDriver();
                    break;
                case "CHROME":
                    System.setProperty("webdriver.chrome.driver", Config.chromedriver());
                    driver = new ChromeDriver();
                    break;

                default:
                    driver = new FirefoxDriver();
                    break;

            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        }
        return driver;
    }

    public static void open(String url){
        getDriver().get(url);
    }

    public static void quit(){
        if(driver != null) {
            driver.quit();
            driver = null;
        }
    }

    
}
