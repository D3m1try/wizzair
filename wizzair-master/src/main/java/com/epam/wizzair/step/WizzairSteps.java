package com.epam.wizzair.step;

import com.epam.wizzair.bean.FlightData;

import java.util.Date;

/**
 * Created by Dzmitry_Sankouski on 03-Mar-17.
 */
public interface WizzairSteps {
    public void login(String userName, String password);

    public void pickRoute(String dep, String ret);

    public void pickDesiredDepartureDate(Date date);

    public void pickDesiredReturnDate(Date date);

    public void pickPassengers(int adults, int childs, int infants);

    public void searchFlights();

    public FlightData readFlightData();

    public void pickExactFlight();

    public void pickPrice();

}
