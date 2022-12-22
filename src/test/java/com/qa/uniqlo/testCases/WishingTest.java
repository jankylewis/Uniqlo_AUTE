package com.qa.uniqlo.testCases;

import com.qa.uniqlo.base.AbstractTest;
import com.qa.uniqlo.models.data.AccountManagement;
import com.qa.uniqlo.models.data.ProductInformation;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WishingTest extends AbstractTest {

    @AfterMethod(enabled = false)
    private void tearDownMethod() {
        tearDownTestCase();
    }

    @BeforeMethod(enabled = false)
    private void setUpMethod() {
        setUpTestCase();
    }

    @Test(testName = "", description = "<= 24; one page; no paging on Searching Page, no paging on Wishing Page")
    public void wishingTest_01() throws Exception {
        setUpMethod();
        /* prepare data */
        String userEmail= properties.getProperty("userEmail");
        String userPassword= properties.getProperty("userPassword");
        String searchKey= "sw";
        int quantityOfWishedItem= 5;
        /* actions */
        homePage.clickOnLogInCTA();
        logInPage.doLogIn(userEmail, userPassword);
        homePage.doSearch(searchKey);
        searchingPage.wishProduct(quantityOfWishedItem);
        ProductInformation wishedProductModel= searchingPage.getWishedProductName(quantityOfWishedItem);
        homePage.navigateToWishPage();
        wishingPage.verifyWishedProductName(wishedProductModel, quantityOfWishedItem);
        wishingPage.retractWishedProduct(quantityOfWishedItem);
        tearDownMethod();
    }

    @Test(testName = "", description = "> 24; comprise paging on Searching Page; paging on Wishing Page")
    public void wishingTest_02() throws Exception {
        setUpMethod();
        /* prepare data */
        String userEmail= properties.getProperty("userEmail");
        String userPassword= properties.getProperty("userPassword");
        String searchKey= "sw";
        int quantityOfWishedItem= 30;
        /* actions */
        homePage.clickOnLogInCTA();
        logInPage.doLogIn(userEmail, userPassword);
        homePage.doSearch(searchKey);
        searchingPage.wishProduct(quantityOfWishedItem);
        ProductInformation wishedProductModel= searchingPage.getWishedProductName(quantityOfWishedItem);
        homePage.navigateToWishPage();
        wishingPage.verifyWishedProductName(wishedProductModel, quantityOfWishedItem);
        wishingPage.retractWishedProduct(quantityOfWishedItem);
        tearDownMethod();
    }
}
