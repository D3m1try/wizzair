package com.epam.wizzair.test;

import com.epam.wizzair.bean.BillingDetailsPersonal;
import com.epam.wizzair.bean.CreditCardData;
import com.epam.wizzair.bean.FlightData;
import com.epam.wizzair.bean.PassengerData;
import com.epam.wizzair.driver.DriverSingleton;
import com.epam.wizzair.helper.Creator;
import com.epam.wizzair.step.impl.StepsForMainPage;
import com.epam.wizzair.step.impl.StepsForSearchResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

/**
 * Created by Ivan_Surus on 3/15/2017.
 */
public class tstCheckBookingWithWrongCard {

    StepsForMainPage mainSteps = new StepsForMainPage();

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

    @AfterClass
    public void closeResources(){
        DriverSingleton.quit();
    }
}
