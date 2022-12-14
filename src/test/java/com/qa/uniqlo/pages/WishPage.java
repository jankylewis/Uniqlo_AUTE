package com.qa.uniqlo.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.qa.uniqlo.generalKeys.CommonHandling;
import static com.qa.uniqlo.generalKeys.Constants.*;
import com.qa.uniqlo.utilities.logs.Log;

public class WishPage {

    private String CTA_UNWISH= "(//div[contains(@class, \"fr-product-image\")]//button/span)";
    private String LBL_WISHED_PRODUCT_NAME= "(//div[@class= \"fr-list\"]//div[contains(@class, \"fr-product-card\")])[1]//span[contains(@class, \"title\")]";

    private Page page;
    private CommonHandling commonHandler= new CommonHandling();

    public WishPage(Page page) {
        this.page= page;
    }

    public void retractWishedProduct() throws Exception {
        Locator listWishedProduct= page.locator(CTA_UNWISH);
        commonHandler.waitForPageToLoad(LOAD_STATE, TIMEOUT1000MS);
        int wishedProductCounter= listWishedProduct.count();
        Log.info("WISHED PRODUCT COUNTER = "+ wishedProductCounter);
        for (int i=1; i<= wishedProductCounter; i++) {
            commonHandler.waitForPageToLoad(LOAD_STATE, TIMEOUT2000MS);
            commonHandler.clickOnElement((CTA_UNWISH+ "["+ i+ "]").toString());
        }
    }

}
