package com.qa.uniqlo.testCases;

import com.qa.uniqlo.base.AbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends AbstractTest {

    @Test(testName = "title", enabled = true, skipFailedInvocations = false)
    private void homePageTitleTest() {
        String actTitle= homePage.getHomePageTitle();
        String expTitle= "LocknLock Mall";
        Assert.assertEquals(actTitle, expTitle);
    }

    @Test
    private void homePageUrlTest() {
        String actUrl= homePage.getHomePageUrl();
        String expUrl= "https://locknlock.vn/index.html";
        Assert.assertEquals(actUrl, expUrl);
    }

    @Test
    private void searchTest() {
        String expSearchHeaderTxt= "Tìm kiếm";
        String actSearchHeaderTxt= homePage.doSearch("");
        Assert.assertEquals(actSearchHeaderTxt, expSearchHeaderTxt);
    }
}
