package com.qa.uniqlo.testCases;

import com.qa.uniqlo.base.AbstractTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SortingTest extends AbstractTest {

    @BeforeMethod(enabled = false)
    private void setUpMethod() {
        setUpTestCase();
    }

    @AfterMethod(enabled = false)
    private void tearDownMethod() {
        tearDownTestCase();
    }

    @Test(description = "")
    public void sortingByGuestTest_01() throws Exception {
        setUpMethod();
        /* Step: prepare test data */
        final String sector= "men";
        final String sectorCategorized= "teeshirts";
        final String sortingCriterion= "high to low";
        /* Step: navigate to specific product page */
        homePage.navigateToSpecificProductPage(sector, sectorCategorized);
        teeShirtsPage.verifyTextOfLabel();
        teeShirtsPage.doSorting(sortingCriterion);


        tearDownMethod();


    }



}
