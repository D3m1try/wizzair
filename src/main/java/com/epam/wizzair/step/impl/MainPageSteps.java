package com.epam.wizzair.step.impl;
import org.openqa.selenium.WebDriver;
import com.epam.wizzair.driver.DriverSingleton;
import com.epam.wizzair.page.impl.MainPage;
import com.epam.wizzair.page.impl.SearchResult;



public class MainPageSteps {

    private WebDriver driver;

    public void initBrowser() {
        driver = DriverSingleton.getDriver();
    }

    public void closeBrowser() {
        driver.quit();
    }

    public void findFlight(String origin, String destination, int departureDay, int returnDay) {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
        mainPage.fillOrigin(origin);
        mainPage.fillDestination(destination);
        mainPage.fillDepartureDate(departureDay);
        mainPage.fillReturnDate(returnDay);
        mainPage.search();
    }

    public String getTwoFlightPrices() {
        SearchResult searchResult = new SearchResult(driver);
        String firstFlightPrice = searchResult.chooseFirstFlight().substring(1);
        String secondFlightPrice = searchResult.chooseSecondFlight().substring(1);
        double sum = Double.parseDouble(firstFlightPrice) + Double.parseDouble(secondFlightPrice);
        return (sum + "").substring(0,6);
    }

    public String getFlightSumFromLeftWindow() {
        SearchResult searchResult = new SearchResult(driver);
        String s = searchResult.getTotalPrice().substring(1);
        return s;
    }



}
