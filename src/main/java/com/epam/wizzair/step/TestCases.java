package com.epam.wizzair.step;

import com.epam.wizzair.driver.TestBase;
import junit.framework.Assert;
import org.testng.annotations.Test;


public class TestCases extends TestBase {


    @Test
    public void flitsSum()  {
        Steps steps = new Steps();
        steps.findFlight();
        Assert.assertEquals(steps.getFirstPrice(), steps.getSum());
    }
    

}
