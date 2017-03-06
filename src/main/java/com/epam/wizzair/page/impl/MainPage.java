package com.epam.wizzair.page.impl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MainPage extends AbstractPage{

    private final String BASE_URL = "https://wizzair.com/en-gb/main-page#/";

    @FindBy(id= "search-departure-station")
    private WebElement inputOriginName;

    @FindBy(id = "search-arrival-station")
    private WebElement inputDestinationName;

    @FindBy(xpath = "//*[@id=\"search-departure-date\"]")
    private WebElement departureDateName;

    @FindBy(xpath = "//*[@id=\"search-return-date\"]")
    private WebElement returnDateName;
    
    @FindBy(xpath = "//div[@class=\"calendar\"]/div/div/table/tbody/tr[2]/td[3]")
    private WebElement calendarDepartureDate;
    
    @FindBy(xpath = "//div[@class=\"calendar\"]/div/div/table/tbody/tr[3]/td[3]")
    private WebElement calendarReturnDate;

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

    public void createNewRoute(String origin, String destination, String departureDate, String returnDate){
 
    	    	
        inputDestinationName.click();
        inputDestinationName.sendKeys(destination);
        departureDateName.click();
        calendarDepartureDate.click();
        returnDateName.click();
        calendarReturnDate.click();
        searchButton.click();

    }



    public void signIn(){
        loginButton.click();
    }
  
    


}