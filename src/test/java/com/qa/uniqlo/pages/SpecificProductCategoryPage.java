package com.qa.uniqlo.pages;

import com.microsoft.playwright.Page;
import com.qa.uniqlo.generalKeys.CommonHandling;

public class SpecificProductCategoryPage {

    private CommonHandling commonHandler= new CommonHandling();
    private Page page;
    private String LBL_PRODUCT_NAME_CHILD= "//div[@id and contains(@class, \"fr-product-card default\")]//h2";
    private String CTA_LOAD_MORE= "//div[@data-test= \"globalNavRoot\"]//following::span[contains(text(), \"Load more\")]";
    private String DDL_SORTED_BY= "//div[@type= \"button\" and @role][span[contains(text(), \"Featured\")]]";
    private String DDI_SORTED_BY_NEW_ARRIVALS= "//ul[@role= \"listbox\"]//li[contains(text(), \"New arrivals\")]";
    private String DDI_SORTED_BY_LOW_TO_HIGH= "//ul[@role= \"listbox\"]//li[contains(text(), \"Low to high\")]";
    private String DDI_SORTED_BY_HIGH_TO_LOW= "//ul[@role= \"listbox\"]//li[contains(text(), \"High to low\")]";
    private String DDI_SORTED_BY_TOP_RATED= "//ul[@role= \"listbox\"]//li[contains(text(), \"Top rated\")]";





    public SpecificProductCategoryPage(Page page) {
        this.page= page;
    }

}
