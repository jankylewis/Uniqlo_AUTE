package com.qa.uniqlo.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import com.qa.uniqlo.generalKeys.CommonHandling;
import com.qa.uniqlo.utilities.logs.Log;

public class HomePage {
    private Page page;
    private CommonHandling commonHandler= new CommonHandling();
    private String CTA_UNIQLO_LOGO= "//a[@aria-current= \"page\"]";
    private String CTA_LIST_WOMEN_GARMENT_MENU= "//li[@data-test= \"women-navItem\"]/a[div/span[contains(text(), \"women\")]]";
    private String CTA_LIST_MEN_GARMENT_MENU= "//li[@data-test= \"men-navItem\"]/a[div/span[contains(text(), \"men\")]]";
    private String CTA_LIST_KIDS_GARMENT_MENU= "//li[@data-test= \"kids-navItem\"]/a[div/span[contains(text(), \"kids\")]]";
    private String CTA_LIST_INFANT_GARMENT_MENU= "//li[@data-test= \"baby-navItem\"]/a[div/span[contains(text(), \"baby\")]]";

    private String CTA_LOGIN= "//a[@title= \"Login\"]/span[@aria-label= \"Login\"]";
    private String CTA_CART= "//a/span[@class= \"fr-icon\" and contains((@aria-label), \"Cart\")]";
    private String CTA_WISH= "//a/span[@class= \"fr-icon\" and contains((@aria-label), \"Wish list\")]";
    private String CTA_HELP= "//div/a[span[contains(text(), \"Help\")]]";
    private String CTA_MAP= "//div/button[span[contains(text(), \"locator\")]]";
    private String CTA_ENGLISH= "//div/button[span[contains(text(), \"locator\")]]";
    private String CTA_VIETNAMESE= "//div[contains((@class), \"nav-item language\")]//button[span[contains(text(), \"Tiếng Việt\")]]";
    private String TXT_SEARCH= "//input[@id= \"searchInput\"]";
    private String CTA_SEARCH= "//button[@aria-label= \"Search\"]/span[span[contains(text(), \"Search\")]]";
    private String CTA_ACCOUNT= "//a[@title= \"Account\"]/span[@aria-label= \"Account\"]/*[name()=\"svg\"]";
    private String CTA_ACCOUNT_PROFILE= "//div[@role= \"listbox\"]/a[contains(text(), \"Profile\")]";
    private String CTA_ACCOUNT_LOGOUT= "//div[@role= \"listbox\"]/button[contains(text(), \"Logout\")]";
    private String CTA_ACCOUNT_COUPONS;
    private String CTA_ACCOUNT_PURCHASED_HISTORY;
    private String CTA_ACCOUNT_ORDERED_HISTORY;
    private String CTA_ACCOUNT_WISH;

    public HomePage(Page page) {
        this.page= page;
    }

    public String getHomePageTitle() {
        String homePageTitle= page.title();
        Log.info("PAGE TITLE= "+ homePageTitle);
        return homePageTitle;
    }

    public String getHomePageUrl() {
        String homePageUrl= page.url();
        Log.info("PAGE URL= "+ homePageUrl);
        return homePageUrl;
    }

    public void doSearch(String searchKey) {
        commonHandler.setTxtIntoElement(TXT_SEARCH, searchKey);
        commonHandler.keyPressedEnter();
        Log.info("CONDUCTED SEARCH >>");
    }

    public void clickOnLogInCTA() {
        commonHandler.clickOnElement(CTA_LOGIN);
        Log.info("CLICKED ON LOGIN CTA AT HOME PAGE >>");
    }

    public void clickOnProfileCTA() {
        commonHandler.waitForPageToLoad(LoadState.NETWORKIDLE);
        commonHandler.hoverOnElement(CTA_ACCOUNT);
        Log.info("HOVERED IN ACCOUNT CTA AT HOME PAGE >>");
        commonHandler.clickOnElement(CTA_ACCOUNT_PROFILE);
        Log.info("CLICKED ON ACCOUNT PROFILE CTA AT HOME PAGE >>");
    }
}

