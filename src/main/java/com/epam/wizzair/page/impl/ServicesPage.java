package com.epam.wizzair.page.impl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Aliaksandr_Krutsko on 3/7/2017.
 */
public class ServicesPage extends AbstractPage {

    public ServicesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void openPage() {

    }

    @FindBy(id = "services-continue-btn")
    private WebElement nextPage;


    public ServicesPage continueToNextPage() {

        nextPage.click();
        return this;

    }



}
