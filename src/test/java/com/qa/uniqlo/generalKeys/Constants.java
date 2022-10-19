package com.qa.uniqlo.generalKeys;

import java.util.Properties;

public class Constants {

    public static Properties prop;
    public static final String LOGIN_PATH= prop.getProperty("baseUrl")+ "member/"+"/login.html";
    public static final String REGISTER_PATH= prop.getProperty("baseUrl")+ "member/"+ "join.html";
    public static final String USERNAME= "Maxwell";
    public static final int timeOut1000ms= 1000;
    public static final int timeOut2000ms= 2000;
    public static final int timeOut3000ms= 3000;
    public static final int maxTimeOut= 30000;
    public static final int minTimeOut= 500;
}
