package com.qa.uniqlo.pages.specificProductCategoryPage.menPage;

import com.microsoft.playwright.Page;
import com.qa.uniqlo.generalKeys.CommonHandling;
import com.qa.uniqlo.utilities.logs.Log;

import java.util.concurrent.TimeoutException;

import static com.qa.uniqlo.generalKeys.Constants.*;

public class TeeShirtsPage {

    private CommonHandling commonHandler= new CommonHandling();
    private Page page;
    private String LBL_PRODUCT_NAME_CHILD= "//div[@id and contains(@class, \"fr-product-card default\")]//h2";
    private String CTA_LOAD_MORE= "//div[@data-test= \"globalNavRoot\"]//following::span[contains(text(), \"Load more\")]";
    private String DDL_SORTED_BY= "//div[@type= \"button\" and @role][span[contains(text(), \"Featured\")]]";
    private String DDI_SORTED_BY_NEW_ARRIVALS= "//ul[@role= \"listbox\"]//li[contains(text(), \"New arrivals\")]";
    private String DDI_SORTED_BY_LOW_TO_HIGH= "//ul[@role= \"listbox\"]//li[contains(text(), \"Low to high\")]";
    private String DDI_SORTED_BY_HIGH_TO_LOW= "//ul[@role= \"listbox\"]//li[contains(text(), \"High to low\")]";
    private String DDI_SORTED_BY_TOP_RATED= "//ul[@role= \"listbox\"]//li[contains(text(), \"Top rated\")]";
    private String LBL_MEN= "//ol[contains(@class, \"breadcrumbs\")]//li[2]//a";
    private String LBL_MEN_CATEGORIZED= "//ol[contains(@class, \"breadcrumbs\")]//li/span";
    private String LBL_HEADING= "//h3[contains(@class, \"head\")]/span";
    private final String menTxt= "MEN";
    private final String teeShirtsTxt= "T-SHIRTS";



    public TeeShirtsPage(Page page) {
        this.page= page;
    }

    public void doSorting(String sortingCriterion) throws Exception {
        String lowToHigh= "low to high";
        String highToLow= "high to low";
        String topRated= "top rated";
        String newArrivals= "new arrivals";
        commonHandler.waitForPageToLoad(LOAD_STATE, TIMEOUT3000MS);
        commonHandler.clickOnElement(DDL_SORTED_BY);
        if (commonHandler.verifyIfStringIsEqualized(sortingCriterion, lowToHigh)) {
            commonHandler.clickOnElement(DDI_SORTED_BY_LOW_TO_HIGH);
        }
        if (commonHandler.verifyIfStringIsEqualized(sortingCriterion, highToLow)) {
            commonHandler.clickOnElement(DDI_SORTED_BY_HIGH_TO_LOW);
        }
        if (commonHandler.verifyIfStringIsEqualized(sortingCriterion, topRated)) {
            commonHandler.clickOnElement(DDI_SORTED_BY_TOP_RATED);
        }
        if (commonHandler.verifyIfStringIsEqualized(sortingCriterion, newArrivals)) {
            commonHandler.clickOnElement(DDI_SORTED_BY_NEW_ARRIVALS);
        }
    }

    public void verifyTextOfLabel() {
        verifyBreadCrumbMenLabel();
        Log.info("BREADCRUMB CONTAINED MEN LABEL {MEN}"+ " >>   ");
        verifyBreadCrumbTeeShirtsLabel();
        Log.info("BREADCRUMB CONTAINED T-SHIRTS LABEL {T-shirts}"+ " >>   ");
        verifyHeading();
        Log.info("BREADCRUMB CONTAINED HEADING {MEN}"+ " >>   ");
    }

    public void verifyHeading() {
        String headingGetTxt= page.locator(LBL_HEADING).textContent();
        commonHandler.verifyIfStringIsEqual(menTxt, headingGetTxt);
    }

    public void verifyBreadCrumbMenLabel() {
        String menGetTxt= page.locator(LBL_MEN).textContent();
        commonHandler.verifyIfStringIsEqual(menTxt, menGetTxt);
    }

    public void verifyBreadCrumbTeeShirtsLabel() {
        String teeShirtsGetTxt= page.locator(LBL_MEN_CATEGORIZED).textContent();
        commonHandler.verifyIfStringIsEqual(teeShirtsTxt, teeShirtsGetTxt);
    }



}
