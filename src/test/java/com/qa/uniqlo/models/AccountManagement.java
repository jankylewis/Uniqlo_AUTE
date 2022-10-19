package com.qa.uniqlo.models;

import com.google.gson.annotations.SerializedName;

public class AccountManagement {

    @SerializedName(value = "email")
    private String userEmail;
    @SerializedName(value = "pwd")
    private String userPassword;
    
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail= userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword= userPassword;
    }
}
