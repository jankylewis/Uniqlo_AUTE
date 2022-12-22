package com.qa.uniqlo.models.data;

import java.util.List;

public class ProductInformation {

    // this method is generated to facilitate verifying product information amongst pages
    private List<String> listOfProductName;
    private List<String> listOfProductPrice;
    private String productName;
    private Float productPrice;
    private String productSize;
    private String productColor;
    private String productQuantity;

    public List<String> getListOfProductPrice() {
        return listOfProductPrice;
    }

    public void setListOfProductPrice(List<String> listOfProductPrice) {
        this.listOfProductPrice= listOfProductPrice;
    }
    public List<String> getListOfProductName() {
        return listOfProductName;
    }

    public void setListOfProductName(List<String> listOfProductName) {
        this.listOfProductName= listOfProductName;
    }

    public void setProductName(String productName) {
        this.productName= productName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductPrice(Float productPrice) {
        this.productPrice= productPrice;
    }

    public Float getProductPrice() {
        return productPrice;
    }

    public void setProductSize(String productSize) {
        this.productSize= productSize;
    }

    public String getProductSize() {
        return productSize;
    }

    public void setProductColor(String productColor) {
        this.productColor= productColor;
    }

    public String getProductColor() {
        return productColor;
    }

    public void setProductQuantity(String productQuantity) {
        this.productQuantity= productQuantity;
    }

    public String getProductQuantity() {
        return productQuantity;
    }



}
