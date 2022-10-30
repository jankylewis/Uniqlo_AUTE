package com.qa.uniqlo.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import com.qa.uniqlo.generalKeys.CommonHandling;
import com.qa.uniqlo.utilities.logs.Log;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SearchingPage {

    private Page page;
    private CommonHandling commonHandler= new CommonHandling();
    private String LBL_SEARCH_KEY= "//div[contains(@class, \"search-results-page\")]//h1/span";
    private String LBL_PRODUCT_NAME_CHILD= "//div[@id and contains(@class, \"fr-product-card default\")]//h2";
    private String LBL_PRODUCT_NAME_PARENT= "//div[contains(@class, \"fr-product-grid row\")][//div[@id and contains(@class, \"fr-product-card default\")]]";
    private String LBL_PRODUCT_PRICE_CHILD;
    private String LBL_PRODUCT_PRICE_PARENT;

    public SearchingPage(Page page) {
        this.page= page;
    }

    public void verifyProductName() throws Exception {
        getProductName();
    }

    public void getProductName() throws Exception{
        Locator listProductName= page.locator(LBL_PRODUCT_NAME_CHILD);
        commonHandler.waitForPageToLoad(LoadState.NETWORKIDLE);
        Log.info("TOTAL PRODUCT= "+ listProductName.count());
        List<String> productNameTxt= listProductName.allTextContents();
        for (String name: productNameTxt) {
            Log.info("PRODUCT NAME= "+ name);
        }

    }



}
