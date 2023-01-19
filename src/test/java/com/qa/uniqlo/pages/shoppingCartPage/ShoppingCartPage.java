package com.qa.uniqlo.pages.shoppingCartPage;

import com.microsoft.playwright.Page;
import com.qa.uniqlo.generalKeywords.CommonHandling;

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
    private String CTA_RETRACT_PRODUCT= "(//button[contains(@class, \"product-close-button\")])";

    public void verifyProductDataDisplayedOnPage(String expProductName, String expProductColor, String expProductSize, String expProductPrice, String expProductQuantity) {

    }

    private void verifyProductName(String expProductName) {

    }

    private void verifyProducColor(String expProductColor) {

    }

    private void verifyProductSize(String expProductSize) {

    }

    private void verifyProductPrice(String expProductPrice) {

    }

    private void verifyProductQuantity(String expProductQuantity) {

    }

    private void verifyProductSubtotal(String expProductQuantity, Float expProductPrice) {

    }



    private String getProductName() {
        String productName= page.locator(LBL_PRODUCT_NAME).textContent();
        return productName;
    }

    private String getProductColor() {
        String productColor= page.locator(LBL_PRODUCT_COLOR).textContent();
        return productColor;
    }

    private String getProductSize() {
        String productSize= page.locator(LBL_PRODUCT_SIZE).textContent();
        return productSize;
    }

    private Float getProductPrice() {
        String actProductPrice= page.locator(LBL_PRODUCT_PRICE).textContent();
        String productPrice= commonHandler.removeVndAbbreviation(actProductPrice);
        return Float.parseFloat(productPrice);
    }

    private String getProductQuantity() {
        String productQuantity= page.locator(LBL_PRODUCT_QUANTITY).textContent();
        return productQuantity;
    }

    private Float getProductSubtotal() {
        String actProductSubtotal= page.locator(LBL_PRODUCT_SUBTOTAL).textContent();
        String productSubtotal= commonHandler.removeVndAbbreviation(actProductSubtotal);
        return Float.parseFloat(productSubtotal);
    }

    private Float getSummarySubtotal() {
        String actSummarySubtotal= page.locator(LBL_SUMMARY_SUBTOTAL).textContent();
        String summarySubtotal= commonHandler.removeVndAbbreviation(actSummarySubtotal);
        return Float.parseFloat(summarySubtotal);
    }

    private Float getSummaryVAT() {
        String actSummaryVAT= page.locator(LBL_SUMMARY_VAT).textContent();
        String summaryVAT= commonHandler.removeVndAbbreviation(actSummaryVAT);
        return Float.parseFloat(summaryVAT);
    }

    private Float getSummaryTotal() {
        String actSummaryTotal= page.locator(LBL_SUMMARY_TOTAL).textContent();
        String summaryTotal= commonHandler.removeVndAbbreviation(actSummaryTotal);
        return Float.parseFloat(summaryTotal);
    }





}
