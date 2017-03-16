package com.epam.wizzair.test;

import com.epam.wizzair.bean.FlightData;
import com.epam.wizzair.driver.DriverSingleton;
import com.epam.wizzair.helper.Creator;
import com.epam.wizzair.step.impl.StepsForMainPage;
import com.epam.wizzair.step.impl.StepsForSearchResult;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

/**
 * Created by Ivan_Surus on 3/15/2017.
 */
public class tstCheckSumDirectAndReturnFlightPrices extends TestBase{

    StepsForMainPage mainSteps = new StepsForMainPage();

    @Test(description = "id=2")
    public void summingTwoFlights(){
        Creator.setPropertyFile("bean");
        FlightData flightData = Creator.getFlightData();

        StepsForSearchResult result;
        result = mainSteps.init()
                .findFlight(flightData)
                .pickExactFlights();
        Assert.assertEquals(result.getTwoFlightPrices(), result.getFlightSumFromLeftWindow());
    }

}
