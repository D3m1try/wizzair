package com.epam.wizzair.driver;

import com.epam.wizzair.helper.Config;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


import static com.epam.wizzair.driver.DriverSingleton.*;

/**
 * Created by Aliaksandr_Krutsko on 3/6/2017.
 */
public class TestBase {

    protected static final  String BASE_URL = Config.url();

    @BeforeTest
    public void setup(){

        setDriver(Driver.Firefox);
        open(BASE_URL);

    }



    @AfterTest
    public void tearDown(){
        quit();
    }



}
