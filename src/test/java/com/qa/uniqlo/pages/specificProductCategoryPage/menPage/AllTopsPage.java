package com.qa.uniqlo.pages.specificProductCategoryPage.menPage;

import com.microsoft.playwright.Page;
import com.qa.uniqlo.models.data.ProductInformation;
import com.qa.uniqlo.pages.specificProductCategoryPage.BaseProductPage;
import com.qa.uniqlo.utilities.logs.Log;

public class AllTopsPage extends BaseProductPage {

    private BaseProductPage baseProductPage= new BaseProductPage(page);
    private String LBL_PRODUCT_NAME_CHILD= "//div[@id and contains(@class, \"fr-product-card default\")]//h2";

    private String LBL_MEN= "//ol[contains(@class, \"breadcrumbs\")]//li[2]//a";
    private String LBL_MEN_CATEGORIZED= "//ol[contains(@class, \"breadcrumbs\")]//li/span";
    private String LBL_HEADING= "//h3[contains(@class, \"head\")]/span";
    private final String menTxt= "MEN";
    private final String allTopsTxt= "ALL TOPS";

    public AllTopsPage(Page page) {
        super(page);
    }

    public void verifyTestCaseSortingPassed(final String sortingCriterion) throws Exception {
        verifyTextOfLabel();
        getTotalNumberOfProduct();
        ProductInformation productModel= getProductPrice();
        verifyProductPrice(productModel, sortingCriterion);
    }

    public void verifyProductPrice(ProductInformation productModel, final String sortingCriterion) {
        baseProductPage.verifyProductPrice(productModel, sortingCriterion);
    }

    public ProductInformation getProductPrice() throws Exception {
        return baseProductPage.getProductPrice();
    }

    /* get product counter, expand all the page to count total number of product */
    public int getTotalNumberOfProduct() throws Exception {
        return baseProductPage.getTotalNumberOfProduct();
    }

    public void doSorting(String sortingCriterion) throws Exception {
        BaseProductPage baseProductPage= new BaseProductPage(page);
        baseProductPage.doSorting(sortingCriterion);
    }

    public void verifyTextOfLabel() {
        verifyBreadCrumbMenLabel();
        Log.info("BREADCRUMB CONTAINED MEN LABEL {MEN}"+ " >>   ");
        verifyBreadCrumbAllTopsLabel();
        Log.info("BREADCRUMB CONTAINED T-SHIRTS LABEL {ALL TOPS}"+ " >>   ");
        verifyHeading();
        Log.info("BREADCRUMB CONTAINED HEADING {MEN}"+ " >>   ");
    }

    private void verifyHeading() {
        verifyHeading(LBL_HEADING, menTxt);
    }

    private void verifyBreadCrumbMenLabel() {
        verifyBreadCrumbGenderSectorLabel(LBL_MEN, menTxt);
    }

    private void verifyBreadCrumbAllTopsLabel() {
        verifyBreadCrumbSectorCategorizedLabel(LBL_MEN_CATEGORIZED, allTopsTxt);
    }

}
