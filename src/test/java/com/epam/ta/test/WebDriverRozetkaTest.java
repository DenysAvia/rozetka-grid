package com.epam.ta.test;

import com.epam.ta.page.RozetkaHomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
//Please use this command for hub and nodes setup docker-compose -f ./src/test/java/com/epam/ta/test/docker-compose-v2.yml up
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
                .searchResultsTerm("xiaomi redmi note 11")
                .searchResultsSize();

        Assert.assertTrue(expectedSearchResultNumber > 0,"Search results are empty!");

    }
    @Test(description = "JIRA-0003")
    public void addToCardCommonTestResultsAreNotEmpty() {

        int expectedAddToCardResultNumber = new RozetkaHomePage(driver)
                .openPage()
                .searchResultsTerm("lenovo legion")
                .addToCard()
                .basketOpen()
                .addToCardResultsSize();

        Assert.assertTrue(expectedAddToCardResultNumber > 0, "Basket is empty!");
    }






}
