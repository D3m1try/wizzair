package com.epam.wizzair.page.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.epam.wizzair.page.impl.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends AbstractPage {

    private final String BASE_URL = "https://wizzair.com/";
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//ul[@class='navigation__container']/li[3]")
    private WebElement signInButton;

    @FindBy(xpath = "//form[@name='login-form']//input[@type='email']")
    private WebElement emailField;


    @FindBy(xpath = "//form[@name='login-form']//input[@type='password']")
    private WebElement passwordField;


    @FindBy(xpath = "//form[@name='login-form']//button[@type='submit']")
    private WebElement submitSingInButton;



    public LoginPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
    }

    public void login(String email, String password){
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        submitSingInButton.click();
        logger.info("Login performed");
    }

    public void openSignInForm(){
        signInButton.click();
    }

}
