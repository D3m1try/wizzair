package com.epam.wizzair.step;

import com.epam.wizzair.driver.TestBase;
import junit.framework.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


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
    
/*    @AfterMethod
    public void close() {
    	steps.closeBrowser();
    }*/
}
