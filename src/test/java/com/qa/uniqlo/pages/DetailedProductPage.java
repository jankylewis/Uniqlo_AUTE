package com.qa.uniqlo.pages;

import com.microsoft.playwright.Page;
import com.qa.uniqlo.generalKeys.CommonHandling;
import com.qa.uniqlo.models.data.ProductInformation;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DetailedProductPage {

    //this page is to define actions and steps, verifications
    private CommonHandling commonHandling= new CommonHandling();
    private Page page;
    private String CTA_ADD_TO_CART= "//button[contains(text(), \"Add to cart\")]";
    private String CTA_ADD_TO_WISH_LIST;
    private String CTA_FIND_STOCK_IN_STORE;
    private String LBL_PRODUCT_PRICE= "(//div[contains(@class, \"product-price\")]//span[contains(@class, \"price-limited\")]//span/span)[1]";
    private String LBL_PRODUCT_NAME= "//div[contains(@data-test, \"product-name\")]//span";

    private String generateQuantitySelector(String desiredQuantity) {
        String DDI_QUANTITY= "//ul[contains(@data-test, \"quantity\")]/li[contains(text(), '"+ desiredQuantity + "')]";
        return DDI_QUANTITY;
    }

    @Contract(pure = true)
    private @NotNull String generateSizeSelector(String desiredSize) {
        String CTA_SIZE= "//div[contains(@class, \"size-picker-wrapper\")]//dt/label[span[contains(text(), '"+ desiredSize+ "')]]";
        return CTA_SIZE;
    }

    private @NotNull String generateColorSelector(String desiredColor) {
        String CTA_COLOR= "//div[contains(@class, \"color-picker-wrapper\")]//dt/label[span[contains(text(), '"+ desiredColor+ "')]]";
        return CTA_COLOR;
    }

    public DetailedProductPage(com.microsoft.playwright.Page page) {
        this.page= page;
    }

    public ProductInformation processAddingToCart(String desiredColor, String desiredSize, String desiredQuantity) {
        pickDesiredColor(desiredColor);
        pickDesiredSize(desiredSize);
        pickDesiredQuantity(desiredQuantity);
        clickOnAddToCartCTA();
        String productName= getProductName();
        Float productPrice= getProductPrice();
        ProductInformation newProductModel= generateNewProductModel(productName, productPrice, desiredSize, desiredColor, desiredQuantity);
        return newProductModel;
    }

    public ProductInformation generateNewProductModel(String productName, Float productPrice, String productSize, String productColor, String productQuantity) {
        ProductInformation productModel= new ProductInformation();
        productModel.setProductName(productName);
        productModel.setProductPrice(productPrice);
        productModel.setProductSize(productSize);
        productModel.setProductColor(productColor);
        productModel.setProductQuantity(productQuantity);
        return productModel;
    }

    @Contract(pure = true)
    private @Nullable String getProductName() {
        String productName= page.locator(LBL_PRODUCT_NAME).textContent();
        return productName;
    }

    @Contract(pure = true)
    private @Nullable Float getProductPrice() {
        String productPrice = page.locator(LBL_PRODUCT_PRICE).textContent();
        return Float.parseFloat(productPrice);
    }

    private void clickOnAddToCartCTA() {
        commonHandling.clickOnElement(CTA_ADD_TO_CART);
    }

    private void pickDesiredColor(String desiredColor) {
        commonHandling.clickOnElement(generateColorSelector(desiredColor));
    }

    private void pickDesiredSize(String desiredSize) {
        commonHandling.clickOnElement(generateSizeSelector(desiredSize));
    }

    private void pickDesiredQuantity(String desiredQuantity) {
        commonHandling.clickOnElement(generateSizeSelector(desiredQuantity));
    }
}
