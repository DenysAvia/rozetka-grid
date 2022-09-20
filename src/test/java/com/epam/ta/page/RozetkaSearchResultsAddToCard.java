package com.epam.ta.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class RozetkaSearchResultsAddToCard extends AbstractSetup {
    public RozetkaSearchResultsAddToCard(WebDriver driver) { super(driver);}

    @FindBy(xpath = "//button[@class='header__button ng-star-inserted header__button--active']")
    private WebElement openBasketButton;


    public RozetkaSearchResultsAddToCard basketOpen() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(openBasketButton));
        openBasketButton.click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='cart cart-se ng-star-inserted']")));
        return this;
    }

    public int addToCardResultsSize(){
        List<WebElement> searchResultsCard = driver.findElements(By.xpath("//div[@class='cart cart-se ng-star-inserted']"));

        return searchResultsCard.size();
    }
}
