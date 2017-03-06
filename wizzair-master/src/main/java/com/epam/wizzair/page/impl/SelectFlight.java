package com.epam.wizzair.page.impl;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Dzmitry_Sankouski on 04-Mar-17.
 */
public class SelectFlight {

    @FindBy(xpath = "//*[@id=\"chart-2017-03\"]/ul/li[4]/label/div")
    private WebElement firstFlight;


}
