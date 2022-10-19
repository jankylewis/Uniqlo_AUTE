package com.qa.uniqlo.generalKeys;

import com.qa.uniqlo.base.AbstractTest;
import org.jetbrains.annotations.NotNull;
import org.testng.Assert;

public class CommonHandling extends AbstractTest {

    public static String normalizeStr(@NotNull String expStr) {
        return expStr.trim().toLowerCase();
    }

    public static Boolean normalizeBool(@NotNull String expBool) {
        return Boolean.parseBoolean(expBool.trim().toLowerCase());
    }

    public static void setTxtIntoElement(
            String expSelector,
            String expStr) {
        AbstractTest.page.waitForSelector(expSelector);
        System.out.println("FOUND SELECTOR= "+ expSelector);
        AbstractTest.page.click(expSelector);
        AbstractTest.page.fill(expSelector,"");
        AbstractTest.page.fill(expSelector,expStr);
    }

    public static void clickOnElement(String expSelector) {
        AbstractTest.page.waitForSelector(expSelector);
        System.out.println("FOUND SELECTOR= "+ expSelector);
        AbstractTest.page.click(expSelector);
    }

    public static void procrastinateWithTimeOut(
            int timeOut){
        try {
            Thread.sleep(timeOut);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static Boolean verifyIfStringIsContained(
            String expTxt, String toBeVerifiedTxt) {
        return expTxt.contains(toBeVerifiedTxt);
    }

    public static void verifyIfStringIsEqual(String expTxt, String actTxt) {
        String expTxtNormalized= expTxt.trim().toLowerCase();
        String actTxtNormalized= actTxt.trim().toLowerCase();
        Assert.assertEquals(expTxtNormalized, actTxtNormalized);
    }

    public static void verifyIfIntNumberIsEqual(int expInt, int actInt) {
        Assert.assertEquals(expInt, actInt);
    }

    public static void verifyIfFloatNumberIsEqual(Float expFloat, Float actFloat) {
        Assert.assertEquals(expFloat, actFloat);
    }

    public static void verifyIfSelectorHasTxt(String expSelector, String expTxt) {
        String actTxt= AbstractTest.page.textContent(expSelector);
        verifyIfStringIsEqual(expTxt, actTxt);
    }

    public void hoverOnElement(String expSelector) {
        AbstractTest.page.waitForSelector(expSelector);
        System.out.println("FOUND SELECTOR= "+ expSelector);
        AbstractTest.page.locator(expSelector).hover();
    }

    public void mouseOnSpecificLocation() {
//        AbstractTest.page.hover("", Locator.HoverOptions);
//        AbstractTest.page.locator("").hover();
    }





}
