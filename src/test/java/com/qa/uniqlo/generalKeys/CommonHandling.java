package com.qa.uniqlo.generalKeys;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitForSelectorState;
import com.microsoft.playwright.options.WaitUntilState;
import com.qa.uniqlo.base.AbstractTest;
import com.qa.uniqlo.utilities.logs.Log;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.testng.Assert;

import java.util.List;

import static com.microsoft.playwright.options.WaitForSelectorState.VISIBLE;

public class CommonHandling extends AbstractTest {

    private static String LOADING_INDICATOR= "//div[@data-test= \"loadingIndicator\"][span]";

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
        Log.info("CLICK ON SELECTOR= "+ expSelector);
    }

    public static void procrastinate(int timeOut) throws Exception {
        Thread.sleep(timeOut);
    }

    @Contract(pure = true)
    public static @NotNull Boolean verifyIfStringIsContained(
            @NotNull String expTxt, String toBeVerifiedTxt) {
        String expTxtNormalized= expTxt.toLowerCase();
        String toBeVerifiedTxtNormalized= toBeVerifiedTxt.toLowerCase();
        boolean comparison= expTxtNormalized.contains(toBeVerifiedTxtNormalized);
        if (comparison) {
//            Log.info("VERIFY IF {"+ expTxt+ "} CONTAINS {"+ toBeVerifiedTxt+ "}");
            Log.info("{"+ expTxt+ "} CONTAINED {"+ toBeVerifiedTxt+ "}");
        }
        return comparison;
    }

    public static @NotNull boolean verifyIfStringIsEqualized(
            @NotNull String expTxt, String toBeVerifiedTxt) {
        return (expTxt.toLowerCase()).equals(toBeVerifiedTxt.toLowerCase());
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

    public static boolean compareIntLessEqualNumbers(int smaller, int bigger) {
        if (smaller<= bigger) {
            Log.info("THE INPUTTED NUMBER IS SMALLER >>   ");
            return true;
        }
        else {
            Log.info("THE INPUTTED NUMBER IS BIGGER >>   ");
            return false;
        }
    }

    public static void verifyIfSelectorHasTxt(String expSelector, String expTxt) {
        Log.info("VERIFY IF "+ expSelector+ " HAS TEXT "+ expTxt+ " >>  ");
        String actTxt= AbstractTest.page.textContent(expSelector);
        verifyIfStringIsEqual(expTxt, actTxt);
    }

    public static boolean verifyIfElementIsPresented(@NotNull String expSelector) {
        Log.info("VERIFY IF "+ expSelector+ " IS VISIBLE >>  ");
        Locator.IsVisibleOptions isVisibleOptions= new Locator.IsVisibleOptions();
        return AbstractTest.page.locator(expSelector).isVisible(isVisibleOptions.setTimeout(Double.valueOf(Constants.MAXTIMEOUT)));
    }

    @Contract(pure = true)
    public static boolean verifyIfListIsEqual(@NotNull List<String> expList, List<String> actList) {
        boolean isEqual;
        Log.info("VERIFY IF THE EXP LIST IS EQUAL TO THE ACT LIST >>   ");
        if (expList.equals(actList)) {
            isEqual = true;
            Log.info("SUCCESSFULLY VERIFIED: EXP LIST IS EQUAL TO ACT LIST >>    ");
        }
        else {
            isEqual = false;
            Log.error("UNSUCCESSFULLY VERIFIED: EXP LIST IS NOT EQUAL TO ACT LIST >>    ");
            Assert.fail("UNSUCCESSFULLY VERIFIED: EXP LIST IS NOT EQUAL TO ACT LIST >>    ");
        }
        return isEqual;
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

    public static void waitForPageToLoad(@NotNull LoadState loadState, int timeOut) throws Exception{
        Page.WaitForLoadStateOptions waitForLoadStateOptions= new Page.WaitForLoadStateOptions();
        if (verifyIfStringIsContained(loadState.toString(), Constants.LOAD_STATE.toString())) {
            Thread.sleep(timeOut);
            AbstractTest.page.waitForLoadState(Constants.LOAD_STATE, waitForLoadStateOptions.setTimeout(Double.valueOf(Constants.MAXTIMEOUT)));
        }
        if (verifyIfStringIsContained(loadState.toString(), Constants.DOM_CONTENT_LOADED_STATE.toString())) {
            Thread.sleep(timeOut);
            AbstractTest.page.waitForLoadState(Constants.DOM_CONTENT_LOADED_STATE, waitForLoadStateOptions.setTimeout(Double.valueOf(Constants.MAXTIMEOUT)));
        }
        if (verifyIfStringIsContained(loadState.toString(), Constants.NETWORK_IDLE_STATE.toString())) {
            Thread.sleep(timeOut);
            AbstractTest.page.waitForLoadState(Constants.NETWORK_IDLE_STATE, waitForLoadStateOptions.setTimeout(Double.valueOf(Constants.MAXTIMEOUT)));
        }
//        AbstractTest.page.waitForLoadState(LoadState.valueOf((loadState).toString().toUpperCase()));
    }

    public static void waitElementToBeVisible(String expSelector, WaitForSelectorState waitForSelectorState) {
        int timeOut= Constants.MAXTIMEOUT;
        Locator.WaitForOptions waitForOptions= new Locator.WaitForOptions();
        AbstractTest.page.locator(expSelector).waitFor(waitForOptions.setState(waitForSelectorState).setTimeout(timeOut));
    }

    public static void waitForSelectorIsVisible(String expSelector) {
        int maxTimeOut= Constants.TIMEOUT3000MS * 10;
        Page.WaitForSelectorOptions waitForSelectorOptions= new Page.WaitForSelectorOptions();
        AbstractTest.page.waitForSelector(expSelector, waitForSelectorOptions.setState(Constants.VISIBLE_STATE).setTimeout(maxTimeOut));
    }

    public static void waitForSelectorIsDetached(String expSelector) {
        int timeOut3s= Constants.TIMEOUT3000MS;
        Page.WaitForSelectorOptions waitForSelectorOptions= new Page.WaitForSelectorOptions();
        AbstractTest.page.waitForSelector(expSelector, waitForSelectorOptions.setState(Constants.DETACHED_STATE).setTimeout(timeOut3s));
    }

    public static void waitForSelectorIsHidden(String expSelector) {
        int timeOut3s= Constants.TIMEOUT3000MS;
        Page.WaitForSelectorOptions waitForSelectorOptions= new Page.WaitForSelectorOptions();
        AbstractTest.page.waitForSelector(expSelector, waitForSelectorOptions.setState(Constants.HIDDEN_STATE).setTimeout(timeOut3s));
    }

    public static void waitForSelectorIsAttached(String expSelector) {
        int timeOut3s= Constants.TIMEOUT3000MS;
        Page.WaitForSelectorOptions waitForSelectorOptions= new Page.WaitForSelectorOptions();
        AbstractTest.page.waitForSelector(expSelector, waitForSelectorOptions.setState(Constants.ATTACHED_STATE).setTimeout(timeOut3s));
    }

    public static void waitForLoadingIndicatorToBeVisible() throws Exception {
        if (verifyIfElementIsPresented(LOADING_INDICATOR)!=true) {
            Log.info("WAITING LOADING INDICATOR TO BE VISIBLE >>    ");
//            AbstractTest.page.locator(LOADING_INDICATOR).waitFor(new Locator.WaitForOptions().setState(Constants.HIDDEN_STATE).setTimeout(Constants.MAXTIMEOUT));
            waitForPageToLoad(Constants.LOAD_STATE, Constants.TIMEOUT5000MS);
//            AbstractTest.page.waitForLoadState(Constants.LOAD_STATE, Constants.MAXTIMEOUT);
            Log.info("LOCATED THE LOADING INDICATOR >>    ");
        }
        else {
            Log.info("LOADING INDICATOR IS VISIBLE >>    ");
        }
    }

    public static void navigateToUrl(String destination) {
        AbstractTest.page.navigate(destination, new Page.NavigateOptions().setWaitUntil(Constants.WAIT_UNTIL_LOAD_STATE));
    }

    @Contract(pure = true)
    public static @NotNull String removeVndAbbreviation(@NotNull String expStr) {
        String removedStr= expStr.replace(" VND", "");
        return removedStr;
    }





}
