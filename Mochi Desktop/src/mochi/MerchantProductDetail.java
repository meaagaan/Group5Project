package mochi;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class MerchantProductDetail {
    private final StringProperty productName;
    private final StringProperty productPrice;

    public MerchantProductDetail(String productName, String productPrice) {
        this.productName = new SimpleStringProperty(productName);
        this.productPrice = new SimpleStringProperty(productPrice);
    }

    // Getters
    public String getProductName() {
        return productName.get();
    }

    public String getProductPrice() {
        return productPrice.get();
    }


    // Setters
    public void setproductName(String value) {
        productName.set(value);
    }

    public void setproductPrice(String value) {
        productPrice.set(value);
    }


    // Property Values
    public StringProperty productNameProperty() {
        return productName;
    }

    public StringProperty productPriceProperty() {
        return productPrice;
    }
}
