package com.qa.uniqlo.base;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.qa.uniqlo.pages.LogInPage;
import com.qa.uniqlo.pages.MyProfilePage;
import com.qa.uniqlo.factory.PlaywrightFactory;
import com.qa.uniqlo.pages.HomePage;
import com.qa.uniqlo.pages.SearchingPage;
import com.qa.uniqlo.pages.specificProductCategoryPage.menPage.TeeShirtsPage;
import com.qa.uniqlo.utilities.logs.Log;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.Properties;

public class AbstractTest {

    PlaywrightFactory playwrightFactory;
    protected static Page page;
    protected Properties properties;
    protected HomePage homePage;
    protected LogInPage logInPage;
    protected MyProfilePage myProfilePage;
    protected SearchingPage searchingPage;
    protected TeeShirtsPage teeShirtsPage;
    @BeforeClass(enabled = false)
    public void setUpTestCase() {
        playwrightFactory= new PlaywrightFactory();
        properties= playwrightFactory.init_prop();
        page= playwrightFactory.initBrowser(properties);
        System.out.println("\r");
        Log.info("TRIGGER BROWSER >>");
        System.out.println("\r");
        homePage= new HomePage(page);
        logInPage= new LogInPage(page);
        myProfilePage= new MyProfilePage(page);
        searchingPage= new SearchingPage(page);
        teeShirtsPage= new TeeShirtsPage(page);
    }
    @AfterClass(enabled = false)
    public void tearDownTestCase() {
        try {
            if (page.context().cookies()!= null) {
                page.context().clearCookies();
                Log.info("DELETED ALL COOKIES >>");
                page.context().browser().close();
            }
            else {
                page.context().browser().close();
                
                Log.warn("THERE IS NO COOKIES TO BE DELETED >>");
            }
        }
        catch (final Exception exception){
            Log.error(exception.getMessage());;
        }
        System.out.println("\r");
        Log.warn("REPELLED BROWSER >>");
        System.out.println("\r");
    }
}