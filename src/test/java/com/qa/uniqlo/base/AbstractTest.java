package com.qa.uniqlo.base;

import com.microsoft.playwright.Page;
import com.qa.uniqlo.pages.*;
import com.qa.uniqlo.factory.PlaywrightFactory;
import com.qa.uniqlo.pages.shoppingCartPage.ShoppingCartPage;
import com.qa.uniqlo.pages.specificProductCategoryPage.BaseProductPage;
import com.qa.uniqlo.pages.specificProductCategoryPage.menPage.AllPantsPage;
import com.qa.uniqlo.pages.specificProductCategoryPage.menPage.AllTopsPage;
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
    protected BaseProductPage baseProductPage;
    protected AllTopsPage allTopsPage;
    protected AllPantsPage allPantsPage;
    protected WishingPage wishingPage;
    protected DetailedProductPage detailedProductPage;
    protected ShoppingCartPage shoppingCartPage;
    protected TransactionCheckoutPage transactionCheckoutPage;
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
        allTopsPage= new AllTopsPage(page);
        allPantsPage= new AllPantsPage(page);
        baseProductPage= new BaseProductPage(page);
        wishingPage= new WishingPage(page);
        detailedProductPage= new DetailedProductPage(page);
        shoppingCartPage= new ShoppingCartPage(page);
        transactionCheckoutPage= new TransactionCheckoutPage(page);
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