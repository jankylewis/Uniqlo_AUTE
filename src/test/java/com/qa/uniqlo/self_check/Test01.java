package com.qa.uniqlo.self_check;

public class Test01 {

    public static void main (String[] args) {
        System.out.println("");
//        System.out.println("OS NAME= "+ System.getProperty("os.name"));
//        System.out.println("OS ARCHITECTURE= "+ System.getProperty("os.arch"));
//        System.out.println("OS VERSION= "+ System.getProperty("os.version"));
//        System.out.println(""+ getOS());
        System.out.println(System.getenv("BROWSER_CHANNEL"));
        boolean headful;
        String headfulEnv = System.getenv("HEADFUL");
        headful =!"0".equals(headfulEnv) && !"false".equals(headfulEnv);
        System.out.println(headful);
    }

    enum OS { WINDOWS, MAC, LINUX, UNKNOWN }
    static OS getOS() {
        String osName= System.getProperty("os.name").toLowerCase();
        if (osName.contains("win")) {
            return OS.WINDOWS;
        }
        if (osName.contains("linux")) {
            return OS.LINUX;
        }
        if (osName.contains("mac os x")) {
            return OS.MAC;
        }
        return OS.UNKNOWN;
    }

}
