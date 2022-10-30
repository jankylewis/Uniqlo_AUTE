package com.qa.uniqlo.testCases;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import com.qa.uniqlo.base.AbstractTest;
import com.qa.uniqlo.models.AccountManagement;
import com.qa.uniqlo.utilities.logs.Log;
import org.testng.annotations.*;

public class LogInTest extends AbstractTest {

    @BeforeMethod(enabled = false)
    private void setUpMethod() {
        setUpTestCase();
    }

    @AfterMethod(enabled = false)
    private void tearDownMethod() {
        tearDownTestCase();
    }

    @Test(groups = {"01"},
            priority = 1,
            invocationCount = 5)
    public void logInTest_01() throws Exception {
        setUpMethod();
        /* prepare data */
        AccountManagement accountModel= new AccountManagement();
        accountModel.setUserEmail(properties.getProperty("userEmail"));
        accountModel.setUserPassword(properties.getProperty("userPassword"));
        String userEmail= accountModel.getUserEmail();
        String userPwd= accountModel.getUserPassword();
        /* actions */
        homePage.clickOnLogInCTA();
        logInPage.verifyIfHeaderIsLogin("LOGIN");
        logInPage.doLogIn(userEmail, userPwd);

//        page.waitForLoadState(LoadState.valueOf("NETWORKIDLE"));
        homePage.clickOnProfileCTA();
        myProfilePage.verifyUserEmail(userEmail);
        Log.info("EXECUTED TEST CASE LOGIN_01");
        tearDownMethod();
    }

    @Test(groups = {"03"},
            priority = 3)
    @Parameters("redundantTxt")
    private void logInTest_03(@Optional("txt") String redundantTxt) throws Exception {
        /* prepare data */
        setUpMethod();
        AccountManagement accountModel= new AccountManagement();
        accountModel.setUserEmail(properties.getProperty("userEmail"));
        accountModel.setUserPassword(properties.getProperty("userPassword"));
        String userEmail= accountModel.getUserEmail();
        String userPwd= accountModel.getUserPassword();
        /* actions */
        homePage.clickOnLogInCTA();
        logInPage.verifyIfHeaderIsLogin("LOGIN");
        logInPage.doLogIn(userEmail, userPwd+ redundantTxt);
        logInPage.verifyIfErrorIsPresented();
        Log.info("EXECUTED TEST CASE LOGIN_03");
        tearDownMethod();
    }

    @Test(groups = {"02"},
            priority = 2)
    @Parameters("redundantTxt")
    private void logInTest_02(@Optional("txt") String redundantTxt) throws Exception {
        /* prepare data */
        setUpMethod();
        Log.info(redundantTxt);
        AccountManagement accountModel= new AccountManagement();
        accountModel.setUserEmail(properties.getProperty("userEmail"));
        accountModel.setUserPassword(properties.getProperty("userPassword"));
        String userEmail= accountModel.getUserEmail();
        String userPwd= accountModel.getUserPassword();
        /* actions */
        homePage.clickOnLogInCTA();
        logInPage.verifyIfHeaderIsLogin("LOGIN");
        logInPage.doLogIn(userEmail+ redundantTxt, userPwd);
        logInPage.verifyIfErrorIsPresented();
        Log.info("EXECUTED TEST CASE LOGIN_02");
        tearDownMethod();
    }
}
