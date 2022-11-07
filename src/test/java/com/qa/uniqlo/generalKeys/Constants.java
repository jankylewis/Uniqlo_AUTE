package com.qa.uniqlo.generalKeys;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitForSelectorState;

import java.util.Properties;

public class Constants {

    public static Properties prop;
    public static final String USERNAME= "Maxwell";
    public static final int TIMEOUT1000ms= 1000;
    public static final int TIMEOUT2000MS= 2000;
    public static final int TIMEOUT3000MS= 3000;
    public static final int MAXTIMEOUT= 30000;
    public static final int MINTIMEOUT= 500;
    public static final LoadState NETWORK_IDLE_STATE= LoadState.NETWORKIDLE;
    public static final LoadState LOAD_STATE= LoadState.LOAD;
    public static final LoadState DOM_CONTENT_LOADED_STATE= LoadState.DOMCONTENTLOADED;
    public static final WaitForSelectorState ATTACHED_STATE= WaitForSelectorState.ATTACHED;
    public static final WaitForSelectorState DETACHED_STATE= WaitForSelectorState.DETACHED;
    public static final WaitForSelectorState VISIBLE_STATE= WaitForSelectorState.VISIBLE;
    public static final WaitForSelectorState HIDDEN_STATE= WaitForSelectorState.HIDDEN;
}
