package com.qa.uniqlo.factory;

import com.microsoft.playwright.*;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.qa.uniqlo.generalKeys.CommonHandling;
import com.qa.uniqlo.utilities.logs.Log;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PlaywrightFactory {

    Playwright pw;
    Browser brs;
    BrowserContext brsContext;
    Page page;
    Properties prop;
    CommonHandling commonHandler= new CommonHandling();
    final boolean isMac= false;
    final boolean isWindows= false;
    final boolean headful= commonHandler.normalizeBool(
            prop.getProperty("headful")
    );
    final boolean headless= !headful;
    static {

    }

    public Page initBrowser(Properties prop) {
        String browserName= commonHandler.normalizeStr(prop.getProperty("browser"));
//        boolean headlessMode;
        boolean headfulMode;
        boolean headlessMode= commonHandler.normalizeBool(prop.getProperty("headless"));
        String baseUrl= commonHandler.normalizeStr(prop.getProperty("baseUrl"));
        Log.info("THE DESIGNATED BROWSER= "+ browserName);
        pw= Playwright.create();
        switch (browserName.toLowerCase()) {
            case "chromium":
                brs= pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(headlessMode));
                break;
            case "firefox":
                brs= pw.firefox().launch(new BrowserType.LaunchOptions().setHeadless(headlessMode));
                break;
            case "safari":
                brs= pw.webkit().launch(new BrowserType.LaunchOptions().setHeadless(headlessMode));
                break;
            case "chrome":
                brs= pw.chromium().launch(new LaunchOptions().setChannel("chrome").setHeadless(headlessMode));
                break;
            default:
                Log.info("PLEASE ENTER A VALID BROWSER NAME >>");
                break;
        }
        brsContext= brs.newContext();
        page= brsContext.newPage();
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
            prop= new Properties();
            prop.load(ips);
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return prop;
    }
}