/*
package com.epam.wizzair.test;

import com.epam.wizzair.bean.*;
import com.epam.wizzair.driver.DriverSingleton;
import com.epam.wizzair.helper.Creator;
import com.epam.wizzair.step.impl.StepsForMainPage;
import com.epam.wizzair.step.impl.StepsForSearchResult;
import com.epam.wizzair.step.impl.TimeTableSteps;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

*/
/**
 * Created by Dzmitry_Sankouski on 13-Mar-17.
 *//*

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
        Assert.assertEquals(result.getFirstFlightPrice(), result.getFirstFlightPriceInSearch());

    }

//----------TestCase id=2
    @Test
    public void summingTwoFlights(){
        Creator.setPropertyFile("bean");
        FlightData flightData = Creator.getFlightData();

        StepsForSearchResult result;
        result = mainSteps.init()
                .findFlight(flightData)
                .pickExactFlights();
        Assert.assertEquals(result.getTwoFlightPrices(), result.getFlightSumFromLeftWindow());
    }

    //----------TestCase id=3 map is not implemented

    //----------TestCase id=4
    @Test
    public void baggageCheck(){
        FlightData flightData = Creator.getFlightData();

        PassengerData passengerData = new PassengerData();

        passengerData = Creator.getPassengerData();

        StepsForSearchResult result;
        mainSteps.init().closePopUps()
                .findFlight(flightData)
                .pickExactFlights().submit()
                .fillPassenger(passengerData)

        ;
//        Assert.assertEquals(result.getTwoFlightPrices(), result.getFlightSumFromLeftWindow());
    }//todo complete Info column Page, & finish asserts

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

        mainSteps.init().closePopUps()
                .findFlight(flightData)
                .pickExactFlights().submit()
                .fillPassenger(passengerData)
                .fillBaggage(passengerData.getDepBaggage())
                .gotoDepSeatSelection()
                .selectSeatWizzAir().continueFromSeats();
    }

    @AfterClass
    public void closeResources(){
        DriverSingleton.quit();
    }

}
*/
