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
    private String LBL_PRODUCT_COLOR= "(//dd[contains(@class, \"fr-definition-list-description\")][preceding-sibling::dt[(text()= \"Color\")]])";
    private String LBL_PRODUCT_SIZE= "(//dd[contains(@class, \"fr-definition-list-description\")][preceding-sibling::dt[(text()= \"Size\")]])";
    private String LBL_PRODUCT_PRICE= "//div[contains(@class, \"cartList\")]//div[contains(@class, \"product-price\")]//span[contains(@class, \"price\")]";
    private String LBL_PRODUCT_QUANTITY= "//div[contains(@data-test, \"quantity\")]/span[1]";
    private String LBL_PRODUCT_SUBTOTAL= "(//dd[contains(@class, \"fr-definition-list-description\")][preceding-sibling::dt[(text()= \"Subtotal\")]])";
    private String LBL_SUMMARY_QUANTITY_OF_ITEM;
    private String LBL_SUMMARY_SUBTOTAL= "//div[contains(@data-test, \"order-summary\")]//span[parent::span[contains(@class, \"fr-price\")][parent::td[contains(@data-test, \"item-s-subtotal\")]]]";
    private String LBL_SUMMARY_VAT= "//div[contains(@data-test, \"order-summary\")]//span[parent::span[contains(@class, \"fr-price\")][parent::td[contains(@data-test, \"vat\")]]]";
    private String LBL_SUMMARY_TOTAL= "//div[contains(@data-test, \"order-summary\")]//span[parent::span[contains(@class, \"fr-price\")][parent::th[contains(@data-test, \"order-total\")]]]";
    private String CTA_CHECKOUT;
    private String CTA_CONTINUE_SHOPPING;
    private String CTA_COUPON;
    private String CTA_GIFT_OPTION;

    private String getProductName() {

        return null;
    }

    private String getProductColor() {

        return null;
    }

    private String getProductSize() {

        return null;
    }

    private String getProductPrice() {

        return null;
    }

    private String getProductQuantity() {

        return null;
    }

    private String getProductSubtotal() {

        return null;
    }

    private String getSummarySubtotal() {

        return null;
    }

    private String getSummaryVAT() {

        return null;
    }

    private String getSummaryTotal() {

        return null;
    }



}
