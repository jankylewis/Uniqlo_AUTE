package com.qa.uniqlo.pages.shoppingCartPage;

import com.microsoft.playwright.Page;
import com.qa.uniqlo.generalKeys.CommonHandling;

public class ShoppingCartPage {

    //this page is to define actions and steps, verifications
    private CommonHandling commonHandler= new CommonHandling();
    private Page page;

    public ShoppingCartPage(Page page) {
        this.page= page;
    }

    private String LBL_PRODUCT_NAME= "//div[contains(@class, \"content-wrapper\")]//p";
    private String LBL_PRODUCT_COLOR= "(//dd[contains(@class, \"fr-definition-list-description\")][preceding-sibling::dt[(text()= \"Color\")]]";
    private String LBL_PRODUCT_SIZE= "(//dd[contains(@class, \"fr-definition-list-description\")][preceding-sibling::dt[(text()= \"Size\")]])";
    private String LBL_PRODUCT_PRICE= "//div[contains(@class, \"cartList\")]//div[contains(@class, \"product-price\")]//span[contains(@class, \"price\")]";
    private String LBL_PRODUCT_QUANTITY;
    private String LBL_PRODUCT_SUBTOTAL= "(//dd[contains(@class, \"fr-definition-list-description\")][preceding-sibling::dt[(text()= \"Subtotal\")]])";
    private String LBL_SUMMARY_QUANTITY_OF_ITEM;
    private String LBL_SUMMARY_SUBTOTAL;
    private String LBL_SUMMARY_VAT;
    private String LBL_SUMMARY_TOTAL;
    private String CTA_CHECKOUT;
    private String CTA_CONTINUE_SHOPPING;
    private String CTA_COUPON;
    private String CTA_GIFT_OPTION;

}
