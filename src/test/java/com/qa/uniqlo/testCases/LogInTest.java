package com.qa.uniqlo.testCases;

import com.qa.uniqlo.base.AbstractTest;
import com.qa.uniqlo.models.AccountManagement;
import com.qa.uniqlo.utilities.logs.Log;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
            priority = 1)
    public void logInTest_01() throws Exception {
        setUpMethod();
        /* prepare data */
        AccountManagement accountModel= new AccountManagement();
        accountModel.setUserEmail(prop.getProperty("userEmail"));
        accountModel.setUserPassword(prop.getProperty("userPassword"));
        String userEmail= accountModel.getUserEmail();
        String userPwd= accountModel.getUserPassword();
        /* actions */
        homePage.clickOnLogInCTA();
        logInPage.verifyIfHeaderIsLogin("LOGIN");
        logInPage.doLogIn(userEmail, userPwd);
        homePage.clickOnProfileCTA();
        myProfilePage.verifyUserEmail(userEmail);
        Log.info("EXECUTED TEST CASE LOGIN_01");
        tearDownMethod();
    }

    @Test(groups = {"02"},
            priority = 2)
    private void logInTest_02() throws Exception {
        /* prepare data */
        setUpMethod();
        AccountManagement accountModel= new AccountManagement();
        accountModel.setUserEmail(prop.getProperty("userEmail"));
        accountModel.setUserPassword(prop.getProperty("userPassword"));
        String userEmail= accountModel.getUserEmail();
        String userPwd= accountModel.getUserPassword();
        /* actions */
        homePage.clickOnLogInCTA();
        logInPage.verifyIfHeaderIsLogin("LOGIN");
        logInPage.doLogIn(userEmail+ "txt", userPwd);
        logInPage.verifyIfErrorIsPresented();
        Log.info("EXECUTED TEST CASE LOGIN_02");
        tearDownMethod();
    }

    @Test(groups = {"03"},
            priority = 3)
    private void logInTest_03() throws Exception {
        /* prepare data */
        setUpMethod();
        AccountManagement accountModel= new AccountManagement();
        accountModel.setUserEmail(prop.getProperty("userEmail"));
        accountModel.setUserPassword(prop.getProperty("userPassword"));
        String userEmail= accountModel.getUserEmail();
        String userPwd= accountModel.getUserPassword();
        /* actions */
        homePage.clickOnLogInCTA();
        logInPage.verifyIfHeaderIsLogin("LOGIN");
        logInPage.doLogIn(userEmail, userPwd+ "txt");
        logInPage.verifyIfErrorIsPresented();
        Log.info("EXECUTED TEST CASE LOGIN_03");
        tearDownMethod();
    }
}
