package com.qa.uniqlo.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.qa.uniqlo.generalKeywords.CommonHandling;
import com.qa.uniqlo.models.data.ProductInformation;
import com.qa.uniqlo.utilities.logs.Log;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import static com.qa.uniqlo.generalKeywords.Constants.*;

import java.util.ArrayList;
import java.util.List;

public class SearchingPage {

    private Page page;

    private CommonHandling commonHandler = new CommonHandling();
    private String LBL_SEARCH_RESULT = "//div[contains(@class, \"search-results-page\")]//h1/span";
    private String LBL_PRODUCT_NAME_CHILD = "(//div[@id and contains(@class, \"fr-product-card default\")]//h2)";
    private String LBL_PRODUCT_NAME_PARENT = "//div[contains(@class, \"fr-product-grid row\")][//div[@id and contains(@class, \"fr-product-card default\")]]";
    private String LBL_NO_RESULT = "//div[@class= \"fr-text\"][ancestor::div[@data-test]]";
    private String LBL_PRODUCT_PRICE_CHILD;
    private String LBL_PRODUCT_PRICE_PARENT;
    private String CTA_VIEW_MORE = "//div[@data-test= \"searchPageRoot\"]//span[contains(text(), \"View more\")]";
    private String LBL_NUMBER_OF_PRODUCT = "//div[contains(@class, \"results-count\")]/div";
    private String LOADING_INDICATOR = "//div[@data-test= \"loadingIndicator\"][span]";
    private String CTA_WISH = "(//div[@id and contains(@class, \"fr-product-card default\")]//button/span)";
    private final String noResultMessage = "There are no results that match your search.";


    public SearchingPage(Page page) {
        this.page = page;
    }

    // this method is to get product name that is gonna be wished
    // listProductNameText is to get all product name being present on the Search Page
    // listWishedProductName is to get the wished product name from listProductNameText
    public ProductInformation getWishedProductName(int quantityOfWishedProduct) throws Exception {
        ProductInformation wishedProductModel = new ProductInformation();
        commonHandler.waitForPageToLoad(LOAD_STATE, TIMEOUT1000MS);
        Locator listProductName = page.locator(LBL_PRODUCT_NAME_CHILD);
        List<String> listProductNameText;
        List<String> listWishedProductName = new ArrayList<String>();
        commonHandler.waitForPageToLoad(DOM_CONTENT_LOADED_STATE, TIMEOUT1000MS);
        listProductNameText = listProductName.allTextContents();
        if (quantityOfWishedProduct > 0 != false) {
            for (int i = 0; i < quantityOfWishedProduct; i++) {
                listWishedProductName.add(listProductNameText.get(i));
            }
        }
        System.out.println("\r");
        Log.info("LIST OF WISHED PRODUCT NAME= " + listWishedProductName);
        System.out.println("\r");
        for (String wishedProductName : listWishedProductName) {
            Log.info("WISHED PRODUCT NAME= " + wishedProductName);
        }
        wishedProductModel.setListOfProductName(listWishedProductName);
        return wishedProductModel;
    }

    /* This method is to wish product by clicking on Heart icon on Searching Page */
    public void wishProduct(int quantityOfWishedProduct) throws Exception {
        if (quantityOfWishedProduct > 0 != false) {
            if (quantityOfWishedProduct == 1) {
                Log.info("WISH 1 PRODUCT >>    ");
            } else {
                Log.info("WISH " + quantityOfWishedProduct + " PRODUCTS >>    ");
            }
            if (quantityOfWishedProduct <= 24) {
                for (int i = 1; i <= quantityOfWishedProduct; i++) {
                    commonHandler.waitForPageToLoad(LOAD_STATE, MINTIMEOUT);
                    commonHandler.clickOnElement((CTA_WISH + "[" + i + "]"));
                    commonHandler.waitForPageToLoad(LOAD_STATE, MINTIMEOUT);
                }
            } else {
                expandAllProductOnPage();
                for (int i = 1; i <= quantityOfWishedProduct; i++) {
                    commonHandler.waitForPageToLoad(LOAD_STATE, MINTIMEOUT);
                    commonHandler.clickOnElement((CTA_WISH + "[" + i + "]"));
                    commonHandler.waitForPageToLoad(LOAD_STATE, MINTIMEOUT);
                }
            }
        }
    }

    public void verifyTestCasePassed(final String searchKey) throws Exception {
        verifySearchResultLabel(searchKey);
        ProductInformation searchingModel = getProductName();
        verifyProductName(searchingModel, searchKey);
    }

    public void verifyTestCaseFailed() {
        verifyNoResultIsPresent();
    }

    public void verifySearchResultLabel(final String searchKey) {
        String searchResultTxt = page.locator(LBL_SEARCH_RESULT).textContent();
        Log.info("SEARCH RESULT CONTENT= " + searchResultTxt);
        if (commonHandler.verifyIfStringIsEqualized(searchResultTxt, searchKey)) {
            Log.info("SEARCH RESULT LABEL CONTAINED " + searchKey);
        }
    }

    public void verifyNoResultIsPresent() {
        String noResultTxt = page.locator(LBL_NO_RESULT).textContent();
        Log.info("NO RESULT TEXT CONTENT= " + noResultTxt);
        if (commonHandler.verifyIfStringIsEqualized(noResultMessage, noResultTxt)) {
            Log.info("NO RESULT TEXT IS PRESENTED >>  ");
        }
    }

    public void verifyProductName(@NotNull ProductInformation searchingModel, final String searchKey) {
        List<String> listProductName = searchingModel.getListOfProductName();
        System.out.println("\r");
        Log.info("LIST OF PRODUCT NAME= " + listProductName);
        System.out.println("\r");
        for (String productName : listProductName) {
            if (commonHandler.verifyIfStringIsContained(productName, searchKey)) {
                Log.info("SUCCESSFUL VERIFIED: PRODUCT NAME CONTAINED THE KEY: " + searchKey);
            }
        }
    }

    // this method is to click on VIEW MORE CTA multiple times to expand all the product being present on Searching Page
    public void expandAllProductOnPage() throws Exception {
        int loadMoreCounter = 0;
        commonHandler.waitForPageToLoad(NETWORK_IDLE_STATE, 0);
        while (!commonHandler.verifyIfStringIsEqualized("0", "1")) {
            if (commonHandler.verifyIfElementIsPresented(CTA_VIEW_MORE)) {
                Log.info("VIEW MORE CTA IS VISIBLE >>    ");
                commonHandler.scrollToElement(CTA_VIEW_MORE);
                commonHandler.clickOnElement(CTA_VIEW_MORE);
                loadMoreCounter++;
                Log.info("NUMBER OF CLICKING ON VIEW MORE CTA= " + loadMoreCounter);
                commonHandler.waitForPageToLoad(LOAD_STATE, TIMEOUT5000MS);
            } else {
                Log.warn("VIEW MORE CTA IS NOT FOUND >>    ");
                break;
            }
        }
    }

    public ProductInformation getProductName() throws Exception {
        ProductInformation searchingModel = new ProductInformation();
        expandAllProductOnPage();
        Locator listProductName = page.locator(LBL_PRODUCT_NAME_CHILD);
        int productNameCounter = listProductName.count();
        Log.info("TOTAL PRODUCT COUNTED= " + productNameCounter);
        searchingModel.setListOfProductName(listProductName.allTextContents());
        return searchingModel;
    }

    @Contract(pure = true)
    private @NotNull String generateProductImgSelector(String productName) {
        String IMG_PRODUCT = "//div[contains(@class, \"product-card\")]/div[contains(@class, \"info\")]//h2[contains(text(), '" + productName + "')]";
        return IMG_PRODUCT;
    }

    // the more precise the product name is provided, the more accurate the selector
    public void clickOnProductImg(String productName) {
        commonHandler.clickOnElement(generateProductImgSelector(productName));
    }
}
