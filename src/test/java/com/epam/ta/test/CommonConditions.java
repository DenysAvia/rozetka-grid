package com.epam.ta.test;


import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

public class CommonConditions {
    public WebDriver driver;
    public DesiredCapabilities cap = new DesiredCapabilities();
    protected static final String EXPECTED_RESULTS_TITLE = "Інтернет-магазин ROZETKA™: офіційний сайт найпопулярнішого онлайн-гіпермаркету в Україні";


    @BeforeTest
    @Parameters("browser")
    public void browserSetup(String browser) throws MalformedURLException {
        if (browser.equalsIgnoreCase("chrome")) {
            cap.setPlatform(Platform.ANY);
            cap.setBrowserName("chrome");

            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.merge(cap);
            driver = new RemoteWebDriver(new URL("http://localhost:4444"), cap);

            } else {
                if (browser.equalsIgnoreCase("firefox")) {
                    cap.setPlatform(Platform.ANY);
                    cap.setBrowserName("firefox");

                   FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.merge(cap);
                    driver = new RemoteWebDriver(new URL("http://localhost:4444"), cap);
                } else {
                    if (browser.equalsIgnoreCase("MicrosoftEdge")) {
                        cap.setBrowserName("MicrosoftEdge");

                        EdgeOptions edgeOptions = new EdgeOptions();
                        edgeOptions.merge(cap);
                        driver = new RemoteWebDriver(new URL("http://localhost:4444"), cap);
                }
            }

        } }




    @AfterTest
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}






