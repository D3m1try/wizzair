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
        mainPage.fillDestination(destination);
        mainPage.fillDepartureDate(departureDay);
        mainPage.fillReturnDate(returnDay);
        mainPage.search();
    }

    public String getPrice() {
        SearchResult searchResult = new SearchResult(driver);
        String firstFlightPrice = searchResult.chooseFirstFlight().substring(1);
        String secondFlightPrice = searchResult.chooseSecondFlight().substring(1);
        double sum = Double.parseDouble(firstFlightPrice) + Double.parseDouble(secondFlightPrice);
        return sum + "";
    }

    public String getSum() {
        SearchResult searchResult = new SearchResult(driver);
        return searchResult.getSum().substring(1);
    }



}
