package com.qa.uniqlo.utilities;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import com.qa.uniqlo.generalKeywords.CommonHandling;
import com.qa.uniqlo.utilities.logs.Log;
import org.jetbrains.annotations.Nullable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Utils {

    private static CommonHandling commonHandler= new CommonHandling();
    private static Properties properties;

    public enum OSName {WINDOWS, MAC, LINUX, UNKNOWN};
    public static OSName getOSName() {
        String osName= commonHandler.normalizeStr(System.getProperty(("os.name")));
        if (commonHandler.verifyIfStringIsContained(osName, "win")) {
            return OSName.WINDOWS;
        }
        if (commonHandler.verifyIfStringIsContained(osName, "mac os x")) {
            return OSName.MAC;
        }
        if (commonHandler.verifyIfStringIsContained(osName, "linux")) {
            return OSName.LINUX;
        }
        return OSName.UNKNOWN;
    }

    public static void setBrowserName() {

    }

    public static @Nullable String getBrowserName(Properties properties) {
        String browserName= commonHandler.normalizeStr(properties.getProperty("browser"));
        return browserName;
//        String browserName= System.getenv("BROWSER");
//        if (browserName== null) {
//            browserName= "chromium";
//        }
//        return browserName;
    }

    public static BrowserType getBrowserTypeFromEnv(
            Playwright playwright,
            Properties properties) {
        String browserName= getBrowserName(properties);
        switch (browserName) {
            case "safari":
                return playwright.webkit();
            case "webkit":
                return playwright.webkit();
            case "chromium":
                return playwright.chromium();
            case "firefox":
                return playwright.firefox();
            default:
                throw new IllegalArgumentException("UNKNOWN BROWSER: "+ browserName);
        }
    }

    public static void verifyViewPort() {

    }

    public static Properties getProperties() {
        try {
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
