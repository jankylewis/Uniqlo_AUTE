package com.qa.uniqlo.pages;

import com.microsoft.playwright.Page;
import com.qa.uniqlo.generalKeys.CommonHandling;
import com.qa.uniqlo.utilities.logs.Log;
import org.jetbrains.annotations.NotNull;

public class LogInPage {

    private Page page;
    private CommonHandling cmHandler= new CommonHandling();
    private String errorTxt= "Sorry, this does not match our records. Check the spelling and try again.";
    private String TXT_EMAIL= "//input[@type= \"email\" and @name= \"login_id\"]";
    private String TXT_PASSWORD= "//input[@type= \"password\" and @name= \"password\"]";
    private String CTA_LOGIN= "//a[@data-test= \"login-button\"]";
    private String CTA_REGISTER= "//a[@data-test= \"create-an-account-button\"]";
    private String LBL_LOGIN_HEADER= "//h1/span[contains(text(), \"Login\")]";
    private String LBL_ERROR= "//div[contains(@class, \"error-list\")]/div";

    public LogInPage(Page page) {
        this.page= page;
    }

    public void setEmail(String userEmail) {
        cmHandler.setTxtIntoElement(TXT_EMAIL, cmHandler.normalizeStr(userEmail));
        Log.info("INPUTTED "+ userEmail+ " SUCCESSFULLY >>");
    }

    public void setPassword(String userPassword) {
        cmHandler.setTxtIntoElement(TXT_PASSWORD, userPassword);
        Log.info("INPUTTED "+ userPassword+ " SUCCESSFULLY >>");
    }

    public void doLogIn(
            String userEmail,
            String userPassword)
            throws Exception{
        setEmail(userEmail);
        setPassword(userPassword);
        clickOnLogInCTA();
    }

    public void clickOnLogInCTA() {
        cmHandler.clickOnElement(CTA_LOGIN);
        Log.info("CLICKED ON LOGIN CTA AT LOGIN PAGE >>");
    }

    public void verifyIfHeaderIsLogin(@NotNull String logInTxt) {
        cmHandler.verifyIfSelectorHasTxt(LBL_LOGIN_HEADER, logInTxt.toUpperCase());
        Log.info("THE LOGIN HEADER IS PRESENTED >>");
    }

    public void verifyIfErrorIsPresented() {
        cmHandler.verifyIfSelectorHasTxt(LBL_ERROR, errorTxt);
        Log.warn("THE ERROR MESSAGE IS PRESENTED >>");
    }
}
