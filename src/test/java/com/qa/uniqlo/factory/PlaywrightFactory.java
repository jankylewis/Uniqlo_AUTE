package com.qa.uniqlo.factory;

import com.microsoft.playwright.*;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.qa.uniqlo.generalKeys.CommonHandling;

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
    CommonHandling cmhandler= new CommonHandling();
    public Page initBrowser(Properties prop) {
        String browserName= cmhandler.normalizeStr(prop.getProperty("browser"));
        boolean headlessMode= cmhandler.normalizeBool(prop.getProperty("headless"));
        String baseUrl= cmhandler.normalizeStr(prop.getProperty("baseUrl"));
        System.out.println("THE DESIRED BROWSER= "+ browserName);
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
                System.out.println("PLEASE PROVIDE A CORRECT BROWSER NAME >>");
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
