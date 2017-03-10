package com.epam.wizzair.page.impl;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.epam.wizzair.page.impl.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class SelectSeatPage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();

    //можно //a[text()='Continue']
    @FindBy(xpath = "//form[@name='seat-selection']//a[text()='Continue']")
    private WebElement continueButton;

    /*//all seats in the plane (180 elements)
    @FindBy(xpath = "//div[@id='booking-flow-step-seat-selection']//input")
    private WebElement[] allSeats;*/

    //all available seats in the plane
    @FindBy(xpath = "div[@id='booking-flow-step-seat-selection']//input[not(@disabled)]")
    private WebElement[] availableSeats;

    /*//all unavailable seats in the plane
    @FindBy(xpath = "//div[@id='booking-flow-step-seat-selection']//input[@disabled]")
    private WebElement[] unavailableSeats;*/

    //selected seat name
    @FindBy(className = "booking-flow__seat-selection-flight__passenger__seat-designator")
    private WebElement selectedSeatName;


    public SelectSeatPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    //может убрать этот метод из AbstractPage???
    @Override
    public void openPage() {

    }


    public void selectRandomAvailableSeat(){
        WebElement seat = getRandomAvailableSeat();
        seat.click();
        getSeatNumber(seat);
        continueButton.click();
        logger.info("Selected seat is: " + getSeatNumber(seat));
    }

    private WebElement getRandomAvailableSeat(){
        return availableSeats[getRandomNumber(getNumberOfAvailableSeats())];
    }

    //число доступных для выбора мест
    private int getNumberOfAvailableSeats(){
        return availableSeats.length;
    }

    //наличие ранее выбранного места в списке доступных
    public boolean isSeatEnable(WebElement seat){
        ArrayList<WebElement> availableSeatsList =
                new ArrayList<WebElement>(Arrays.asList(availableSeats));
        return availableSeatsList.contains(seat);
    }


    //генерация случайного числа из диапазона доступных мест (можно будет перенести в класс утилит)
    private int getRandomNumber(int numberOfSeats) {
        Random rnd = new Random();
        return rnd.nextInt(numberOfSeats) + 1;
    }

    //номер случайного выбранного места
    private String getSeatNumber(WebElement seat){
        return seat.getAttribute("id");
    }

    public String getSelectedSeatName() { return selectedSeatName.getText();}


}
