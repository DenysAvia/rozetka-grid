package com.epam.ta.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class RozetkaHomePageSearchResults extends AbstractSetup {
    private String searchTerm;

    public RozetkaHomePageSearchResults(WebDriver driver, String searchTerm){
        super(driver);
        this.searchTerm = searchTerm;

    }
    @FindBy(xpath = "//button[@class='buy-button goods-tile__buy-button ng-star-inserted']")
    private WebElement addToCardButton;

    public int searchResultsSize() {
        List<WebElement> searchResults = driver.findElements(By.xpath("//section[@class='content content_type_catalog']"));

        return searchResults.size();

    }
    public RozetkaSearchResultsAddToCard addToCard() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(addToCardButton));
        addToCardButton.click();

        return new RozetkaSearchResultsAddToCard(driver);
    }
}
