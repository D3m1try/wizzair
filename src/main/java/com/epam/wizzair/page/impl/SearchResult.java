package com.epam.wizzair.page.impl;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SearchResult {

    @FindBy(xpath = "//*[@id=\"fare-selector-outbound\"]/div/table/tbody[5]/tr/td[2]/label/div/div/span")
    private WebElement firstFlight;
    
    @FindBy(xpath = "//*[@id=\"fare-selector-return\"]/div/table/tbody[5]/tr/td[3]/label/div/div")
    private WebElement secondFlight;
    
    @FindBy(xpath = "//*[@id=\"booking-flow\"]/aside/div[2]/div[5]/div/div[2]/span")
    private WebElement sum;

    


    public String chooseFlights() {
    	
    	String firstPrice = firstFlight.getText();
    	firstFlight.click();    	
    	return firstPrice;
    }
    
    public String getSum() {
    	return sum.getText();
    }


	
	
    
}
