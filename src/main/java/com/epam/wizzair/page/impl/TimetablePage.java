package com.epam.wizzair.page.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static com.epam.wizzair.driver.DriverSingleton.getDriver;

/**
 * Created by Nadzeya_Parkhimovich on 13-Mar-17.
 */
public class TimetablePage extends AbstractPage {

    private WebDriverWait wait = new WebDriverWait(getDriver(), 10, 1000);
    private final String URL = "https://wizzair.com/en-gb/information-and-services/destinations/timetable#/";
    private final String CITY = "//strong[text()='";
    private final String FLIGHT_PATH = "//li[@class='fare-finder__calendar__days__day']";


    @FindBy(id= "search-departure-station")
    private WebElement inputOriginName;

    @FindBy(id = "search-arrival-station")
    private WebElement inputDestinationName;

    @FindBy(xpath = "//div[@class='fare-finder__sidebar__submit']/button[text()='Search']")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@class='fare-finder__calendar box']")
    private List<WebElement> divFlights;

    @FindBy(xpath = "//dd[@class='summary__price t__summary__price']/strong")
    private WebElement summaryPrice;

    @FindBy(xpath = "//div[@class='sidebar fare-finder__sidebar']/div[2]//strong[@class='fare-finder__sidebar__flight-card__content__price__amount']")
    private WebElement firstFlightPrice;

    @FindBy(xpath = "//div[@class='sidebar fare-finder__sidebar']/div[3]//strong[@class='fare-finder__sidebar__flight-card__content__price__amount']")
    private WebElement secondFlightPrice;

    @FindBy(xpath = "//div[@class='sidebar fare-finder__sidebar']/button")
    private WebElement bookingButton;


    public TimetablePage(){

    }

    @Override
    public void openPage() {
        getDriver().navigate().to(URL);
    }

    public TimetablePage fillOrigin(String origin){
        wait.until(ExpectedConditions.elementToBeClickable(inputOriginName));
        inputOriginName.click();
        inputOriginName.sendKeys(origin);
        WebElement originCity = getDriver().findElement(By.xpath(CITY + origin + "']"));
        originCity.click();
        return this;
    }

    public TimetablePage fillDestination(String destination){

        wait.until(ExpectedConditions.elementToBeClickable(inputDestinationName));
        inputDestinationName.click();
        inputDestinationName.sendKeys(destination);
        WebElement destinationCity = getDriver().findElement(By.xpath(CITY + destination + "']"));
        destinationCity.click();
        return this;
    }

    public TimetablePage search() {
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();
        return this;
    }

    public TimetablePage chooseFirstFlight() {
        WebElement flights = divFlights.get(0);
        List<WebElement> firstFlight = flights.findElements(By.xpath(FLIGHT_PATH));
        WebElement el = firstFlight.get(0);
        el.click();
        return this;
    }

    public TimetablePage chooseSecondFlight() {
        ((JavascriptExecutor)getDriver()).executeScript("window.scrollBy(0,7000);");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement flights = divFlights.get(1);
        List<WebElement> secondFlight = flights.findElements(By.xpath(FLIGHT_PATH));
        WebElement el = secondFlight.get(secondFlight.size()-1);
        el.click();
        return this;
    }

    public String getSummaryPrice() {
        return summaryPrice.getText();
    }

    public String getFirstFlightPrice() {
        return firstFlightPrice.getText();
    }

    public String getSecondFlightPrice() {
        return secondFlightPrice.getText();
    }

    public SearchResult startBooking() {
        wait.until(ExpectedConditions.elementToBeClickable(bookingButton));
        bookingButton.click();
        return new SearchResult();
    }
}
