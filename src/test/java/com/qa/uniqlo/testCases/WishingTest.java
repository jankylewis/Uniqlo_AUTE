package com.qa.uniqlo.testCases;

import com.qa.uniqlo.base.AbstractTest;
import com.qa.uniqlo.models.data.AccountManagement;
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

    @Test(testName = "", description = "")
    public void wishingTest_01() throws Exception {
        setUpMethod();
        /* prepare data */
        String userEmail= properties.getProperty("userEmail");
        String userPassword= properties.getProperty("userPassword");
        String searchKey= "sw";
        int wishedItemQuantity= 4;
        /* actions */
        homePage.clickOnLogInCTA();
        logInPage.doLogIn(userEmail, userPassword);
        homePage.doSearch(searchKey);
        searchingPage.wishProduct(wishedItemQuantity);
        homePage.navigateToWishPage();
        wishPage.retractWishedProduct();

        Thread.sleep(6000);
        tearDownMethod();


    }
}
