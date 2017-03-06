package com.epam.wizzair.test;

import com.epam.wizzair.bean.FlightData;
import com.epam.wizzair.step.WizzairSteps;
import com.epam.wizzair.step.impl.Steps;
import org.testng.annotations.Test;

import java.util.Date;

/**
 * Created by Dzmitry_Sankouski on 03-Mar-17.
 */
public class Tests {

    @Test
    public void doubleTicketDoublePrice(){
        String name = "";
        String pass = "";
        FlightData expected;
        FlightData actual;


        WizzairSteps steps = new Steps();
        steps.login(name, pass);
        steps.pickRoute("Vilnus","Budapesht");
        steps.pickDesiredDepartureDate(new Date(3894753));
        steps.pickDesiredReturnDate(new Date(34534535));
        steps.pickPassengers(1,0,0);
        steps.searchFlights();
        steps.pickExactFlight();
        steps.pickPrice();
        actual = steps.readFlightData();

    }

}
