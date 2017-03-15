package com.epam.wizzair.page.impl;

import com.epam.wizzair.bean.PassengerData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dzmitry_Sankouski on 14-Mar-17.
 */

public class InfoColumnPage {
    private static InfoColumnPage instance = new InfoColumnPage();

    private InfoColumnPage() {

    }

    public static InfoColumnPage getInstance() {
        return instance;
    }

    @FindBy(xpath = "//*[@id=\"booking-flow\"]/aside/div[2]")
    private WebElement infoContainer;


    //flight section
    @FindBy(xpath = "//div[contains(@class, 'step--flights')]")
    private WebElement flightsSection;

    @FindBy(xpath = "((//span[@class='flight-info__time'])[1]")
    private WebElement directTicketInfo;

    @FindBy(xpath = "((//span[@class='flight-info__time'])[2]")
    private WebElement returnTicketInfo;

    @FindBy(xpath = "(//span[@class='flight-info__stations'])[1]")
    private WebElement directTicketStations;

    @FindBy(xpath = "(//span[@class='flight-info__stations'])[2]")
    private WebElement returnTicketStations;

    @FindBy(xpath = "((//span[@class='flight-info__day'])[1]")
    private WebElement directTicketDay;

    @FindBy(xpath = "((//span[@class='flight-info__day'])[2]")
    private WebElement returnTicketDay;

    @FindBy(xpath = "(//span[@class='flight-info__month'])[1]")
    private WebElement directTicketMonth;

    @FindBy(xpath = "(//span[@class='flight-info__month'])[2]")
    private WebElement returnTicketMonth;


    public String getTotalPrice(){
        return totalPrice.getText().split("€")[1];
    }

    public String getDirectTicketDay(){
        return directTicketDay.getText();
    }

    public String getDirectTicketMonth(){
        return directTicketMonth.getText();
    }

    public String getReturnTicketDay(){
        return returnTicketDay.getText();
    }

    public String getReturnTicketMonth(){
        return returnTicketMonth.getText();
    }
    //------------end of Flight section
    /*By titleLoc = By.xpath("/div[@class=\"booking-flow__itinerary__step__title\"]");
    By contentLoc = By.xpath("/div[contains(@class, 'booking-flow__itinerary__step__content')]");*/


    //passengers section
    @FindBy(xpath = "//div[contains(@class,'step--passengers')]")
    private WebElement passengersSection;

    @FindBy(xpath = "//div[contains(@class,'passenger-names__content')]")
    private WebElement[] allPassengers;

    @FindBy(xpath = "//*[@id=\"booking-flow\"]/aside/div[2]/div[2]/div[2]/div[1]/div[2]/ul/li")
    private WebElement[] depPassengerRawData;

    public String[][] getDepPassengerRawData(){
        String[][] result = new String[2][depPassengerRawData.length];

        for (int i = 0; i < depPassengerRawData.length; i++) {
            result[0][i] = depPassengerRawData[i].findElement(By.xpath("/span[1]")).getText();
            result[1][i] = depPassengerRawData[i].findElement(By.xpath("/span[2]")).getText();
        }

        return result;
    }

//    public String getcabinBaggage(){
//
//    }
//
//    public String getCheckedBaggage(){
//
//    }


    //services section
    @FindBy(xpath = "//div[contains(@class,'step--services')]")
    private WebElement servicesSection;

    //payment section
    @FindBy(xpath = "//div[contains(@class,'step--payment')]")
    private WebElement paymentSection;


    //total section
    @FindBy(xpath = "//div[contains(@class,'total')]")
    private WebElement totalSection;

    @FindBy(xpath = "//div[contains(@class,'total')]/span")
    private WebElement totalPrice;



   /* public PassengerData getPassengerData(){
        WebElement content;
        List<WebElement> data = new ArrayList<>();
        content = passengersSection.findElement(contentLoc);
        data = content.findElements(By.xpath("/div[1]/div[2]/ul/li"));

        data = content.findElements(By.xpath("/div[1]/div[3]/ul/li"));
/*//*[@id="booking-flow"]/aside/div[2]/div[2]/div[2]/div[1]/div[3]/ul
        return new PassengerData();
    }*/

    public List<String> getPassengersNames(){
        List<String> passengerNames = new ArrayList<>();
        for (WebElement obj: allPassengers){
            passengerNames.add(obj.getText());
        }
        return passengerNames;
    }




}
