package com.epam.wizzair.test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.epam.wizzair.step.impl.MainPageSteps;


import junit.framework.Assert;


public class TestCases {

    private MainPageSteps steps;

    private String destination = "Tel-Aviv";
    private int departureDay = 22;
    private int returnDay = 28;

    @BeforeMethod(description = "Init browser")
    public void setUp() {
        steps = new MainPageSteps();
        steps.initBrowser();
    }

    @Test
    public void flitsSum() {
        steps.findFlight(destination, departureDay, returnDay);
        Assert.assertEquals(steps.getTwoFlightPrices(), steps.getFlightSumFromLeftWindow());
    }

    @AfterMethod
    public void close() {
        steps.closeBrowser();
    }
}
