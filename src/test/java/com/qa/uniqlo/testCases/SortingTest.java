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

    @Test(description = "MEN", testName = "")
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
        teeShirtsPage.verifyTestCaseSortingPassed(sortingCriterion);
        tearDownMethod();
    }
    @Test(description = "MEN", testName = "")
    public void sortingByGuestTest_02() throws Exception {
        setUpMethod();
        /* Step: prepare test data */
        final String sector= "men";
        final String sectorCategorized= "teeshirts";
        final String sortingCriterion= "low to high";
        /* Step: navigate to specific product page */
        homePage.navigateToSpecificProductPage(sector, sectorCategorized);
        teeShirtsPage.doSorting(sortingCriterion);
        teeShirtsPage.verifyTestCaseSortingPassed(sortingCriterion);
        tearDownMethod();
    }
    @Test(description = "MEN", testName = "")
    public void sortingByGuestTest_03() throws Exception {
        setUpMethod();
        /* Step: prepare test data */
        final String sector= "men";
        final String sectorCategorized= "all tops";
        final String sortingCriterion= "high to low";
        /* Step: navigate to specific product page */
        homePage.navigateToSpecificProductPage(sector, sectorCategorized);
        allTopsPage.doSorting(sortingCriterion);
        allTopsPage.verifyTestCaseSortingPassed(sortingCriterion);
        tearDownMethod();
    }
    @Test(description = "MEN", testName = "")
    public void sortingByGuestTest_04() throws Exception {
        setUpMethod();
        /* Step: prepare test data */
        final String sector= "men";
        final String sectorCategorized= "all pants";
        final String sortingCriterion= "high to low";
        /* Step: navigate to specific product page */
        homePage.navigateToSpecificProductPage(sector, sectorCategorized);
        allPantsPage.doSorting(sortingCriterion);
        allPantsPage.verifyTestCaseSortingPassed(sortingCriterion);
        tearDownMethod();
    }



}
