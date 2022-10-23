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

    @Test
    public void searchingByGuestTest_01() throws Exception {
        setUpMethod();
        /* prepare data */
        final String searchKey= "track";
        /* actions */
        homePage.doSearch("track");
        Thread.sleep(4000);
        tearDownMethod();


    }

}
