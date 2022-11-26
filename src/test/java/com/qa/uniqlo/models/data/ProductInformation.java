package com.qa.uniqlo.models.data;

import java.util.List;

public class ProductInformation {

    private List<String> listOfProductName;
    private List<String> listOfProductPrice;

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


}
