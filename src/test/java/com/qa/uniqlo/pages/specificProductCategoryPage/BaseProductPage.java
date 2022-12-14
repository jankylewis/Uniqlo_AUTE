package com.qa.uniqlo.pages.specificProductCategoryPage;

import com.beust.ah.A;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.qa.uniqlo.base.AbstractTest;
import com.qa.uniqlo.generalKeys.CommonHandling;
import com.qa.uniqlo.models.data.ProductInformation;
import com.qa.uniqlo.utilities.logs.Log;
import org.testng.Assert;

import java.util.List;

import static com.qa.uniqlo.generalKeys.Constants.*;
import static com.qa.uniqlo.generalKeys.Constants.TIMEOUT5000MS;

public class BaseProductPage {
    public void verifyProductPrice(ProductInformation productModel, final String sortingCriterion) {
        List<String> listProductPrice= productModel.getListOfProductPrice();
        System.out.println("\r");
        Log.info("LIST PRODUCT PRICE= "+ listProductPrice);
        System.out.println("\r");
        if (commonHandler.verifyIfStringIsEqualized(sortingCriterion, ascending)) {
            for (int i= 0; i< listProductPrice.size()-1; i++) {
                Log.info("PRODUCT PRICE= "+ listProductPrice.get(i));
                if (Float.parseFloat(listProductPrice.get(i))<= Float.parseFloat(listProductPrice.get(i+1))) {
                    Log.info("SUCCESSFULLY VERIFIED {"+ listProductPrice.get(i)+ "}"+ " <= {"+ listProductPrice.get(i+1)+ "}");
                }
                else {
                    Assert.fail("UNSUCCESSFULLY VERIFIED {"+ listProductPrice.get(i)+ "}"+ " <= {"+ listProductPrice.get(i+1)+ "}");
                    break;
                }
            }
        }
        if (commonHandler.verifyIfStringIsEqualized(sortingCriterion, descending)) {
            for (int i= 0; i< listProductPrice.size()-1; i++) {
                Log.info("PRODUCT PRICE= "+ listProductPrice.get(i));
                if (listProductPrice.get(i).length()> 8) {
                    Log.info("MILLION STARTED >>    ");
                    String pricePlacedBefore= listProductPrice.get(i).replace(".", "");
                    String pricePlacedAfter= listProductPrice.get(i+1).replace(".", "");
                    if (Float.parseFloat(pricePlacedBefore)>= Float.parseFloat(pricePlacedAfter)) {
                        Log.info("SUCCESSFULLY VERIFIED {"+ pricePlacedBefore+ "}"+ " >= {"+ pricePlacedAfter+ "}");
                    }
                    else {
                        Assert.fail("UNSUCCESSFULLY VERIFIED {"+ pricePlacedBefore+ "}"+ " >= {"+ pricePlacedAfter+ "}");
                        break;
                    }
                }
                else {
                    if (Float.parseFloat(listProductPrice.get(i))>= Float.parseFloat(listProductPrice.get(i+1))) {
                        Log.info("SUCCESSFULLY VERIFIED {"+ listProductPrice.get(i)+ "}"+ " >= {"+ listProductPrice.get(i+1)+ "}");
                    }
                    else {
                        Assert.fail("UNSUCCESSFULLY VERIFIED {"+ listProductPrice.get(i)+ "}"+ " >= {"+ listProductPrice.get(i+1)+ "}");
                        break;
                    }
                }
            }
        }
        if (commonHandler.verifyIfStringIsEqualized(sortingCriterion, topRated)) {}
        if (commonHandler.verifyIfStringIsEqualized(sortingCriterion, newArrivals)) {}
    }
    public ProductInformation getProductPrice() throws Exception {
        ProductInformation productModel= new ProductInformation();
        commonHandler.waitForPageToLoad(NETWORK_IDLE_STATE, TIMEOUT3000MS);
        Locator listProductPrice= page.locator(LBL_PRODUCT_PRICE);
        int productPriceCounter= listProductPrice.count();
        Log.info("TOTAL PRODUCT PRICE THAT NEEDS TO BE VERIFIED= "+ productPriceCounter);
        productModel.setListOfProductPrice(listProductPrice.allTextContents());
        return productModel;
    }
    public int getTotalNumberOfProduct() throws Exception {
        ProductInformation productModel= new ProductInformation();
        commonHandler.waitForPageToLoad(NETWORK_IDLE_STATE, TIMEOUT3000MS);
        while (!commonHandler.verifyIfStringIsEqualized("0", "1")) {
            if (commonHandler.verifyIfElementIsPresented(CTA_LOAD_MORE)) {
                Log.info("LOAD MORE CTA IS VISIBLE >>    ");
                commonHandler.scrollToElement(CTA_LOAD_MORE);
                commonHandler.clickOnElement(CTA_LOAD_MORE);
                commonHandler.waitForPageToLoad(LOAD_STATE, TIMEOUT5000MS);
            }
            else {
                Log.warn("LOAD MORE CTA IS NOT FOUND >>    ");
                break;
            }
        }
        Locator listProductName= page.locator(LBL_PRODUCT_NAME);
        int productNameCounter= listProductName.count();
        Log.info("TOTAL PRODUCT FOUNDED= "+ productNameCounter);
        return productNameCounter;
    }
    public void doSorting(String sortingCriterion) throws Exception {
        commonHandler.waitForPageToLoad(LOAD_STATE, TIMEOUT3000MS);
        commonHandler.clickOnElement(DDL_SORTED_BY);
        if (commonHandler.verifyIfStringIsEqualized(sortingCriterion, ascending)) {
            commonHandler.clickOnElement(DDI_SORTED_BY_LOW_TO_HIGH);
        }
        if (commonHandler.verifyIfStringIsEqualized(sortingCriterion, descending)) {
            commonHandler.clickOnElement(DDI_SORTED_BY_HIGH_TO_LOW);
        }
        if (commonHandler.verifyIfStringIsEqualized(sortingCriterion, topRated)) {
            commonHandler.clickOnElement(DDI_SORTED_BY_TOP_RATED);
        }
        if (commonHandler.verifyIfStringIsEqualized(sortingCriterion, newArrivals)) {
            commonHandler.clickOnElement(DDI_SORTED_BY_NEW_ARRIVALS);
        }
    }
    protected void verifyHeading(String expSelector, final String expTxt) {
        String headingGetTxt= page.locator(expSelector).textContent();
        commonHandler.verifyIfStringIsEqual(expTxt, headingGetTxt);
    }

    protected void verifyBreadCrumbGenderSectorLabel(String expSelector, final String expTxt) {
        String menGetTxt= page.locator(expSelector).textContent();
        commonHandler.verifyIfStringIsEqual(expTxt, menGetTxt);
    }

    protected void verifyBreadCrumbSectorCategorizedLabel(String expSelector, final String expTxt) {
        String teeShirtsGetTxt= page.locator(expSelector).textContent();
        commonHandler.verifyIfStringIsEqual(expTxt, teeShirtsGetTxt);
    }

    public BaseProductPage(Page page) {
        this.page= page;
    }
    protected CommonHandling commonHandler= new CommonHandling();
    protected Page page;
    protected String LBL_PRODUCT_LIMITED_PRICE= "//div[contains(@class, \"fr-product-price\")]//span[contains(@class, \"price-limited\")]";
    protected String LBL_PRODUCT_ORIGINAL_PRICE= "//div[contains(@class, \"fr-product-price\")]//span[contains(@class, \"price-original\")]";
    protected String LBL_PRODUCT_PRICE= "(//div[contains(@class, \"fr-product-price\")]//span[contains(@class, \"price-limited\")] | //div[contains(@class, \"fr-product-price\")]//span[contains(@class, \"price-original\")])//span[parent::span[contains(@class, \"fr-price-currency\")]]";
    protected String LBL_PRODUCT_NAME= "//div[@id and contains(@class, \"fr-product-card default\")]//h2";

    protected String CTA_LOAD_MORE= "//div[@data-test= \"globalNavRoot\"]//following::span[contains(text(), \"Load more\")]";
    protected String DDL_SORTED_BY= "//div[@type= \"button\" and @role][span[contains(text(), \"Featured\")]]";
    protected String DDI_SORTED_BY_NEW_ARRIVALS= "//ul[@role= \"listbox\"]//li[contains(text(), \"New arrivals\")]";
    protected String DDI_SORTED_BY_LOW_TO_HIGH= "//ul[@role= \"listbox\"]//li[contains(text(), \"Low to high\")]";
    protected String DDI_SORTED_BY_HIGH_TO_LOW= "//ul[@role= \"listbox\"]//li[contains(text(), \"High to low\")]";
    protected String DDI_SORTED_BY_TOP_RATED= "//ul[@role= \"listbox\"]//li[contains(text(), \"Top rated\")]";

    protected final String ascending= "low to high";
    protected final String descending= "high to low";
    protected final String topRated= "top rated";
    protected final String newArrivals= "new arrivals";


}
