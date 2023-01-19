package com.qa.uniqlo.pages.shoppingCartPage;

import com.microsoft.playwright.Page;
import com.qa.uniqlo.generalKeywords.CommonHandling;

public class CouponPage {

    private Page page;
    private CommonHandling commonHandler= new CommonHandling();

    public CouponPage (Page page) {
        this.page= page;
    }

}
