package com.epam.wizzair.page.impl;

import com.epam.wizzair.page.IPassenger;
import com.epam.wizzair.page.exception.ElementNotActiveException;
import com.epam.wizzair.page.util.BaggageCabinOptions;
import com.epam.wizzair.page.util.BaggageCheckedOptions;
import com.epam.wizzair.page.util.CheckInMethod;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.naming.OperationNotSupportedException;

/**
 * Created by Dzmitry_Sankouski on 06-Mar-17.
 */
public class Passenger extends AbstractPage implements IPassenger {

    private WebDriverWait wait;


    //locators
    @FindBy(xpath = "//*[@id=\"passenger-baggages-outbound-0\"]")
    WebElement depContainer;

    @FindBy(xpath = "//*[@id=\"passenger-baggages-return-0\"]")
    WebElement retContainer;

    @FindBy(xpath = "//*[@id=\"booking-flow-step-passengers\"]/div[1]/form")
    WebElement passengerForm;


    //--------------------sport equipment buttons
    By SportEquipment = By.xpath("//div[3]/div[1]/div[1]/div/div/div[2]/label");

    //---------------------seat selection button
    By seatSelection = By.xpath("//div[3]/div[2]/div/div/div/div/div/button");

//-----------------------checkin baggage radio buttons
    By baggageNoneRB = By.xpath("//*[@id=\"passenger-0-outbound-checked-in-baggage-switch-option0\"]");
    By baggageLightRB = By.xpath("//*[@id=\"passenger-0-outbound-checked-in-baggage-switch-option1\"]");
    By baggageHeavyRB = By.xpath("//*[@id=\"passenger-0-outbound-checked-in-baggage-switch-option2\"]");

    Actions actions = new Actions(driver);

    public Passenger(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
        JavascriptExecutor jsx = (JavascriptExecutor)driver;
        jsx.executeScript("window.scrollBy(0,450)", "");
        wait = new WebDriverWait(this.driver, 5, 1000);
    }

    public Passenger setCheckedInBaggage(BaggageCheckedOptions depOption) {
        WebElement input;

        switch (depOption){
            case NONE:
                input = depContainer.findElement(baggageNoneRB);
                actions.moveToElement(input).click();
                break;
            case LIGHT:
                input = depContainer.findElement(baggageLightRB);
                actions.moveToElement(input).click();
                break;
            case HEAVY:
                input = depContainer.findElement(baggageHeavyRB);
                actions.moveToElement(input).click();
                break;
        }


        return this;
    }

    public Passenger setCheckedInBaggage(BaggageCheckedOptions depOption, BaggageCheckedOptions retOption) {
        WebElement input;
        setCheckedInBaggage(depOption); // setting departure options

        switch (depOption){
            case NONE:
                input = retContainer.findElement(baggageNoneRB);
                actions.moveToElement(input).click();
                break;
            case LIGHT:
                input = retContainer.findElement(baggageLightRB);
                actions.moveToElement(input).click();
                break;
            case HEAVY:
                input = retContainer.findElement(baggageHeavyRB);
                actions.moveToElement(input).click();
                break;
        }
        return this;
    }

    //-----------------------cabin baggage radio buttons
    By baggageSmallRB = By.xpath("//*[@id=\"passenger-0-outbound-cabin-baggage-switch-option0\"]");
    By baggageLargeRB = By.xpath("//*[@id=\"passenger-0-outbound-cabin-baggage-switch-option1\"]");

    public Passenger setCabinBaggage(BaggageCabinOptions depOption) {

        switch (depOption){
            case SMALL:
                depContainer.findElement(baggageSmallRB).click();
                break;
            case LARGE:
                depContainer.findElement(baggageLargeRB).click();
                break;
        }

        return this;
    }

    public Passenger setCabinBaggage(BaggageCabinOptions depOption, BaggageCabinOptions retOption) {
        setCabinBaggage(depOption);// setting departure options

        switch (depOption){
            case SMALL:
                retContainer.findElement(baggageSmallRB).click();
                break;
            case LARGE:
                retContainer.findElement(baggageLargeRB).click();
                break;
        }

        return this;
    }

    //Sport Equipment locators
    By sportEquipmentBtn = By.xpath("//div[@class=\"booking-flow__passengers__sports-equipment-switch__button\"]");//todo refactor locator
    WebElement sportEquipmentDepBtn;
    WebElement sportEquipmentRetBtn;

    //this locators home is sportEquipmentBtn
    By input = By.xpath("//input[1]");
    By labelEn = By.xpath("//label[1]/span[@class=\"button button--medium button--filled\"]");
    By labelDis = By.xpath("//label[1]/class=\"button button--medium button--outlined button--breakable\"");
    //-----------------------------------


    public boolean isDepSportEquipmentEn() {
        sportEquipmentDepBtn = depContainer.findElement(sportEquipmentBtn);
        boolean result;
        result = sportEquipmentDepBtn.findElement(labelEn).getAttribute("style").isEmpty();
        return result;
    }

    public boolean isRetSportEquipmentEn() {
        sportEquipmentRetBtn = retContainer.findElement(sportEquipmentBtn);
        boolean result;
        result = sportEquipmentRetBtn.findElement(labelEn).getAttribute("style").isEmpty();
        return result;
    }

    public Passenger setSportEquipment(boolean isDepEnabled) {
        setSportEquipment(isDepEnabled, false);
        return this;
    }

    public Passenger setSportEquipment(boolean isDepEnabled, boolean isRetEnabled) {

        boolean actualDepState = isDepSportEquipmentEn();

        if (isDepEnabled^actualDepState){ // if actual XOR expected = true then click
            sportEquipmentDepBtn.click();
        }

        boolean actualRetState = isRetSportEquipmentEn();
        if (isRetSportEquipmentEn()^actualRetState){ // if actual XOR expected = true then click
            sportEquipmentRetBtn.click();
        }
        return this;
    }



    By online = By.xpath(".//div[3]/div[1]/div[2]/div/div/div/label[1]");
    By airport = By.xpath(".//div[3]/div[1]/div[2]/div/div/div/label[2]");
    public Passenger setCheckInMethod(CheckInMethod depMethod, CheckInMethod retMethod) {

        switch (retMethod){
            case ONLINE:
                retContainer.findElement(online).click();
                break;
            case AIRPORT:
                retContainer.findElement(airport).click();
                break;
        }

        return this;
    }

    public Passenger setCheckInMethod(CheckInMethod depMethod) {

        switch (depMethod){
            case ONLINE:
                depContainer.findElement(online).click();
                break;
            case AIRPORT:
                depContainer.findElement(airport).click();
                break;
        }

        return this;
    }

    public void gotoDepSeatSelection() {
        depContainer.findElement(seatSelection).click();
    }

    public void gotoRetSeatSelection() {
        retContainer.findElement(seatSelection).click();
    }

    // confirm container locator is relative to passengers form
    By confirmContainerLocator = By.xpath(".//*[@class=\"booking-flow__cta-container\"]");
    By confirmBtnLocator = By.xpath(".//*[@id=\"passengers-continue-btn\"]");
    By confirmLabelLocator = By.xpath(".//div[2]");

    public void submit() throws ElementNotActiveException{
        WebElement confirmContainer = passengerForm.findElement(confirmContainerLocator);
        WebElement confirmBtn = confirmContainer.findElement(confirmBtnLocator);

        if (!confirmBtn.isEnabled()){
            WebElement confirmLabel = confirmContainer.findElement(confirmLabelLocator);
            throw new ElementNotActiveException(confirmLabel.getText());
        }
        //todo return next page
        confirmBtn.click();

    }

    @Override
    public void openPage(){

    }
}
