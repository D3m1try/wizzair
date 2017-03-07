package com.epam.wizzair.step.impl;
import org.openqa.selenium.WebDriver;

import com.epam.wizzair.driver.DriverSingleton;
import com.epam.wizzair.page.impl.MainPage;
import com.epam.wizzair.page.impl.SearchResult;



public class MainPageSteps {

    private WebDriver driver;
    private String destination = "Tel-Aviv";
    private int departureDay = 22;
    private int returnDay = 28;

    public void initBrowser() {
        driver = DriverSingleton.getDriver();
    }

    public void closeBrowser() {
        driver.quit();
    }

    public void findFlight() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
        mainPage.fillDistination(destination);
        mainPage.fillDepartureDate(departureDay);
        mainPage.fillReturnDate(returnDay);
        mainPage.search();
    }

    public String getFirstPrice() {
        SearchResult searchResult = new SearchResult(driver);
        return searchResult.chooseFlights();
    }

    public String getSum() {
        SearchResult searchResult = new SearchResult(driver);
        return searchResult.getSum();
    }



}
