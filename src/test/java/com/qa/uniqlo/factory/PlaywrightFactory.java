package com.qa.uniqlo.factory;

import com.microsoft.playwright.*;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.qa.uniqlo.generalKeywords.CommonHandling;
import com.qa.uniqlo.utilities.Utils;
import com.qa.uniqlo.utilities.logs.Log;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PlaywrightFactory {

    private Playwright playwright;
    private BrowserType browserType;
    private Browser browser;
    private BrowserContext browserContext;
    private Page page;
    private Properties properties;
    private CommonHandling commonHandler= new CommonHandling();

    private static boolean isMac= Utils.getOSName()== Utils.OSName.MAC;
    private static boolean isWindows= Utils.getOSName()== Utils.OSName.WINDOWS;
    private static boolean isLinux= Utils.getOSName()== Utils.OSName.LINUX;
    private static boolean isUnknown= Utils.getOSName()== Utils.OSName.UNKNOWN;

    private boolean headful;
    private boolean headless;
    static {}

    private boolean isHeadful() {
        String headfulEnv= System.getenv("headful".toUpperCase());
        headful= headfulEnv!= null && !"0".equals(headfulEnv) && !"false".equals(headfulEnv);
        return headful;
    }

    private boolean isChromium() {
        return commonHandler.verifyIfStringIsEqualized(
                "chromium", properties.getProperty("browser"));
    }

    private boolean isWebkit() {
        return commonHandler.verifyIfStringIsEqualized(
                "webkit", properties.getProperty("webkit"));
    }

    private boolean isFirefox() {
        return commonHandler.verifyIfStringIsEqualized(
                "firefox", properties.getProperty("firefox"));
    }

    private String getBrowserChannelFromEnv() {
        return System.getenv("browser.channel".toUpperCase());
    }

    private BrowserType.@NotNull LaunchOptions createLaunchOptions() {
        BrowserType.LaunchOptions launchOptions;
        launchOptions= new BrowserType.LaunchOptions();
        launchOptions.headless= !headful;
        launchOptions.channel= "";
        return launchOptions;
    }

    private BrowserContext createBrowserContext() {
        return browser.newContext();
    }

    @Contract(pure = true)
    private Playwright.@Nullable CreateOptions createPlaywrightOptions() {
        return null;
    }

    private void initBrowserType(Properties properties) {
        playwright= Playwright.create(createPlaywrightOptions());
        browserType= Utils.getBrowserTypeFromEnv(playwright, properties);
    }

    private void lauchBrowser(Properties properties, BrowserType.LaunchOptions launchOptions) {
        initBrowser(properties);
        browser= browserType.launch(launchOptions);
    }

    public Page initBrowser(@NotNull Properties properties) {
        String browserName= commonHandler.normalizeStr(properties.getProperty("browser"));
        boolean headlessMode= commonHandler.normalizeBool(properties.getProperty("headful"));
        String baseUrl= commonHandler.normalizeStr(properties.getProperty("baseUrl"));
        Log.info("THE DESIGNATED BROWSER= "+ browserName);
        // create a new playwright object
        playwright= Playwright.create();
        switch (browserName.toLowerCase()) {
            case "chromium":
                browser= playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(headlessMode));
                break;
            case "firefox":
                browser= playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(headlessMode));
                break;
            case "safari":
                browser= playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(headlessMode));
                break;
            case "chrome":
                browser= playwright.chromium().launch(new LaunchOptions().setChannel("chrome").setHeadless(headlessMode));
                break;
            default:
                Log.info("PLEASE ENTER A VALID BROWSER NAME >>");
                break;
        }
        // create a new browser context
        browserContext= browser.newContext();
        // create a new page
        page= browserContext.newPage();
        page.navigate(baseUrl);
        return page;
    }

    /*
        this method is generated to initialize the properties from
        the configuration file
     */
    public Properties init_prop() {
        try {
//            FileInputStream ips= new FileInputStream("./src/main/resources/config/config.properties");
            FileInputStream ips= new FileInputStream("./src/test/resources/config.properties");
            Log.info("GOT PROPERTIES FILE >>");
            properties= new Properties();
            properties.load(ips);
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return properties;
    }
}