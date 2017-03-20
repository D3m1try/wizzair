package com.epam.wizzair.test;

import com.epam.wizzair.bean.*;
import com.epam.wizzair.driver.DriverSingleton;
import com.epam.wizzair.helper.Creator;
import com.epam.wizzair.step.StepsForMainPage;
import com.epam.wizzair.step.StepsForSearchResult;
import com.epam.wizzair.step.TimeTableSteps;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by Dzmitry_Sankouski on 13-Mar-17.
 */
public class TestSuite {
    StepsForMainPage mainSteps;

    @BeforeMethod
    public void init(){
        mainSteps = new StepsForMainPage();
    }

    @AfterMethod
    public void destroy(){
        mainSteps.destroy();
    }

    //----------TestCase id=1
    @Test
    public void searchViaTimetable(){
        Creator.setPropertyFile("timetable");
        FlightData flightData = Creator.getFlightData();
        TimeTableSteps result;
        result = mainSteps.init().closePopUps()
                .openTimeTable()
                .findFlight(flightData.getOrigin(), flightData.getDestination())
                .findFlightInSearchPage()
        ;
        assertEquals(result.getFirstFlightPrice(), result.getFirstFlightPriceInSearch());
    } //test is ready

//----------TestCase id=2
    @Test
    public void summingTwoFlights(){
        Creator.setPropertyFile("bean");
        FlightData flightData = Creator.getFlightData();

        mainSteps.init().signIn().loginWizzAir(Creator.getLogin());
        StepsForSearchResult result;
        result = mainSteps
                .findFlight(flightData)
                .pickExactFlights();
        assertEquals(result.getTwoFlightPrices(), result.getFlightSumFromLeftWindow());
    } //test is ready

    //----------TestCase id=3 map is not implemented

    //----------TestCase id=4
    @Test
    public void baggageCheck(){
        FlightData flightData = Creator.getFlightData();

        PassengerData expectedPassengerData;
        expectedPassengerData = Creator.getPassengerData();

        PassengerData actualPassengerData;

        mainSteps.init().closePopUps()
                .signIn().loginWizzAir(Creator.getLogin());

        actualPassengerData = mainSteps.findFlight(flightData)
                .pickExactFlights().submit()
                .fillPassenger(expectedPassengerData)
                .getInfoColumnData();

        assertEquals(actualPassengerData, expectedPassengerData);
    }// test is ready

    //----------TestCase id=5
    @Test
    public void bookingWrongCard(){
        FlightData flightData = Creator.getFlightData();
        PassengerData passengerData = Creator.getPassengerData();
        BillingDetailsPersonal billingDetails = Creator.getBillingDetailsPersonal();
        CreditCardData creditCard = Creator.getCreditCardData();

        StepsForSearchResult result;
        mainSteps.init().closePopUps()
                .findFlight(flightData)
                .pickExactFlights().submit()
                .fillPassenger(passengerData)
                .fillBaggage(passengerData.getDepBaggage())
                .gotoDepSeatSelection()
                .selectSeatWizzAir().continueFromSeats()
                .gotoRetSeatSelection()
                .selectSeatWizzAir().continueFromSeats()
                .submit()
                .submit()
                .continueToNextPage()
                .fillBillingDetails(billingDetails)
                .fillCreditCard(creditCard)

        ;
//        Assert.assertEquals(result.getTwoFlightPrices(), result.getFlightSumFromLeftWindow());
    }

    //----------TestCase id=6
    @Test
    public void seatReserving(){
        FlightData flightData = Creator.getFlightData();
        PassengerData passengerData = Creator.getPassengerData();

        mainSteps.init()
                .findFlight(flightData)
                .pickExactFlights().submit()
                .fillPassenger(passengerData)
                .fillBaggage(passengerData.getDepBaggage())
                .gotoDepSeatSelection();

        StepsForMainPage mainPage1 = new StepsForMainPage();
        mainPage1.init().closePopUps()
                .findFlight(flightData)
                .pickExactFlights().submit()
                .fillPassenger(passengerData)
                .fillBaggage(passengerData.getDepBaggage())
                .gotoDepSeatSelection();

        mainPage1.destroy();

    }

    //----------TestCase id=8

    @Test
    public void bookWithInfant() {

        Creator.setPropertyFile("bean2");
        FlightData flightData = Creator.getFlightData();
        String flightWithoutInfant = mainSteps.init().closePopUps()
                .findFlight(flightData).pickExactFlights()
                .getFlightSumFromLeftWindow();



//        DriverSingleton.openNewWindowJS();

        Creator.setPropertyFile("bean");
        FlightData flightData1 = Creator.getFlightData();

        StepsForMainPage mainSteps1 = new StepsForMainPage();
        String flightWithInfant = mainSteps1.init()
                .findFlight(flightData1)
                .pickExactFlights().getFlightSumFromLeftWindow();

        mainSteps1.destroy();

        assertEquals(flightWithoutInfant, flightWithInfant);
    }//test is ready

    //----------TestCase id=10

    @Test
    public void testWithAndWithoutLogin() {

        Creator.setPropertyFile("bean");
        FlightData flightData = Creator.getFlightData();
        Login login = Creator.getLogin();
        String bookWithoutLogin = mainSteps.init().closePopUps()
                .findFlight(flightData).pickExactFlights()
                .getFlightSumFromLeftWindow();


        StepsForMainPage mainSteps1 = new StepsForMainPage();

        String bookWithLogin = mainSteps.init().closePopUps().signIn()
                .loginWizzAir(login).findFlight(flightData)
                .pickExactFlights().getFlightSumFromLeftWindow();

        assertEquals(bookWithoutLogin, bookWithLogin);



    }


    @AfterClass
    public void closeResources(){
        DriverSingleton.quit();
    }

}
