package com.epam.wizzair.test;

import com.epam.wizzair.bean.FlightData;
import com.epam.wizzair.driver.DriverSingleton;
import com.epam.wizzair.helper.Creator;
import com.epam.wizzair.step.impl.StepsForMainPage;
import com.epam.wizzair.step.impl.TimeTableSteps;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

/**
 * Created by Ivan_Surus on 3/15/2017.
 */
public class tstCheckFlightPrice extends TestBase{


    StepsForMainPage mainSteps = new StepsForMainPage();

    @Test(description = "id=1")
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

}
