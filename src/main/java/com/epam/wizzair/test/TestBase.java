package com.epam.wizzair.test;

import com.epam.wizzair.driver.DriverSingleton;
import com.epam.wizzair.step.impl.StepsForMainPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


/**
 * Created by Ivan_Surus on 3/15/2017.
 */

public class TestBase {

    protected WebDriver driver;
    protected StepsForMainPage mainSteps;

    //в теории здесь нужно создать все степы, передать в них драйвер (нужно изменить конструктор степов)
    //чтобы в тестах ничего не создавать, а только наследоваться от этого класса
    //можно и логгер сделать здесь
    @BeforeMethod
    public void setUp() throws Exception {
        this.driver = DriverSingleton.getDriver();
     //   this.mainSteps = new StepsForMainPage(driver);
    }

    //пока используем только это
    @AfterMethod
    public void closeResources(){
        DriverSingleton.quit();
    }

}