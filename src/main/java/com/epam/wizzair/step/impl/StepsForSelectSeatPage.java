package com.epam.wizzair.step.impl;

import com.epam.wizzair.driver.DriverSingleton;
import com.epam.wizzair.page.impl.SelectSeatPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class StepsForSelectSeatPage {

    private WebDriver driver;

    private final Logger logger = LogManager.getRootLogger();


    public void initBrowser()
    {
        driver = DriverSingleton.getDriver();
    }

    public void closeDriver()
    { driver.quit();
    }

    public void selectSeatWizzAir()
    {
        SelectSeatPage selectSeatPage = new SelectSeatPage(driver);
        selectSeatPage.selectRandomAvailableSeat();
    }

    /*public boolean isSelectedSeatEnable()
    {
        SelectSeatPage selectSeatPage = new SelectSeatPage(driver);
        return selectSeatPage.isSeatEnable()
    }*/

}
