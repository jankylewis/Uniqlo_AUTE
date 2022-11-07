package com.qa.uniqlo.generalKeys;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitForSelectorState;
import com.qa.uniqlo.base.AbstractTest;
import com.qa.uniqlo.utilities.logs.Log;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.testng.Assert;

import static com.microsoft.playwright.options.WaitForSelectorState.VISIBLE;

public class CommonHandling extends AbstractTest {

    public static @NotNull String normalizeStr(@NotNull String expStr) {
        Log.info("NORMALIZED STR: "+ expStr);
        return expStr.trim().toLowerCase();
    }

    public static @NotNull Boolean normalizeBool(@NotNull String expBool) {
        Log.info("NORMALIZED STR: "+ expBool);
        return Boolean.parseBoolean(expBool.trim().toLowerCase());
    }

    public static void setTxtIntoElement(
            String expSelector,
            String expStr) {
        AbstractTest.page.waitForSelector(expSelector);
        Log.info("FOUND SELECTOR= "+ expSelector);
        AbstractTest.page.click(expSelector);
        AbstractTest.page.fill(expSelector,"");
        AbstractTest.page.fill(expSelector,expStr);
    }

    public static void clickOnElement(String expSelector) {
        AbstractTest.page.waitForSelector(expSelector);
        Log.info("FOUND SELECTOR= "+ expSelector);
        AbstractTest.page.click(expSelector);
    }

    public static void procrastinate(int timeOut) throws Exception {
        Thread.sleep(timeOut);
    }

    @Contract(pure = true)
    public static @NotNull Boolean verifyIfStringIsContained(
            @NotNull String expTxt, String toBeVerifiedTxt) {
        String expTxtNormalized= expTxt.toLowerCase();
        String toBeVerifiedTxtNormalized= toBeVerifiedTxt.toLowerCase();
        Log.info("VERIFY IF {"+ expTxt+ "} CONTAINS {"+ toBeVerifiedTxt+ "}");
        return expTxtNormalized.contains(toBeVerifiedTxtNormalized);
    }

    public static @NotNull boolean verifyIfStringIsEqualized(
            @NotNull String expTxt, String toBeVerifiedTxt) {
        return expTxt.equals(toBeVerifiedTxt);
    }

    public static void verifyIfStringIsEqual(@NotNull String expTxt, @NotNull String actTxt) {
        String expTxtNormalized= expTxt.trim().toLowerCase();
        String actTxtNormalized= actTxt.trim().toLowerCase();
        Log.info("VERIFY IF {"+ expTxt+ "} IS EQUAL TO {"+ actTxt+ "}");
        Assert.assertEquals(expTxtNormalized, actTxtNormalized);
    }

    public static void verifyIfIntNumberIsEqual(int expInt, int actInt) {
        Log.info("VERIFY IF {" + expInt+ "} IS EQUAL TO {"+ actInt+ "}");
        Assert.assertEquals(expInt, actInt);
    }

    public static void verifyIfFloatNumberIsEqual(Float expFloat, Float actFloat) {
        Log.info("VERIFY IF {" + expFloat+ "} IS EQUAL TO {"+ actFloat+ "}");
        Assert.assertEquals(expFloat, actFloat);
    }

    public static void verifyIfSelectorHasTxt(String expSelector, String expTxt) {
        Log.info("VERIFY IF "+ expSelector+ " HAS TEXT "+ expTxt+ " >>  ");
        String actTxt= AbstractTest.page.textContent(expSelector);
        verifyIfStringIsEqual(expTxt, actTxt);
    }

    public static boolean verifyIfElementIsPresented(@NotNull String expSelector) {
        Log.info("VERIFY IF "+ expSelector+ " IS VISIBLE >>  ");
        return AbstractTest.page.locator(expSelector).isVisible();
    }

    public static void scrollToElement(@NotNull String expSelector) {
        Log.info("TRYING TO FOCUS ON ELEMENT >>  ");
        AbstractTest.page.locator(expSelector).focus();
        Log.info("TRYING TO SCROLL TO ELEMENT >>  ");
        AbstractTest.page.locator(expSelector).scrollIntoViewIfNeeded();
    }

    public static void hoverOnElement(String expSelector) {
        AbstractTest.page.waitForSelector(expSelector);
        Log.info("HOVERED SELECTOR= "+ expSelector);
        AbstractTest.page.locator(expSelector).hover();
    }

    public static void mouseOnSpecificLocation() {
//        AbstractTest.page.hover("", Locator.HoverOptions);
//        AbstractTest.page.locator("").hover();
    }

    public static void keyPressedEnter() {
        AbstractTest.page.keyboard().press("Enter");
        Log.info("PRESSED ENTER >>");
    }

    public static void waitForPageToLoad(@NotNull LoadState loadState) {
        AbstractTest.page.waitForLoadState(LoadState.valueOf((loadState).toString().toUpperCase()));
    }

    public static void waitElementToBeVisible(String expSelector, int timeOut, WaitForSelectorState waitForSelectorState) {
//        AbstractTest.page.locator(expSelector).waitFor(Locator.WaitForOption);
    }






}
