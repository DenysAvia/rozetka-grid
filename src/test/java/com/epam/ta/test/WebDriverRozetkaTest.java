package com.epam.ta.test;

import com.epam.ta.page.RozetkaHomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebDriverRozetkaTest extends CommonConditions {
    @Test(description = "JIRA-0001")
    public void verifyHomePageTitleTest(){
        new RozetkaHomePage(driver)
                .openPage();

        Assert.assertEquals(EXPECTED_RESULTS_TITLE,driver.getTitle());

    }
    @Test(description = "JIRA-0002")
    public void commonSearchTermResultsAreNotEmpty(){

        int expectedSearchResultNumber =  new RozetkaHomePage(driver)
                .openPage()
                .searchResultsTerm("iphone 13 128")
                .searchResultsSize();

        Assert.assertTrue(expectedSearchResultNumber > 0,"Search results are empty!");

    }
    @Test(description = "JIRA-0003")
    public void addToCardCommonTestResultsAreNotEmpty() {

        int expectedAddToCardResultNumber = new RozetkaHomePage(driver)
                .openPage()
                .searchResultsTerm("Exide Start-Stop EFB 80")
                .addToCard()
                .basketOpen()
                .addToCardResultsSize();

        Assert.assertTrue(expectedAddToCardResultNumber > 0, "Basket is empty!");
    }






}
