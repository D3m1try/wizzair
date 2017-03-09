package com.epam.wizzair.page.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends AbstractPage{

    private WebDriverWait wait = new WebDriverWait(driver, 5, 1000);
    private final String BASE_URL = "https://wizzair.com/en-gb/main-page#/";

    private String pathDate = "//div[@class='calendar']//td[@data-day='";

    @FindBy(id= "search-departure-station")
    private WebElement inputOriginName;

    @FindBy(id = "search-arrival-station")
    private WebElement inputDestinationName;

    @FindBy(xpath = "//*[@id='search-departure-date']")
    private WebElement departureDateName;

    @FindBy(xpath = "//*[@id='search-return-date']")
    private WebElement returnDateName;

    @FindBy(xpath = "//form[@name='flight-search']//button[text()='Search']")
    private WebElement searchButton;

    @FindBy(xpath = "//ul[@class='navigation__container']/li[3]")
    private WebElement loginButton;

    public MainPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage(){
        driver.navigate().to(BASE_URL);
    }


    public MainPage fillOrigin(String origin){

        inputOriginName.click();
        inputOriginName.sendKeys(origin);
        return this;
    }

    public MainPage fillDestination(String destination){

        wait.until(ExpectedConditions.elementToBeClickable(inputDestinationName));
        inputDestinationName.click();
        inputDestinationName.sendKeys(destination);
        return this;
    }

    public MainPage fillDepartureDate(int day) {
        departureDateName.click();
        WebElement calendarDepartureDate = driver.findElement(By.xpath(pathDate + day + "']"));
        calendarDepartureDate.click();
        return this;
    }

    public MainPage fillReturnDate(int day) {
        returnDateName.click();
        WebElement calendarReturnDate = driver.findElement(By.xpath(pathDate + day + "']"));
        calendarReturnDate.click();
        return this;
    }

    public SearchResult search() {
        searchButton.click();
        return new SearchResult(driver);
    }

    public void signIn(){
        loginButton.click();
    }




}