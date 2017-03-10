package com.epam.wizzair.step.impl;

import com.epam.wizzair.bean.PassengerData;
import com.epam.wizzair.driver.DriverSingleton;
import com.epam.wizzair.page.impl.ServicesPage;

/**
 * Created by Dzmitry_Sankouski on 10-Mar-17.
 */
public class PassengerSteps {

    public ServicesPage fillPassenger(PassengerData data){

        return  new ServicesPage(DriverSingleton.getDriver());
    }

}
