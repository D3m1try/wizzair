package com.epam.wizzair.test;

import com.epam.wizzair.bean.*;
import com.epam.wizzair.driver.DriverSingleton;
import com.epam.wizzair.helper.Creator;
import com.epam.wizzair.step.impl.StepsForMainPage;
import com.epam.wizzair.step.impl.StepsForSearchResult;
import com.epam.wizzair.step.impl.TimeTableSteps;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by Dzmitry_Sankouski on 13-Mar-17.
 */
public class TestSuite {
    StepsForMainPage mainSteps = new StepsForMainPage();

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

        DriverSingleton.openNewWindow(); //todo smthn with this dirty throw-layer hack

        StepsForMainPage mainPage1 = new StepsForMainPage();
        mainPage1.init().closePopUps()
                .findFlight(flightData)
                .pickExactFlights().submit()
                .fillPassenger(passengerData)
                .fillBaggage(passengerData.getDepBaggage())
                .gotoDepSeatSelection();
        DriverSingleton.closeWindow();

    }

    //----------TestCase id=8

    @Test
    public void bookWithInfant() {

        Creator.setPropertyFile("bean2");
        FlightData flightData = Creator.getFlightData();
        String flightWithoutInfant = mainSteps.init().closePopUps()
                .findFlight(flightData).pickExactFlights()
                .getFlightSumFromLeftWindow();



        DriverSingleton.openNewWindow();

        Creator.setPropertyFile("bean");
        FlightData flightData1 = Creator.getFlightData();

        String flightWithInfant = mainSteps.init()
                .findFlight(flightData1)
                .pickExactFlights().getFlightSumFromLeftWindow();

        assertEquals(flightWithoutInfant, flightWithInfant);


    }

    //----------TestCase id=10

    @Test
    public void testWithAndWithoutLogin() {

        Creator.setPropertyFile("bean");
        FlightData flightData = Creator.getFlightData();
        Login login = Creator.getLogin();
        String bookWithoutLogin = mainSteps.init().closePopUps()
                .findFlight(flightData).pickExactFlights()
                .getFlightSumFromLeftWindow();

        DriverSingleton.openNewWindow();

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
