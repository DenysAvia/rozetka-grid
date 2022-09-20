package com.epam.ta.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RozetkaHomePage extends AbstractSetup {
    @FindBy(name = "search")
    private WebElement searchInput;

    @FindBy(xpath = "//button[@class='button button_color_green button_size_medium search-form__submit ng-star-inserted']")
    private WebElement searchButton;

    public RozetkaHomePage(WebDriver driver) {super(driver);}

    public RozetkaHomePage openPage() {

        driver.get(HOMEPAGE_URL);
        driver.manage().window().maximize();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(searchInput));
        return this;
    }

    public RozetkaHomePageSearchResults searchResultsTerm (String term) {
        searchInput.sendKeys(term);
        searchButton.click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//section[@class='content content_type_catalog']")));

        return new RozetkaHomePageSearchResults(driver,term);
    }

}
