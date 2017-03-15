package com.epam.wizzair.test;

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
public class tstCheckBaggage {

    StepsForMainPage mainSteps = new StepsForMainPage();

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

    @AfterClass
    public void closeResources(){
        DriverSingleton.quit();
    }
}
