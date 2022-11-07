package com.qa.uniqlo.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import com.qa.uniqlo.generalKeys.CommonHandling;
import com.qa.uniqlo.models.data.Searching;
import com.qa.uniqlo.utilities.logs.Log;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;
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
    private final String noResultMessage= "There are no results that match your search.";
    public SearchingPage(Page page) {
        this.page= page;
    }

    public void verifyTestCasePassedWithoutPaging(final String searchKey) throws Exception {
        verifySearchResultLabel(searchKey);
        verifyProductName(searchKey);
    }

    public void verifyTestCaseFailed() {
        verifyNoResultIsPresent();
    }

    public void verifyTestCasePassedWithPaging(final String searchKey) throws Exception {
        verifyProductNameHavingPaging(searchKey);
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

    public void verifyProductName(final String searchKey) throws Exception {
        Searching searchingModel= new Searching();
        Locator listProductName= page.locator(LBL_PRODUCT_NAME_CHILD);
        commonHandler.waitForPageToLoad(NETWORK_IDLE_STATE);
        Log.info("TOTAL PRODUCT= "+ listProductName.count());
        searchingModel.setListOfProductName(listProductName.allTextContents());
        List<String> listOfProductName= searchingModel.getListOfProductName();
        Log.info("LIST PRODUCT NAME= "+ listOfProductName);
        for (String name: listOfProductName) {
            Log.info("PRODUCT NAME= "+ name);
            if (commonHandler.verifyIfStringIsContained(name, searchKey)) {
                Log.info("PRODUCT NAME CONTAINED "+ searchKey);
            }
        }
    }

    public void verifyProductNameHavingPaging(final String searchKey) throws Exception {
        Searching searchingModel= new Searching();
        commonHandler.waitForPageToLoad(NETWORK_IDLE_STATE);
        int loadingCounter= 0;
        while (!"0".equals("1")) {
            commonHandler.waitForPageToLoad(DOM_CONTENT_LOADED_STATE);
            if (commonHandler.verifyIfElementIsPresented(CTA_VIEW_MORE)) {
                Log.info("VIEW MORE CTA IS VISIBLE >>   ");
                Locator listProductName= page.locator(LBL_PRODUCT_NAME_CHILD);
                Log.info("TOTAL PRODUCT COUNTED= "+ listProductName.count());
                searchingModel.setListOfProductName(listProductName.allTextContents());
                List<String> listOfProductName= searchingModel.getListOfProductName();
                Log.info("LIST PRODUCT NAME= "+ listOfProductName);
                commonHandler.scrollToElement(CTA_VIEW_MORE);
                commonHandler.procrastinate(TIMEOUT2000MS);
                commonHandler.clickOnElement(CTA_VIEW_MORE);
                commonHandler.waitForPageToLoad(DOM_CONTENT_LOADED_STATE);
                commonHandler.procrastinate(TIMEOUT2000MS);
            }
            else {
                Log.error("VIEW MORE CTA IS NOT VISIBLE ANYMORE >>     ");
                break;
            }
            loadingCounter+=1;
        }
        Log.info("INT LOADING COUNTER= "+ loadingCounter);


    }



}
