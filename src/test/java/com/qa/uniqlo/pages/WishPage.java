package com.qa.uniqlo.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.qa.uniqlo.generalKeys.CommonHandling;
import static com.qa.uniqlo.generalKeys.Constants.*;

import com.qa.uniqlo.models.data.ProductInformation;
import com.qa.uniqlo.utilities.logs.Log;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.*;
import java.io.*;

public class WishPage {

    private String CTA_UNWISH= "(//div[contains(@class, \"fr-product-image\")]//button/span)";
    private String LBL_WISHED_PRODUCT_NAME= "((//div[@class= \"fr-list\"]//div[contains(@class, \"fr-product-card\")])//span[contains(@class, \"title\")])";

    private Page page;
    private CommonHandling commonHandler= new CommonHandling();

    public WishPage(Page page) {
        this.page= page;
    }

    /* this method is to verify the wished product name whether it resembled the product
    name that was wished on the Searching Page */
    // expWishedProductModel = model on the Searching Page
    // actWishedProductModel = model on the Wish Page
    public boolean verifyWishedProductName(@NotNull ProductInformation expWishedProductModel) throws Exception {
        ProductInformation actWishedProductModel= getWishedProductName();
        List<String> expListWishedProductName= expWishedProductModel.getListOfProductName();
        List<String> actListWishedProductName= actWishedProductModel.getListOfProductName();
        Log.info("EXPECTED LIST OF WISHED PRODUCT NAME = "+ expListWishedProductName);
        System.out.println("\r");
        // for loop is to reverse the list
        for (int i=0, k= actListWishedProductName.size() -1; i< k; i++) {
            actListWishedProductName.add(i, actListWishedProductName.remove(k));
        }
        Log.info("ACTUAL LIST OF WISHED PRODUCT NAME = "+ actListWishedProductName);
        System.out.println("\r");
        return commonHandler.verifyIfListIsEqual(expListWishedProductName, actListWishedProductName);
    }

    // this method is to get the wished product name being displayed on Wish Page
    public ProductInformation getWishedProductName() throws Exception {
        ProductInformation wishedProductModel= new ProductInformation();
        commonHandler.waitForPageToLoad(LOAD_STATE, TIMEOUT3000MS);
        Locator listWishedProductNameText= page.locator(LBL_WISHED_PRODUCT_NAME);
        List<String> listWishedProductName;
        commonHandler.waitForPageToLoad(DOM_CONTENT_LOADED_STATE, TIMEOUT1000MS);
        listWishedProductName= listWishedProductNameText.allTextContents();
        System.out.println("\r");
        Log.info("LIST OF WISHED PRODUCT NAME= "+ listWishedProductName);
        System.out.println("\r");
        for (String wishedProductName: listWishedProductName) {
            Log.info("WISHED PRODUCT NAME= "+ wishedProductName);
        }
        wishedProductModel.setListOfProductName(listWishedProductName);
        return wishedProductModel;
    }

    public void retractWishedProduct() throws Exception {
        Locator listWishedProduct= page.locator(CTA_UNWISH);
        commonHandler.waitForPageToLoad(LOAD_STATE, TIMEOUT3000MS);
        int wishedProductCounter= listWishedProduct.count();
        Log.info("WISHED PRODUCT COUNTER = "+ wishedProductCounter);
        for (int i=1; i<= wishedProductCounter; i++) {
            commonHandler.waitForPageToLoad(LOAD_STATE, MINTIMEOUT);
            commonHandler.clickOnElement((CTA_UNWISH+ "["+ i+ "]"));
        }
    }

}
