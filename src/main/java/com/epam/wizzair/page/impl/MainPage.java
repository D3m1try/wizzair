package com.epam.wizzair.page.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MainPage extends AbstractPage{

    private final String BASE_URL = "https://wizzair.com/#/";

    private String pathDate = "//div[@class=\"calendar\"]//td[@data-day=\"";

    @FindBy(id= "search-departure-station")
    private WebElement inputOriginName;

    @FindBy(id = "search-arrival-station")
    private WebElement inputDestinationName;

    @FindBy(xpath = "//*[@id=\"search-departure-date\"]")
    private WebElement departureDateName;

    @FindBy(xpath = "//*[@id=\"search-return-date\"]")
    private WebElement returnDateName;

    @FindBy(xpath = "//*[@id=\"flight-search\"]/div/div/div/form/div[2]/button")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"app\"]/header/div/nav/ul/li[3]/button")
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

    public MainPage fillDistination(String destination){

        inputDestinationName.click();
        inputDestinationName.sendKeys(destination);
        return this;
    }

    public MainPage fillDepartureDate(int day) {
        departureDateName.click();
        WebElement calendarDepartureDate = driver.findElement(By.xpath(pathDate + day + "\"]"));
        calendarDepartureDate.click();
        return this;
    }

    public MainPage fillReturnDate(int day) {
        returnDateName.click();
        WebElement calendarReturnDate = driver.findElement(By.xpath(pathDate + day + "\"]"));
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