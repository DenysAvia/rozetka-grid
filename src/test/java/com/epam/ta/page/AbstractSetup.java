package com.epam.ta.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractSetup {
    protected WebDriver driver;
    protected static final String HOMEPAGE_URL = "https://rozetka.com.ua/ua/";


    protected AbstractSetup(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);


    }
}
