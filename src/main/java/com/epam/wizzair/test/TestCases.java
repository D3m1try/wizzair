package com.epam.wizzair.test;
import com.epam.wizzair.driver.DriverSingleton;
import com.epam.wizzair.page.IPassenger;
import com.epam.wizzair.page.impl.Passenger;
import com.epam.wizzair.page.impl.SearchResult;
import com.epam.wizzair.page.util.BaggageCabinOptions;
import com.epam.wizzair.page.util.BaggageCheckedOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.epam.wizzair.step.impl.MainPageSteps;


import junit.framework.Assert;


public class TestCases {

    private MainPageSteps steps;

    private String origin = "Vilus";
    private String destination = "Tel-Aviv";
    private int departureDay = 22;
    private int returnDay = 28;

    @BeforeMethod(description = "Init browser")
    public void setUp() {
        steps = new MainPageSteps();
        steps.initBrowser();
    }

    @Test
    public void flitsSum() throws InterruptedException {
        steps.findFlight(origin, destination, departureDay, returnDay);
        IPassenger passengerPO = new Passenger(DriverSingleton.getDriver());
        Thread.sleep(5000);
        SearchResult searchResult = new SearchResult(DriverSingleton.getDriver());
        searchResult.chooseFirstFlight();
        searchResult.chooseSecondFlight();

//        passengerPO.setSportEquipment(true,false);
//        Thread.sleep(5000);
//        passengerPO.setCheckedInBaggage(BaggageCheckedOptions.LIGHT);
//        Thread.sleep(25000);
//        passengerPO.setCabinBaggage(BaggageCabinOptions.LARGE);

        Assert.assertEquals(steps.getTwoFlightPrices(), steps.getFlightSumFromLeftWindow());
    }

    @AfterMethod
    public void close() {
        steps.closeBrowser();
    }
}
