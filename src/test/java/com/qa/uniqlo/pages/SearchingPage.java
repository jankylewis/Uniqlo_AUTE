package com.qa.uniqlo.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import com.qa.uniqlo.generalKeys.CommonHandling;
import com.qa.uniqlo.models.data.Searching;
import com.qa.uniqlo.utilities.logs.Log;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;
import org.testng.Assert;

import static com.qa.uniqlo.generalKeys.Constants.*;

import java.util.ArrayList;
import java.util.List;

public class SearchingPage {

    private Page page;
    private CommonHandling commonHandler= new CommonHandling();
    private String LBL_SEARCH_RESULT= "//div[contains(@class, \"search-results-page\")]//h1/span";
    private String LBL_PRODUCT_NAME_CHILD= "//div[@id and contains(@class, \"fr-product-card default\")]//h2";
    private String LBL_PRODUCT_NAME_PARENT= "//div[contains(@class, \"fr-product-grid row\")][//div[@id and contains(@class, \"fr-product-card default\")]]";
    private String LBL_NO_RESULT= "//div[@class= \"fr-text\"][ancestor::div[@data-test]]";
    private String LBL_PRODUCT_PRICE_CHILD;
    private String LBL_PRODUCT_PRICE_PARENT;
    private String CTA_VIEW_MORE= "//div[@data-test= \"searchPageRoot\"]//span[contains(text(), \"View more\")]";
    private String LBL_NUMBER_OF_PRODUCT= "//div[contains(@class, \"results-count\")]/div";
    private String LOADING_INDICATOR= "//div[@data-test= \"loadingIndicator\"][span]";
    private final String noResultMessage= "There are no results that match your search.";
    public SearchingPage(Page page) {
        this.page= page;
    }

    public void verifyTestCasePassed(final String searchKey) throws Exception {
        verifySearchResultLabel(searchKey);
        Searching searchingModel= getProductName();
        verifyProductName(searchingModel, searchKey);
    }

    public void verifyTestCaseFailed() {
        verifyNoResultIsPresent();
    }

//    public void verifyTestCasePassedWithEasyPaging(final String searchKey) throws Exception {
//        getProductNameHavingEasyPaging();
//    }

    public void verifyTestCasePassedWithPagings(final String searchKey) throws Exception {

    }

    public void verifySearchResultLabel(final String searchKey) {
        String searchResultTxt= page.locator(LBL_SEARCH_RESULT).textContent();
        Log.info("SEARCH RESULT CONTENT= "+ searchResultTxt);
        if (commonHandler.verifyIfStringIsEqualized(searchResultTxt, searchKey)) {
            Log.info("SEARCH RESULT LABEL CONTAINED "+ searchKey);
        }
    }

    public void verifyNoResultIsPresent() {
        String noResultTxt= page.locator(LBL_NO_RESULT).textContent();
        Log.info("NO RESULT TEXT CONTENT= "+ noResultTxt);
        if (commonHandler.verifyIfStringIsEqualized(noResultMessage, noResultTxt)){
            Log.info("NO RESULT TEXT IS PRESENTED >>  ");
        }
    }

//    public void verifyProductName(final String searchKey) throws Exception {
//        Searching searchingModel= new Searching();
//        Locator listProductName= page.locator(LBL_PRODUCT_NAME_CHILD);
//        commonHandler.waitForPageToLoad(NETWORK_IDLE_STATE);
//        Log.info("TOTAL PRODUCT= "+ listProductName.count());
//        searchingModel.setListOfProductName(listProductName.allTextContents());
//        List<String> listOfProductName= searchingModel.getListOfProductName();
//        Log.info("LIST PRODUCT NAME= "+ listOfProductName);
//        for (String name: listOfProductName) {
//            Log.info("PRODUCT NAME= "+ name);
//            if (commonHandler.verifyIfStringIsContained(name, searchKey)) {
//                Log.info("PRODUCT NAME CONTAINED "+ searchKey);
//            }
//        }
//    }

    public void verifyProductName(Searching searchingModel, final String searchKey) {
        List<String> listProductName= searchingModel.getListOfProductName();
        Log.info("\r");
        Log.info("LIST PRODUCT NAME= "+ listProductName);
        Log.info("\r");
        for (String productName: listProductName) {
            if (commonHandler.verifyIfStringIsContained(productName, searchKey)) {
                Log.info("SUCCESSFUL VERIFIED: PRODUCT NAME CONTAINED THE KEY: "+ searchKey);
            }
        }
    }

//    public Searching getProductName() throws Exception {
//        Searching searchingModel= new Searching();
//        commonHandler.waitForPageToLoad(NETWORK_IDLE_STATE, 0);
//        int viewMoreCounter= 0;
//        while (!commonHandler.verifyIfStringIsEqualized("0", "1")) {
//            if (commonHandler.verifyIfElementIsPresented(CTA_VIEW_MORE)) {
//                Log.info("VIEW MORE CTA IS VISIBLE >>   ");
//                commonHandler.scrollToElement(CTA_VIEW_MORE);
//                commonHandler.procrastinate(MINTIMEOUT);
//                commonHandler.clickOnElement(CTA_VIEW_MORE);
//                commonHandler.waitForPageToLoad(NETWORK_IDLE_STATE, TIMEOUT1000ms);
//                commonHandler.waitForPageToLoad(DOM_CONTENT_LOADED_STATE, TIMEOUT1000ms);
//                commonHandler.waitForPageToLoad(LOAD_STATE, TIMEOUT1000ms);
//            }
//            else {
//                Log.warn("VIEW MORE CTA IS NOT VISIBLE ANYMORE >>     ");
//                Log.info("THERE WILL BE NO MORE PRODUCTS >>   ");
//                break;
//            }
//            viewMoreCounter++;
//            Log.info("NUMBER OF CLICKING ON VIEW MORE PRODUCTS= "+ viewMoreCounter);
//        }
////        commonHandler.waitForPageToLoad(NETWORK_IDLE_STATE, TIMEOUT1000ms);
//        Locator listProductName= page.locator(LBL_PRODUCT_NAME_CHILD);
//        int productCounter= listProductName.count();
//        Log.info("TOTAL PRODUCT COUNTED= "+ productCounter);
//        if (productCounter>= 24) {
//            searchingModel.setListOfProductName(listProductName.allTextContents());
//            List<String> listOfProductName= searchingModel.getListOfProductName();
////            Log.info("LIST PRODUCT NAME= "+ listOfProductName);
//        }
//        else {
//            Log.info("WRONG DETECTION >>   ");
//            page.context().browser().close();
//        }
//        return searchingModel;
//    }

//    public void getProductNameHavingMultiplePagings() throws Exception {
//        Searching searchingModel= new Searching();
//        commonHandler.waitForPageToLoad(NETWORK_IDLE_STATE, 0);
//        int viewMoreCounter= 0;
//        while (!commonHandler.verifyIfStringIsEqualized("0", "1")) {
//            if (commonHandler.verifyIfElementIsPresented(CTA_VIEW_MORE)) {
//                Log.info("VIEW MORE CTA IS VISIBLE >>  ");
//                commonHandler.scrollToElement(CTA_VIEW_MORE);
//                commonHandler.procrastinate(TIMEOUT2000MS);
//                commonHandler.waitForPageToLoad(LOAD_STATE, 0);
//            }
//            else {
//                Log.warn("VIEW MORE CTA IS NOT VISIBLE ANYMORE >>   ");
//                Log.info("THERE WILL BE NO MORE PRODUCTS >>   ");
//                break;
//            }
//            viewMoreCounter+=1;
//            Log.info("NUMBER OF CLICKING ON VIEW MORE= "+ viewMoreCounter);
//        }
//        commonHandler.waitForPageToLoad(LOAD_STATE, 0);
//        Locator listProductName= page.locator(LBL_PRODUCT_NAME_CHILD);
//        int productNameCounter= listProductName.count();
//        Log.info("TOTAL PRODUCT COUNTED= "+ productNameCounter);
//        if (productNameCounter>= 24) {
//            searchingModel.setListOfProductName(listProductName.allTextContents());
//            List<String> listOfProductName= searchingModel.getListOfProductName();
//            Log.info("LIST PRODUCT NAME= "+ listOfProductName);
//        }
//        else {
//            Log.error("WRONG DETECTION!   ");
//            page.context().browser().close();
//        }
////        return searchingModel;
//    }

    public Searching getProductName() throws Exception {
        Searching searchingModel= new Searching();
        int loadMoreCounter= 0;
        commonHandler.waitForPageToLoad(NETWORK_IDLE_STATE, 0);
        while (!commonHandler.verifyIfStringIsEqualized("0", "1")) {
            if (commonHandler.verifyIfElementIsPresented(CTA_VIEW_MORE)) {
                Log.info("VIEW MORE CTA IS VISIBLE >>    ");
                commonHandler.scrollToElement(CTA_VIEW_MORE);
                commonHandler.clickOnElement(CTA_VIEW_MORE);

                commonHandler.waitForPageToLoad(DOM_CONTENT_LOADED_STATE, 0);
                commonHandler.waitForLoadingIndicatorToBeVisible();
            }
            else {
                Log.warn("VIEW MORE CTA IS NOT FOUND >>    ");
                Log.info("THERE WILL BE NO MORE PRODUCTS >>     ");
                break;
            }
            loadMoreCounter++;
            Log.info("NUMBER OF CLICKING ON VIEW MORE CTA= "+ loadMoreCounter);
        }
        Locator listProductName= page.locator(LBL_PRODUCT_NAME_CHILD);
        int productNameCounter= listProductName.count();
        Log.info("TOTAL PRODUCT COUNTED= "+ productNameCounter);
//        if (productNameCounter>= 24) {
        searchingModel.setListOfProductName(listProductName.allTextContents());
        List<String> listOfProductName= searchingModel.getListOfProductName();
        Log.info("LIST PRODUCT NAME= "+ listOfProductName);
//        }
//        else {
//            Log.error("WRONG DETECTION!   ");
//            page.context().browser().close();
//        }
        return searchingModel;
    }


}
