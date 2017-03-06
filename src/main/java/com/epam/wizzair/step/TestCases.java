package com.epam.wizzair.step;

import com.epam.wizzair.driver.TestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import junit.framework.Assert;


public class TestCases extends TestBase {

    private Steps steps;

    @BeforeMethod(description = "Init browser")
    public void setUp() {
        steps = new Steps();
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
