package com.qa.uniqlo.pages;

import com.microsoft.playwright.Page;
import com.qa.uniqlo.generalKeywords.CommonHandling;
import com.qa.uniqlo.base.AbstractTest;
import com.qa.uniqlo.utilities.logs.Log;

public class MyProfilePage extends AbstractTest {

    private CommonHandling cmHandler= new CommonHandling();
    public Page page;
    public MyProfilePage(Page page) {
        this.page= page;
    }

    private String LBL_USEREMAIL= "//span[@data-test= \"member-email\"]";

    public void verifyUserEmail(String expUserEmail) {
        cmHandler.verifyIfSelectorHasTxt(LBL_USEREMAIL, expUserEmail);
        Log.info("THE USER EMAIL IS PRESENTED >>");
    }
}
