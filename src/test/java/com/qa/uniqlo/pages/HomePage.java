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
    private String CTA_LIST_MEN_TEESHIRTS= "(//div[contains(@class, \"global-nav\")])[3]//span[contains(text(), \"T-shirts\")][parent::div[parent::a[contains(@href, \"/vn/en/men/tops/t-shirts\")]]]";
    private String CTA_LIST_MEN_ALLTOPS= "(//div[contains(@class, \"global-nav\")])[3]//span[contains(text(), \"All Tops\")][parent::div[parent::a[contains(@href, \"/vn/en/men/tops/tops\")]]]";
    private String CTA_LIST_MEN_ALLPANTS= "(//div[contains(@class, \"global-nav\")])[3]//span[contains(text(), \"All Pants\")][parent::div[parent::a[contains(@href, \"/vn/en/men/bottoms/bottoms\")]]]";
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

    public void navigateToSpecificProductPage(String genderSector, String sectorCategorized) {
        String menSector= "men";
        String womenSector= "women";
        String kidsSector= "kids";
        String babySector= "baby";
        if (commonHandler.verifyIfStringIsContained(menSector, genderSector)) {
            commonHandler.hoverOnElement(CTA_LIST_MEN_GARMENT_MENU);
            /* tops started */
            if (commonHandler.verifyIfStringIsEqualized("teeshirts", sectorCategorized)) {
                Log.info("ABOUT TO CLICK ON T-SHIRTS CATEGORY >>   ");
                commonHandler.clickOnElement(CTA_LIST_MEN_TEESHIRTS);
            }
            if (commonHandler.verifyIfStringIsContained("all tops", sectorCategorized)) {
                Log.info("ABOUT TO CLICK ON ALL TOPS CATEGORY >>   ");
                commonHandler.clickOnElement(CTA_LIST_MEN_ALLTOPS);
            }
            if (commonHandler.verifyIfStringIsContained("UT", sectorCategorized) ||
                    commonHandler.verifyIfStringIsContained("graphic t-shirts", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("sweatshirts & hoodies", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("polo shirts", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("casual shirts", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("dress shirts", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("cardigans", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("sweaters", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("fleece", sectorCategorized)) {}
            /* outerwear started */
            if (commonHandler.verifyIfStringIsContained("all outerwear", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("blousons & parkas", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("jackets", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("coats", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("ultra light down", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("down jackets & coats", sectorCategorized)) {}
            /* pants started */
            if (commonHandler.verifyIfStringIsContained("all pants", sectorCategorized)) {
                Log.info("ABOUT TO CLICK ON ALL TOPS CATEGORY >>   ");
                commonHandler.clickOnElement(CTA_LIST_MEN_ALLPANTS);
            }
            if (commonHandler.verifyIfStringIsContained("jeans & colored jeans", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("chinos", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("slacks & dress pants", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("relaxed pants", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("sweat pants", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("ankle pants", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("shorts", sectorCategorized)) {}
            /* innerwear & underwear started */
            if (commonHandler.verifyIfStringIsContained("all innerwears & underwears", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("airism innerwear", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("heattech innerwear & thermal underwear", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("undershirts", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("leggings & tights", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("boxers & briefs", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("socks", sectorCategorized)) {}
            /* loungewear & homewear started */
            if (commonHandler.verifyIfStringIsContained("all loungewear & homewear", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("loungewears & pajamas", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("room shoes", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("home accessories", sectorCategorized)) {}
            /* sport utility wear started */
            if (commonHandler.verifyIfStringIsContained("sport utility wear", sectorCategorized)) {}
            /* accessories started */
            if (commonHandler.verifyIfStringIsContained("all accessories", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("airism masks", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("hats & caps", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("gloves", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("scarves", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("bags", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("belts", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("shoes & boots", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("umbrellas", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("sunglasses", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("others", sectorCategorized)) {}

        }
        if (commonHandler.verifyIfStringIsEqualized(womenSector, genderSector)) {
            commonHandler.hoverOnElement(CTA_LIST_WOMEN_GARMENT_MENU);
            /* outerwear started */
            if (commonHandler.verifyIfStringIsContained("all outerwear", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("blousons & parkas", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("jackets", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("coats", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("ultra light down", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("fleece", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("down jackets & coats", sectorCategorized)) {}
            /* tops started */
            if (commonHandler.verifyIfStringIsContained("all tops", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("t-shirts", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("ut", sectorCategorized) ||
                    commonHandler.verifyIfStringIsContained("graphic t-shirts", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("sweatshirts & hoodies", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("shirts and blouses", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("cardigans", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("sweaters", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("fleece", sectorCategorized)) {}
            /* pants started */
            if (commonHandler.verifyIfStringIsContained("all pants", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("jeans", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("leggings pants & jeggings", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("wide leg pants", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("trousers", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("sweat pants", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("casual pants", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("ankle & cropped pants", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("shorts", sectorCategorized)) {}
            /* skirts started */
            if (commonHandler.verifyIfStringIsContained("skirts", sectorCategorized)) {}
            /* sport utility wear started */
            if (commonHandler.verifyIfStringIsContained("sport utility wear", sectorCategorized)) {}
            /* dresses & jumpsuits started */
            if (commonHandler.verifyIfStringIsContained("dresses & jumpsuits", sectorCategorized)) {}
            /* accessories started */
            if (commonHandler.verifyIfStringIsContained("all accessories", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("airism masks", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("hats & caps", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("gloves", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("scarves", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("bags", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("belts", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("shoes & boots", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("umbrellas", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("sunglasses", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("others", sectorCategorized)) {}
            /* innerwear & underwear started */
            if (commonHandler.verifyIfStringIsContained("all innerwear & underwear", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("bra", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("bra tops & camisoles", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("airism innerwear", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("heattech innerwear & thermal underwear", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("undershirts", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("leggings & tights", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("underwear", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("socks", sectorCategorized)) {}
            /* loungewear & homewear started */
            if (commonHandler.verifyIfStringIsContained("all loungewear & homewear", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("loungewear & pajamas", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("room shoes", sectorCategorized)) {}
            /* maternity clothes started */
            if (commonHandler.verifyIfStringIsContained("maternity clothes", sectorCategorized)) {}
        }
        if (commonHandler.verifyIfStringIsContained(kidsSector, genderSector)) {
            commonHandler.hoverOnElement(CTA_LIST_KIDS_GARMENT_MENU);
            /* outerwear started */
            if (commonHandler.verifyIfStringIsContained("all outerwear", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("jackets & coats", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("blousons & parkas", sectorCategorized)) {}
            /* tops started */
            if (commonHandler.verifyIfStringIsContained("all tops", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("t-shirts", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("ut", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("graphic t-shirts", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("sweatshirts & hoodies", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("shirts & blouses", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("sweaters & cardigans", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("fleece", sectorCategorized)) {}
            /* pants started */
            if (commonHandler.verifyIfStringIsContained("all pants", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("pants", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("shorts", sectorCategorized)) {}
            /* skirts started */
            if (commonHandler.verifyIfStringIsContained("skirts", sectorCategorized)) {}
            /* sport utility wear started */
            if (commonHandler.verifyIfStringIsContained("sport utility wear", sectorCategorized)) {}
            /* dresses & overalls started */
            if (commonHandler.verifyIfStringIsContained("dresses & overalls", sectorCategorized)) {}
            /* accessories started */
            if (commonHandler.verifyIfStringIsContained("all accessories", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("airism masks", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("others", sectorCategorized)) {}
            /* innerwear & underwear started */
            if (commonHandler.verifyIfStringIsContained("all innerwear & underwear", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("undershirts", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("airism innerwear", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("heattech innerwear & thermal underwear", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("bras & bra top", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("leggings & tights", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("underwear", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("socks", sectorCategorized)) {}
            /* loungewear & homewear started */
            if (commonHandler.verifyIfStringIsContained("loungewear & pajamas", sectorCategorized)) {}
        }
        if (commonHandler.verifyIfStringIsContained(babySector, genderSector)) {
            commonHandler.hoverOnElement(CTA_LIST_INFANT_GARMENT_MENU);
            /* newborn (0-3 months) started */
            if (commonHandler.verifyIfStringIsContained("outerwear", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("one-pieces", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("accessories", sectorCategorized)) {}
            /* newborn (3-24 months) started */
            if (commonHandler.verifyIfStringIsContained("all newborn", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("outerwear", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("one-pieces", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("tops", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("bodysuits", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("ut", sectorCategorized) ||
                    commonHandler.verifyIfStringIsContained("graphic t-shirts", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("dresses", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("airism innerwear", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("socks", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("accessories", sectorCategorized)) {}
            /* toddler (6 months - 5 years) started */
            if (commonHandler.verifyIfStringIsContained("all toddler", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("outerwear", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("tops", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("pants & leggings", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("loungewear & pajamas", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("dresses", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("ut", sectorCategorized) ||
                    commonHandler.verifyIfStringIsContained("graphic t-shirts", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("heattech innerwear & thermal underwear", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("innerwear & underwear", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("airism innerwear", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("socks", sectorCategorized)) {}
            if (commonHandler.verifyIfStringIsContained("accessories", sectorCategorized)) {}
        }
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

    public void clickOnProfileCTA() throws Exception{
        commonHandler.waitForPageToLoad(LoadState.NETWORKIDLE, 0);
        commonHandler.hoverOnElement(CTA_ACCOUNT);
        Log.info("HOVERED IN ACCOUNT CTA AT HOME PAGE >>");
        commonHandler.clickOnElement(CTA_ACCOUNT_PROFILE);
        Log.info("CLICKED ON ACCOUNT PROFILE CTA AT HOME PAGE >>");
    }


}

