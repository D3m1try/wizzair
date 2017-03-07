package com.epam.wizzair.driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class DriverSingleton {

    private static WebDriver driver;
    private static final String WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";
    private static final String WEBDRIVER_CHROME_DRIVER_EXE_PATH = "chromedriver.exe";
    private static final String WEBDRIVER_FIREFOX_DRIVER_EXE_PATH = "geckodriver.exe";

    private DriverSingleton() {
    }

    public static WebDriver getDriver() {
        if (null == driver) {
            ProfilesIni profile = new ProfilesIni();
            FirefoxProfile myprofile = profile.getProfile("WebDriver");
            System.setProperty("webdriver.firefox.profile", "WebDriver");
//            driver = new FirefoxDriver(new FirefoxProfile(new File("C:\\Users\\Dzmitry_Sankouski\\AppData\\Roaming\\Mozilla\\Firefox\\Profiles\\jhosve22.WebDriver")));
//            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//            driver.manage().window().maximize();

            System.setProperty(WEBDRIVER_CHROME_DRIVER, WEBDRIVER_CHROME_DRIVER_EXE_PATH);
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        return driver;
    } //todo static factory to get driver of  selected type



    public static void closeDriver() {
        driver.quit();
        driver = null;
    }

    
}
