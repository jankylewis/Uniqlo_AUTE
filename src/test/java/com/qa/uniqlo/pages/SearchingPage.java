package com.qa.uniqlo.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.qa.uniqlo.generalKeys.CommonHandling;
import com.qa.uniqlo.models.data.ProductInformation;
import com.qa.uniqlo.utilities.logs.Log;

import static com.qa.uniqlo.generalKeys.Constants.*;

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
        ProductInformation searchingModel= getProductName();
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

    public void verifyProductName(ProductInformation searchingModel, final String searchKey) {
        List<String> listProductName= searchingModel.getListOfProductName();
        System.out.println("\r");
        Log.info("LIST PRODUCT NAME= "+ listProductName);
        System.out.println("\r");
        for (String productName: listProductName) {
            if (commonHandler.verifyIfStringIsContained(productName, searchKey)) {
                Log.info("SUCCESSFUL VERIFIED: PRODUCT NAME CONTAINED THE KEY: "+ searchKey);
            }
        }
    }

    public ProductInformation getProductName() throws Exception {
        ProductInformation searchingModel= new ProductInformation();
        int loadMoreCounter= 0;
        commonHandler.waitForPageToLoad(NETWORK_IDLE_STATE, 0);
        while (!commonHandler.verifyIfStringIsEqualized("0", "1")) {
            if (commonHandler.verifyIfElementIsPresented(CTA_VIEW_MORE)) {
                Log.info("VIEW MORE CTA IS VISIBLE >>    ");
                commonHandler.scrollToElement(CTA_VIEW_MORE);
                commonHandler.clickOnElement(CTA_VIEW_MORE);
                loadMoreCounter++;
                Log.info("NUMBER OF CLICKING ON VIEW MORE CTA= "+ loadMoreCounter);
                commonHandler.waitForPageToLoad(LOAD_STATE, TIMEOUT5000M);
            }
            else {
                Log.warn("VIEW MORE CTA IS NOT FOUND >>    ");
                break;
            }
        }
        Locator listProductName= page.locator(LBL_PRODUCT_NAME_CHILD);
        int productNameCounter= listProductName.count();
        Log.info("TOTAL PRODUCT COUNTED= "+ productNameCounter);
        searchingModel.setListOfProductName(listProductName.allTextContents());
        return searchingModel;
    }
}
