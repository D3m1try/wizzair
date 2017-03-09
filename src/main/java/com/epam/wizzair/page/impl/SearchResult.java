package com.epam.wizzair.page.impl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SearchResult extends AbstractPage {

    private WebDriverWait wait = new WebDriverWait(driver, 10, 5000);

    @FindBy(xpath = "//*[@id='fare-selector-outbound']//div[@class = 'fare__price']")
    private WebElement firstFlight;

    @FindBy(xpath = "//*[@id='fare-selector-return']//div[@class = 'fare__price']")
    private WebElement secondFlight;

    @FindBy(xpath = "//div[@class='booking-flow__itinerary__total__price']")
    private WebElement totalPrice;


    public SearchResult(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public String chooseFirstFlight() {

        String firstFlightPrice = firstFlight.getText();
        firstFlight.click();
        return firstFlightPrice;
    }
    public String chooseSecondFlight() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String secondFlightPrice = secondFlight.getText();
        //wait.until(ExpectedConditions.elementToBeClickable(secondFlight));
        secondFlight.click();
        return secondFlightPrice;
    }

    public String getTotalPrice() {
        return totalPrice.getText();
    }

    @Override
    public void openPage() {

    }



}
