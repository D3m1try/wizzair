package com.epam.wizzair.step;

import com.epam.wizzair.page.impl.MainPage;
import com.epam.wizzair.page.impl.SearchResult;


public class Steps {

//    private WebDriver driver;
//
//    public void initBrowser() {
//        driver = DriverSingleton.getDriver();
//    }


    public void findFlight() {
        MainPage mainPage = new MainPage();
        mainPage.createNewRoute("Sofia", "Copenhagen");
    }
    
    public String getFirstPrice() {
    	SearchResult searchResult = new SearchResult();
    	return searchResult.chooseFlights();
    }
    
    public String getSum() {
    	SearchResult searchResult = new SearchResult();
    	return searchResult.getSum();
    }
    
    

}
