package com.epam.wizzair.test;

import com.epam.wizzair.bean.FlightData;
import com.epam.wizzair.bean.PassengerData;
import com.epam.wizzair.driver.DriverSingleton;
import com.epam.wizzair.helper.Creator;
import com.epam.wizzair.step.impl.StepsForMainPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

/**
 * Created by Ivan_Surus on 3/15/2017.
 */
public class tstSelectedSeatIsNoMoreAvailable {

    StepsForMainPage mainSteps = new StepsForMainPage();

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
