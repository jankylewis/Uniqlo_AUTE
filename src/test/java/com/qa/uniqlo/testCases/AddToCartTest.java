package com.qa.uniqlo.testCases;

import com.qa.uniqlo.base.AbstractTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddToCartTest extends AbstractTest {

    @BeforeMethod(enabled = false)
    private void setUpMethod() {
        setUpTestCase();
    }

    @AfterMethod (enabled = false)
    private void tearDownMethod() {
        tearDownTestCase();
    }

    @Test(testName = "", description = "")
    public void addToCartByGuest_01() throws Exception{
        setUpMethod();



        tearDownMethod();
    }


}
