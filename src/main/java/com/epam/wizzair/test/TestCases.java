package com.epam.wizzair.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.epam.wizzair.step.impl.MainPageSteps;


import junit.framework.Assert;


public class TestCases {

    private MainPageSteps steps;

    @BeforeMethod(description = "Init browser")
    public void setUp() {
        steps = new MainPageSteps();
        steps.initBrowser();
    }

    @Test
    public void flitsSum() {
        steps.findFlight();
        Assert.assertEquals(steps.getFirstPrice(), steps.getSum());
    }

    @AfterMethod
    public void close() {
        steps.closeBrowser();
    }
}
