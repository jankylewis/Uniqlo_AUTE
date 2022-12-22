package com.qa.uniqlo.pages;

import com.microsoft.playwright.Page;
import com.qa.uniqlo.generalKeys.CommonHandling;

public class ShoppingCartPage {

    private CommonHandling commonHandler= new CommonHandling();
    private Page page;

    public ShoppingCartPage(Page page) {
        this.page= page;
    }



}
