package com.qa.uniqlo.testCases;

import com.qa.uniqlo.base.AbstractTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchingTest extends AbstractTest {

    @BeforeMethod(enabled = false)
    private void setUpMethod() {
        setUpTestCase();
    }

    @AfterMethod(enabled = false)
    private void tearDownMethod() {
        tearDownTestCase();
    }

    @Test(description =
            "Searching without pagination")
    public void searchingByGuestTest_01() throws Exception {
        setUpMethod();
        /* Step: prepare data */
        final String searchKey= "track";
        /* Step: do searching */
        homePage.doSearch(searchKey);
        /* Step: verify product name after searching */
        searchingPage.verifyTestCasePassed(searchKey);
        tearDownMethod();
    }

    @Test(description =
            "Searching without returned result")
    public void searchingByGuestTest_02() throws Exception {
        setUpMethod();
        /* Step: prepare data */
        final String searchKey= "track pumpba";
        /* Step: do searching */
        homePage.doSearch(searchKey);
        /* Step: verify the error message is presented */
        searchingPage.verifyTestCaseFailed();
//        tearDownMethod();
    }

    @Test(description =
            "Searching with a pagination")
    public void searchingByGuestTest_03() throws Exception {
        setUpMethod();
        /* Step: prepare data */
        final String searchKey= "l";
        /* Step: do searching */
        homePage.doSearch(searchKey);
        /* Step: verify the product name whether containing searchKey */
        searchingPage.verifyTestCasePassed(searchKey);
    }




}
