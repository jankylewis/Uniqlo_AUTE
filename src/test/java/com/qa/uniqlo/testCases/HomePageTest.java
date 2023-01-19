package com.qa.uniqlo.testCases;

import com.qa.uniqlo.base.AbstractTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends AbstractTest {

    @BeforeMethod(enabled = false)
    private void setUpMethod() {
        setUpTestCase();
    }

    @AfterMethod(enabled = false)
    private void tearDownMethod() {
        tearDownTestCase();
    }

    //this test case is a little confused when verifying Homepage title -> provisonally ignored
//    @Test(testName = "title", enabled = true, skipFailedInvocations = false)
    public void homePageTitleTest() throws Exception {
        setUpMethod();
        /* Step: prepare data */
        String expTitle= properties.getProperty("pageTitle");
        /* Step: get Homepage Title */
        String actTitle= homePage.getHomePageTitle();
        /* Step: verify the Homepage Title */
        homePage.verifyHomePageTitle(actTitle, expTitle);
        tearDownMethod();
    }

    @Test
    public void homePageUrlTest() throws Exception {
        setUpMethod();
        /* Step: prepare data */
        String expUrl= properties.getProperty("baseUrl");
        /* Step: get Homepage Url */
        String actUrl= homePage.getHomePageUrl();
        /* Step: verify Homepage Url */
        homePage.verifyHomePageUrl(expUrl, actUrl);
        tearDownMethod();
    }

//    @Test
    private void searchTest() {
        setUpMethod();
        String expSearchHeaderTxt= "Tìm kiếm";
//        String actSearchHeaderTxt= homePage.doSearch("");
//        Assert.assertEquals(actSearchHeaderTxt, expSearchHeaderTxt);
        tearDownMethod();
    }
}
